package punkmkt.com.myevent.view;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.view.fragment.SponsorFragment;

public class SponsorViewDatailActivity extends AppCompatActivity {

    private ImageView sponsorBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor_view_datail);

        showToolBar("", true);

        sponsorBanner = (ImageView) findViewById(R.id.sponsorBanner);
        Picasso.with(getApplicationContext()).load("http://www.punk-emkt.com/blog/myEventAppResource/10-patrocinadores/coca_cola.jpg").into(sponsorBanner);

    }

    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
    public void onBackPressed() {
        // If the fragment exists and has some back-stack entry
        SponsorFragment sponsorFragment= new SponsorFragment();
        if (sponsorFragment != null && sponsorFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            sponsorFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

}
