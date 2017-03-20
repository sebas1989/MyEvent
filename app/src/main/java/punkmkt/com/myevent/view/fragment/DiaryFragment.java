package punkmkt.com.myevent.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.ConferenceAdapterRecyclerView;
import punkmkt.com.myevent.adapter.ViewPagerAdapter;
import punkmkt.com.myevent.model.Conference;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryFragment extends Fragment{

    private View diaryView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public DiaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        diaryView = inflater.inflate(R.layout.fragment_diary, container, false);

        viewPager = (ViewPager) diaryView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) diaryView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return diaryView;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        /*for(CategoryNew categoryNew: categoryNews){
            Fragment fragment = NoticiasFragmentCategoria.newInstance(String.valueOf(categoryNew.getId()));
            adapter.addFrag(fragment, categoryNew.getDescription());
        }*/
        adapter.addFrag(new Diary1Fragment(), "JUEVES, 4 DE MAYO");
        adapter.addFrag(new Diary1Fragment(), "VIERNES, 5 DE MAYO");
        adapter.addFrag(new Diary1Fragment(), "SÁBADO, 6 DE MAYO");
        adapter.addFrag(new Diary1Fragment(), "LUNES, 8 DE MAYO");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
