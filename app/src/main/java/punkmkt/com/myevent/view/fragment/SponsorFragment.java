package punkmkt.com.myevent.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.SponsorAdapterRecyclerView;
import punkmkt.com.myevent.model.Sponsor;

/**
 * A simple {@link Fragment} subclass.
 */
public class SponsorFragment extends Fragment {

    private View view;

    public SponsorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_sponsor, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.sponsorRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SponsorAdapterRecyclerView sponsorAdapterRecyclerView =
                new SponsorAdapterRecyclerView(buildSponsor(), R.layout.listview_sponsor_item, getActivity());
        recyclerView.setAdapter(sponsorAdapterRecyclerView);

        return view;
    }

    private ArrayList<Sponsor> buildSponsor(){
        ArrayList<Sponsor> sponsors = new ArrayList<>();
            sponsors.add(new Sponsor("1", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("2", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("3", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("4", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("5", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("6", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("7", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        sponsors.add(new Sponsor("8", "Coca-Cola", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "www.cocacola-sponsor.com", "San Diego US", "+52 (998) 8683251", "", "", ""));
        return sponsors;
    }

}
