package punkmkt.com.myevent.view;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.view.fragment.AssistantFragment;

public class AssistantViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant_view);

        showToolBar("", true);

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
        AssistantFragment assistantFragment= new AssistantFragment();
        if (assistantFragment != null && assistantFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            // Get the fragment fragment manager - and pop the backstack
            assistantFragment.getChildFragmentManager().popBackStack();
        }
        // Else, nothing in the direct fragment back stack
        else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

}
