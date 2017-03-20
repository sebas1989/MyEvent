package punkmkt.com.myevent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import punkmkt.com.myevent.view.fragment.AssistantFragment;
import punkmkt.com.myevent.view.fragment.DiaryFragment;
import punkmkt.com.myevent.view.fragment.FacilitiesFragment;
import punkmkt.com.myevent.view.fragment.MainFacilityFragment;
import punkmkt.com.myevent.view.fragment.NewsFeedFragment;
import punkmkt.com.myevent.view.fragment.NotesFragment;
import punkmkt.com.myevent.view.fragment.SpeakersFragment;
import punkmkt.com.myevent.view.fragment.SponsorFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        showToolBar(getResources().getString(R.string.nav_news_feed), true);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        String inf = intent.getStringExtra("openFragment");

        if (savedInstanceState == null && inf == null) {
            //navigationView.getMenu().getItem(0).setChecked(true);
            //navigationView.setCheckedItem(R.id.nav_news_feed);
            Fragment f1 = new NewsFeedFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, f1).commit();
        } else if( inf.equals("allNotes")){
            getSupportActionBar().setTitle(getResources().getString(R.string.nav_notes));
            Fragment f1 = new NotesFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, f1).commit();
        }else {
            Fragment f1 = new NewsFeedFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, f1).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_news_feed) {
            getSupportActionBar().setTitle(getResources().getString(R.string.nav_news_feed));
            Fragment f1 = new NewsFeedFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, f1).commit();
        }else if (id == R.id.nav_agenda) {
            getSupportActionBar().setTitle(getResources().getString(R.string.nav_agenda));
            Fragment f2 = new DiaryFragment();
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.replace(R.id.container, f2);
            //ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //ft2.addToBackStack(null);
            ft2.commit();
        } else if (id == R.id.nav_conferencistas) {
            getSupportActionBar().setTitle(getResources().getString(R.string.nav_conferencistas));
            Fragment fSpeakers = new SpeakersFragment();
            FragmentTransaction ftSpeakers= getSupportFragmentManager().beginTransaction();
            ftSpeakers.replace(R.id.container, fSpeakers);
            ftSpeakers.commit();
        }else if (id == R.id.nav_asistentes) {
            getSupportActionBar().setTitle(R.string.nav_asistentes);
            Fragment fAssistant = new AssistantFragment();
            FragmentTransaction ftAssistant = getSupportFragmentManager().beginTransaction();
            ftAssistant.replace(R.id.container, fAssistant);
            ftAssistant.commit();
        }else if (id == R.id.nav_instalaciones) {
            getSupportActionBar().setTitle(R.string.nav_instalaciones);
            Fragment fMFacility = new MainFacilityFragment();
            FragmentTransaction ftMFacility= getSupportFragmentManager().beginTransaction();
            ftMFacility.replace(R.id.container, fMFacility);
            ftMFacility.commit();
        }else if (id == R.id.nav_patrocinadores) {
            getSupportActionBar().setTitle(R.string.nav_patrocinadores);
            Fragment fSponsor = new SponsorFragment();
            FragmentTransaction ftSponsor = getSupportFragmentManager().beginTransaction();
            ftSponsor.replace(R.id.container, fSponsor);
            ftSponsor.commit();
        }else if (id == R.id.nav_mapas) {
            getSupportActionBar().setTitle(R.string.nav_mapas);
            Fragment fFacilities = new FacilitiesFragment();
            FragmentTransaction ftFacilities= getSupportFragmentManager().beginTransaction();
            ftFacilities.replace(R.id.container, fFacilities);
            ftFacilities.commit();
        }else if (id == R.id.nav_noticias) {

        }else if (id == R.id.nav_faqs) {

        }else if (id == R.id.nav_fotos) {

        }else if (id == R.id.nav_mensajes) {

        }else if (id == R.id.nav_notes) {
            getSupportActionBar().setTitle(getResources().getString(R.string.nav_notes));
            Fragment fNotes = new NotesFragment();
            FragmentTransaction ftNotes = getSupportFragmentManager().beginTransaction();
            ftNotes.replace(R.id.container, fNotes);
            ftNotes.commit();
        }else if (id == R.id.nav_ajustes) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
