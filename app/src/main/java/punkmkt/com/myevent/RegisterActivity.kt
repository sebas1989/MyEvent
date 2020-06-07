package punkmkt.com.myevent

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.AsyncTask
import android.os.Build
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ClickableSpan
import android.util.Base64
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import punkmkt.com.myevent.view.AssistantProfileActivity
import punkmkt.com.myevent.view.LoginActivity
import punkmkt.com.myevent.view.MainFacilitySlideImageActivity

import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonObjectRequest
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Array
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.Arrays
import java.util.HashMap

class RegisterActivity : AppCompatActivity() {

    private var mAuthTask: UserRegisterTask? = null
    private var logInText: TextView? = null
    private var loginButton: LoginButton? = null
    private var email: TextInputEditText? = null
    private var pass: TextInputEditText? = null
    private var completeRegistration: Button? = null
    var TAG = RegisterActivity::class.java!!.getName()
    internal var callbackManager: CallbackManager

    private val EVENT_REGISTER_URL = "http://104.131.105.220:8080/api/v1/rest-auth/registration/"
    private val EVENT_FBLOGIN_URL = "http://104.131.105.220:8080/api/v1/rest-auth/facebook/"
    private val TOKEN = "f5044d4106f6c8c7df47fd21bfe6b59a115b4d74"

    //UI refrences
    private var mProgressView: View? = null
    private var mLoginFormView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(this.applicationContext)
        setContentView(R.layout.activity_register)

