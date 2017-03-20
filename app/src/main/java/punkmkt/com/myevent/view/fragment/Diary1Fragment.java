package punkmkt.com.myevent.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.ConferenceAdapterRecyclerView;
import punkmkt.com.myevent.model.Conference;

/**
 * A simple {@link Fragment} subclass.
 */
public class Diary1Fragment extends Fragment {

    private View view;

    public Diary1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_diary_list_container, container, false);

        //conferenceRecyclerView
        RecyclerView conferenceRecyclerView = (RecyclerView) view.findViewById(R.id.conferenceRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        conferenceRecyclerView.setLayoutManager(linearLayoutManager);

        ConferenceAdapterRecyclerView conferenceAdapterRecyclerView =
                new ConferenceAdapterRecyclerView(buildConferences(), R.layout.listview_diary_item_content, getActivity());

        conferenceRecyclerView.setAdapter(conferenceAdapterRecyclerView);


        return view;
    }

    private ArrayList<Conference> buildConferences() {
        ArrayList<Conference> conferences = new ArrayList<>();
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 1", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 2", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 3", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 4", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 5", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 6", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 7", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 8", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 9", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 10", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 11", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 12", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 13", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));
        conferences.add(new Conference("1", "TÍTULO DE LA CONFERENCIA 14", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "Salón B - 4, Edificio B", "Vernes, 5 de mayo", "09:00 hrs.", "11:00 hrs.", "20.9444526", "-86.8390288", "5"));


        return conferences;
    }
}
