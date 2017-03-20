package punkmkt.com.myevent.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.view.fragment.DiaryFragment;
import punkmkt.com.myevent.view.fragment.NotesFragment;

public class SendNewFeedActivity extends AppCompatActivity {

    private TextInputEditText writeThought;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_new_feed);

        showToolBar(getResources().getString(R.string.share), true);
        //writeThought = (TextInputEditText) findViewById(R.id.sendUrComment);

    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_cancel_button);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return true;
    }

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
    public void onBackPressed() {
        // If the fragment exists and has some back-stack entry
        NotesFragment notesFragment= new NotesFragment();
        if (notesFragment != null && notesFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            notesFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

}
