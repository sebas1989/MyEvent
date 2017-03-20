package punkmkt.com.myevent.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import punkmkt.com.myevent.R;

public class NewsFeedDetailActivity extends AppCompatActivity {

    private TextView newDescription;
    private TextInputEditText addComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed_detail);
        showToolBar("", true);

        //Spanned spanned = Html.fromHtml("El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales. <img src=\'http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg\' />");
        newDescription = (TextView) findViewById(R.id.newDescription);
        String description = "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales. El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales. El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.";
        newDescription.setText(description);

        Intent intent = getIntent();
        String inf = intent.getStringExtra("adjust");
        //Toast.makeText(this,inf,Toast.LENGTH_LONG).show();
        if ( inf.equals("adjustWindow") ){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }else{
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        }
    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }
}
