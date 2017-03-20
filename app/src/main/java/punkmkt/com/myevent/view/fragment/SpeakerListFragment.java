package punkmkt.com.myevent.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.SpeakerAdapterRecyclerView;
import punkmkt.com.myevent.model.Speaker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakerListFragment extends Fragment {


    private View view;
    public SpeakerListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_speaker_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.speakerRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SpeakerAdapterRecyclerView speakerAdapterRecyclerView =
                new SpeakerAdapterRecyclerView(buildSpeakers(), R.layout.listview_speaker_item, getActivity());

        recyclerView.setAdapter(speakerAdapterRecyclerView);

        return view;
    }

    private ArrayList<Speaker> buildSpeakers(){
        ArrayList<Speaker> speakers = new ArrayList<>();
        speakers.add(new Speaker("1","http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg","Kylo Ren", "", "4", "Diseño UX", "CEO - President", "", "", ""));
        speakers.add(new Speaker("2","http://www.punk-emkt.com/blog/myEventAppResource/leia_organa_thumb.jpg","Leia Organa", "", "4", "Métodos de pagos en aplicaciones", "CEO - President", "", "", ""));
        speakers.add(new Speaker("3","http://www.punk-emkt.com/blog/myEventAppResource/luke_skywalker_thumb.jpg","Luke Skywalker", "", "4", "Marketing Digital", "CEO - Subpresident", "", "", ""));

        return speakers;
    }

}
