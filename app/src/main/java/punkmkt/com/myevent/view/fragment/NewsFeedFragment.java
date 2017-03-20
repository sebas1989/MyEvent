package punkmkt.com.myevent.view.fragment;


import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.adapter.NewsFeedAdapterRecyclerView;
import punkmkt.com.myevent.model.New;
import punkmkt.com.myevent.view.SendNewFeedActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends Fragment {

    View view;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_feed,container,false);

        RecyclerView newsRecycler = (RecyclerView) view.findViewById(R.id.newsFeedRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newsRecycler.setLayoutManager(linearLayoutManager);

        NewsFeedAdapterRecyclerView newsFeedAdapterRecyclerView =
                new NewsFeedAdapterRecyclerView(buildNews(), R.layout.cardview_newsfeed_item, getActivity());

        newsRecycler.setAdapter(newsFeedAdapterRecyclerView);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.addNewFeedThought);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SendNewFeedActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
        //return inflater.inflate(R.layout.fragment_news_feed, container, false);
    }
    public ArrayList<New> buildNews(){
        ArrayList<New> news = new ArrayList<>();
        news.add(new New("1" ,"http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Kylo Ren", "35", "http://www.punk-emkt.com/blog/myEventAppResource/fotografia_prueba.jpg", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "250", "150"));
        news.add(new New("2" ,"http://www.punk-emkt.com/blog/myEventAppResource/leia_organa_thumb.jpg", "Leia Organa", "34", "http://www.punk-emkt.com/blog/myEventAppResource/fotografia_prueba.jpg", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "250", "150"));
        news.add(new New("3" ,"http://www.punk-emkt.com/blog/myEventAppResource/luke_skywalker_thumb.jpg", "Luke Skywalker", "59", "http://www.punk-emkt.com/blog/myEventAppResource/fotografia_prueba.jpg", "El Product Placement es una técnica publicitaria que consiste en promocionar productos de manera sutil, con breves apariciones en películas, series, juegos e incluso videos musicales.", "2590", "501"));
        return news;
    }

}
