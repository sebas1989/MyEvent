package punkmkt.com.myevent.view;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.view.fragment.FacilitiesFragment;

public class FacilityViewActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_view);
        showToolBar("", true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    public void showToolBar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(21.089710, -86.770879), 16));

        googleMap.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_favorite_selected))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(21.089710, -86.770879)));
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
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
        FacilitiesFragment facilitiesFragment= new FacilitiesFragment();
        if (facilitiesFragment != null && facilitiesFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            facilitiesFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

}
