package punkmkt.com.myevent.view;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import punkmkt.com.myevent.MainActivity;
import punkmkt.com.myevent.R;
import punkmkt.com.myevent.view.fragment.DiaryFragment;
import punkmkt.com.myevent.view.fragment.NotesFragment;

public class DiaryConferenceViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_conference_view);

        showToolBar(getResources().getString(R.string.conference), true);

    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    public void addNote(View view){
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
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
    public void onBackPressed() {
        // If the fragment exists and has some back-stack entry
        DiaryFragment diaryFragment = new DiaryFragment();
        if (diaryFragment != null && diaryFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            diaryFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

    public void viewAllNotes(View view){
        //getSupportActionBar().setTitle(getResources().getString(R.string.nav_notes));
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("openFragment","allNotes");
        startActivity(intent);
    }
}
