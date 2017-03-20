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
import punkmkt.com.myevent.adapter.FacilityAdapterRecyclerView;
import punkmkt.com.myevent.model.Facility;

/**
 * A simple {@link Fragment} subclass.
 */
public class FacilitiesFragment extends Fragment {

    private View view;

    public FacilitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_facilities, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.facilityRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        FacilityAdapterRecyclerView facilityAdapterRecyclerView =
                new FacilityAdapterRecyclerView(buildFacilities(), R.layout.listview_facilitie_item, getActivity());

        recyclerView.setAdapter(facilityAdapterRecyclerView);

        return view;
    }

    private ArrayList<Facility> buildFacilities(){
        ArrayList<Facility> facilities = new ArrayList<>();
        facilities.add(new Facility("1", "HARD ROCK HOTEL CANCÚN", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon B, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon C, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon D, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon E, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon F, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon G, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon H, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon I, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon J, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon K, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        facilities.add(new Facility("2", "Salon L, HRC", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "", "", "", "", "", "", ""));
        return facilities;
    }
}
