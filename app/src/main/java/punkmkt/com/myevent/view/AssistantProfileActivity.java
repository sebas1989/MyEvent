package punkmkt.com.myevent.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Calendar;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.database.Notification;
import punkmkt.com.myevent.database.Notification_Table;

public class AssistantProfileActivity extends AppCompatActivity {

    private LoginButton loginButton;
    public String TAG = AssistantProfileActivity.class.getName();
    CallbackManager callbackManager;
    private ProfilePictureView profilePictureView;
    private ImageView pictureProfile;
    private TextInputEditText name, lastname, company, position, website, email, phone, aboutme;
    private Spinner emailType, phoneType, gender;
    private SwitchCompat activateNotifications;

    private String TAG_NOTIFICATION_NEWS = "news";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant_profile);

        showToolBar(getResources().getString(R.string.user_profile), true);

        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        //profilePictureView = (ProfilePictureView) findViewById(R.id.assistantPicProfile);
        pictureProfile = (ImageView) findViewById(R.id.assistantProfile);
        name = (TextInputEditText) findViewById(R.id.assistantName);
        email = (TextInputEditText) findViewById(R.id.assistantEmail);
        lastname = (TextInputEditText) findViewById(R.id.assistantLastname);
        company = (TextInputEditText) findViewById(R.id.assistantCompany);
        position = (TextInputEditText) findViewById(R.id.assistantPosition);
        website = (TextInputEditText) findViewById(R.id.assistantWebsite);
        phone = (TextInputEditText) findViewById(R.id.assistantPhoneNumber);
        aboutme = (TextInputEditText) findViewById(R.id.aboutAssistant);

        emailType = (Spinner) findViewById(R.id.assistantMailType);
        phoneType = (Spinner) findViewById(R.id.assistantPhoneType);
        gender = (Spinner) findViewById(R.id.assistantSex);

        /*fbbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });*/
        //facebook logout
        facebookLogout();

        //FACEBOOK LOGIN
        loginButton = (LoginButton) findViewById(R.id.facebookLoginButton);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebookLogin();
                Toast.makeText(getApplicationContext(), "LogedIn", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Login canceled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Login error"+error.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        InitializeNotification(TAG_NOTIFICATION_NEWS);

        activateNotifications = (SwitchCompat) findViewById(R.id.mySwitch);
        activateNotifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    notificationUpdate(TAG_NOTIFICATION_NEWS, TAG_NOTIFICATION_NEWS);
                }
            }
        });
    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case android.R.id.home:
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void facebookLogin(){
        if (AccessToken.getCurrentAccessToken() != null) {
            Log.d("FB User token", AccessToken.getCurrentAccessToken().getToken());
            GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
            new GraphRequest.GraphJSONObjectCallback(){
                @Override
                public void onCompleted(JSONObject object, GraphResponse response) {
                if (response != null) {
                    Log.d(TAG, "response: "+object.toString());
                    setProfileToView(object);
                }else{
                    Log.d(TAG, "Falló");
                }
            }
            });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id, name, first_name, last_name, email, gender");
            graphRequest.setParameters(parameters);
            graphRequest.executeAsync();

        }else {
            Log.d(TAG,"No fbToken");
        }
    }

    private void setProfileToView(JSONObject jsonObject) {
        try {
            email.setText(jsonObject.getString("email"));
            name.setText(jsonObject.getString("first_name"));
            lastname.setText(jsonObject.getString("last_name"));

            Picasso.with(this)
                    .load("https://graph.facebook.com/" + jsonObject.getString("id") + "/picture?width=1500&height=908")
                    .into(pictureProfile);
            Log.d(TAG, "id : "+jsonObject.getString("id"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void facebookLogout() {
        Log.d(TAG,"disconnect faceebook");
        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }

        new GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, new GraphRequest
        .Callback() {
        @Override
        public void onCompleted(GraphResponse graphResponse) {
            LoginManager.getInstance().logOut();
        }
    }).executeAsync();
    }



    /*@Override
    protected void onPause() {

        // hide the keyboard in order to avoid getTextBeforeCursor on inactive InputConnection
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);

        super.onPause();
    }*/

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
    implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String finalMonth = "";
            String finalDay = "";
            if ( month < 10 && day < 10){
                finalMonth = "0" + month;
                finalDay = "0"+day;
            }else if ( month < 10 && day > 9 ){
                finalMonth = "0" + month;
                finalDay = ""+day;
            }else if ( day < 10 && month > 9) {
                finalMonth = ""+month;
                finalDay = "0"+day;
            }else {
                finalMonth = ""+month;
                finalDay = ""+day;
            }

            String birthdayInput = ( year + "-" + finalMonth + "-" + finalDay );
            Log.w("DatePicker","Date = " + birthdayInput);
            TextInputEditText birthday = (TextInputEditText) getActivity().findViewById(R.id.assistantBirthDay);
            birthday.setFocusable(true);
            birthday.setText(birthdayInput.toString());

        }
    }

    public void notificationUpdate(String notification, String type){
        try {
            final Notification notificacion = new Select().from(Notification.class).where(Notification_Table.name.eq(notification)).querySingle();
            int active = notificacion.getActive();
            if (active == 1) {
                FirebaseMessaging.getInstance().unsubscribeFromTopic(notification);
                notificacion.setActive(0);
                notificacion.setType(type);
                notificacion.update();
                Log.d("Not Conf", "Unsubscribed to "+notification+" topic");
            }
            else {
                //update
                FirebaseMessaging.getInstance().subscribeToTopic(notification);
                notificacion.setActive(1);
                notificacion.setType(type);
                notificacion.update();
                Log.d("Not Conf", "Subscribed to "+notification+" topic");
            }

        }
        catch (Throwable e) {
            FirebaseMessaging.getInstance().subscribeToTopic(notification);
            Notification notificacion = new Notification();
            notificacion.setName(notification);
            notificacion.setActive(1);
            notificacion.setType(type);
            notificacion.save();
            Log.d("Not Conf", "Subscribed to "+notification+" topic");
        }
    }

    public void InitializeNotification(String notification){
        try {
            final Notification notificacion = new Select().from(Notification.class).where(Notification_Table.name.eq(notification)).querySingle();
            int active = notificacion.getActive();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
