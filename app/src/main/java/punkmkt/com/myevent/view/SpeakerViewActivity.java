package punkmkt.com.myevent.view;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.ConferenceAdapterRecyclerView;
import punkmkt.com.myevent.model.Conference;
import punkmkt.com.myevent.view.fragment.DiaryFragment;
import punkmkt.com.myevent.view.fragment.SpeakersFragment;


public class SpeakerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_view);

        showToolBar("", true);
        /*
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
            getWindow().setEnterTransition(new Fade());
        }*/

        RecyclerView conferenceRecyclerView = (RecyclerView) findViewById(R.id.conferenceRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        conferenceRecyclerView.setLayoutManager(linearLayoutManager);

        ConferenceAdapterRecyclerView conferenceAdapterRecyclerView =
                new ConferenceAdapterRecyclerView(buildConferences(), R.layout.listview_diary_item_content, this);

        conferenceRecyclerView.setAdapter(conferenceAdapterRecyclerView);
        conferenceRecyclerView.setNestedScrollingEnabled(false);
    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    private ArrayList<Conference> buildConferences() {
        ArrayList<Conference> conferences = new ArrayList<>();
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 1", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 2", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 3", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 4", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 5", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        return conferences;
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
        SpeakersFragment speakersFragment= new SpeakersFragment();
        if (speakersFragment != null && speakersFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            speakersFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }
}