        val EVENT_ID = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).getString("EVENT_ID", null)

        showToolBar(resources.getString(R.string.register), true)

        //FacebookSdk.sdkInitialize(this.getApplicationContext());
        //FacebookSdk.isInitialized();
        callbackManager = CallbackManager.Factory.create()

        //name = (TextInputEditText) findViewById(R.id.userName);
        email = findViewById(R.id.userEmail) as TextInputEditText
        pass = findViewById(R.id.userPassword) as TextInputEditText

        completeRegistration = findViewById(R.id.registerButon) as Button
        completeRegistration!!.setOnClickListener { creatAccount() }

        logInText = findViewById(R.id.logInText) as TextView

        logInText!!.setOnClickListener {
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        /*try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "punkmkt.com.myevent",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }*/

        loginButton = findViewById(R.id.facebookLoginButton) as LoginButton
        loginButton!!.setReadPermissions(Arrays.asList("public_profile", "email"))
        loginButton!!.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                facebookRegistration()
                Toast.makeText(applicationContext, "LogedIn", Toast.LENGTH_SHORT).show()
            }

            override fun onCancel() {
                Toast.makeText(applicationContext, "Login canceled", Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext, "Login error" + error.message.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        //Toast.makeText(getApplicationContext(), "Login error key facebook", Toast.LENGTH_SHORT).show();
        Toast.makeText(applicationContext, EVENT_ID, Toast.LENGTH_SHORT).show()

        mLoginFormView = findViewById(R.id.login_form)
        mProgressView = findViewById(R.id.login_progress)
    }

    fun showToolBar(title: String, upButton: Boolean) {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(title)
        supportActionBar!!.setDisplayHomeAsUpEnabled(upButton)

        val collapsingToolbarLayout = findViewById(R.id.collapsingToolbar) as CollapsingToolbarLayout
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    fun creatAccount() {

        if (mAuthTask != null) {
            return
        }

        val userEmail = email!!.text.toString()
        val userPasswd = pass!!.text.toString()
        var cancel = false
        var focusView: View? = null
        // Validate the sign up data
        var validationError = false

        email!!.error = null
        pass!!.error = null

        if (TextUtils.isEmpty(userPasswd)) {
            validationError = true
            cancel = true
            focusView = pass
            pass!!.error = getString(R.string.error_field_required)
        }
        if (!isPasswordValid(userPasswd)) {
            validationError = true
            cancel = true
            focusView = pass
            pass!!.error = getString(R.string.error_invalid_password)
        }
        if (!isValidEmail(userEmail)) {
            validationError = true
            focusView = email
            email!!.error = getString(R.string.error_invalid_email)
            cancel = true
        }
        if (!isValidEmailLenght(userEmail)) {
            validationError = true
            email!!.error = getString(R.string.error_invalid_email_lenght)
            focusView = email
            cancel = true
        }
        if (cancel) {
            focusView!!.requestFocus()
        } else {

            showProgress(true)
            val js = JSONObject()
            try {
                js.put("email", userEmail)
                js.put("password1", userPasswd)
                js.put("password2", userPasswd)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            mAuthTask = UserRegisterTask(userEmail, userPasswd)
            val jsonObjectRequest = object : JsonObjectRequest(Request.Method.POST,
                    EVENT_REGISTER_URL, js,
                    Response.Listener<JSONObject> { response ->
                        try {
                            val jsObject = response
                            getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE).edit().putString("EVENT_ID", jsObject.getString("pk").toString()).commit()
                            //getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("access_token", key).commit();
                            Log.d("Response", jsObject.toString())
                            mAuthTask!!.execute(null as Void?)
                        } catch (e: Exception) {
                            e.printStackTrace()
                            //alert con error
                            showProgress(false)
                        }
                    }, Response.ErrorListener { error ->
                VolleyLog.d("V", "Error: " + error.message)
                showProgress(false)
                var json: String? = null
                val response = error.networkResponse
                mAuthTask!!.onCancelled()
                if (response != null && response.data != null) {
                    when (response.statusCode) {
                        400 -> {
                            json = String(response.data)
                            try {
                                val obj = JSONObject(json)
                                Log.d(TAG, obj.toString())

                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }

                        }
                        500 -> {
                            Log.d(TAG, "error 500")
                            val intent = Intent(application, AssistantProfileActivity::class.java)
                            startActivity(intent)
                            try {
                                Toast.makeText(applicationContext, "Ha ocurrido un error al tratar de iniciar sesión, intenta nuevamente.", Toast.LENGTH_LONG).show()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                        }
                        else -> {
                        }
                    }
                }
            }
            ) {
                //Passing some request headers
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val headers = HashMap<String, String>()
                    headers.put("Content-Type", "application/json; charset=utf-8")
                    //headers.put("Authorization", "Token "+ Ukey);
                    return headers
                }
            }
            jsonObjectRequest.retryPolicy = DefaultRetryPolicy(
                    9000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            MySingleton.getInstance().addToRequestQueue(jsonObjectRequest)
        }

    }

    private fun isValidEmail(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun isValidEmailLenght(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.length > 4
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 7
    }


    fun facebookRegistration() {
        if (AccessToken.getCurrentAccessToken() != null) {
            Log.d("FB User token", AccessToken.getCurrentAccessToken().token)
            val js = JSONObject()
            try {
                js.put("access_token", AccessToken.getCurrentAccessToken().token)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            val jsonObjectRequest = object : JsonObjectRequest(Request.Method.POST, EVENT_FBLOGIN_URL, js,
                    Response.Listener<JSONObject> { response ->
                        try {
                            Log.d("Response", response.toString())
                            val intent = Intent(application, AssistantProfileActivity::class.java)
                            startActivity(intent)
                            //JSONObject object = response;
                            /*if (object.has("key")){
                                    String key = object.optString("key");
                                    Log.d(TAG,key);
                                    getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putString("access_token", key).commit();
                                    //getuserprofile(key,false);
                                    if(intent_from == null){
                                        Intent myIntent = new Intent(getApplicationContext(), WelcomeActivity.class);
                                        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(myIntent);
                                        finish();
                                    }
                                    else{
                                        if(intent_from.equalsIgnoreCase(INTENT_FROM_CONF)){
                                            Intent myIntent = new Intent(getApplicationContext(), UbicaTuAsientoActivity.class);
                                            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(myIntent);
                                            finish();
                                        }
                                        else{
                                            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                                            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            startActivity(myIntent);
                                            finish();
                                        }
                                    }

                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Login error key facebook", Toast.LENGTH_SHORT).show();
                                }*/
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }, Response.ErrorListener { }) {
                //Passing some request headers
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val headers = HashMap<String, String>()
                    headers.put("Content-Type", "application/json; charset=utf-8")
                    //headers.put("Authorization", "Token "+ TOKEN);
                    return headers
                }
            }

            MySingleton.getInstance().addToRequestQueue(jsonObjectRequest)

        } else {
            Log.d(TAG, "No fbToken")
        }
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)

            mLoginFormView!!.visibility = if (show) View.GONE else View.VISIBLE
            mLoginFormView!!.animate().setDuration(shortAnimTime.toLong()).alpha(
                    (if (show) 0 else 1).toFloat()).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    mLoginFormView!!.visibility = if (show) View.GONE else View.VISIBLE
                }
            })

            mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
            mProgressView!!.animate().setDuration(shortAnimTime.toLong()).alpha(
                    (if (show) 1 else 0).toFloat()).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
                }
            })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView!!.visibility = if (show) View.VISIBLE else View.GONE
            mLoginFormView!!.visibility = if (show) View.GONE else View.VISIBLE
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    inner class UserRegisterTask internal constructor(private val mEmail: String, private val mPassword: String) : AsyncTask<Void, Void, Boolean>() {

        override fun doInBackground(vararg params: Void): Boolean? {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                return false
            }

            /*for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mEmail);
                }
            }*/

            // TODO: register the new account here.
            return true
        }

        override fun onPostExecute(success: Boolean?) {
            mAuthTask = null
            showProgress(false)

            if (success!!) {
                finish()
                val intent = Intent(applicationContext, AssistantProfileActivity::class.java)
                startActivity(intent)
            } else {
                pass!!.error = getString(R.string.error_incorrect_password)
                pass!!.requestFocus()
            }
        }

        public override fun onCancelled() {
            mAuthTask = null
            showProgress(false)
        }
    }

    companion object {

        /**
         * A dummy authentication store containing known user names and passwords.
         * TODO: remove after connecting to a real authentication system.
         */
        private val DUMMY_CREDENTIALS = arrayOf("foo@example.com:hello", "bar@example.com:world")
    }

}
