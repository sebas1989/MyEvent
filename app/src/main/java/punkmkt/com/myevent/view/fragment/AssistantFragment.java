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
import punkmkt.com.myevent.adapter.AssistantAdapterRecyclerView;
import punkmkt.com.myevent.model.Assistant;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssistantFragment extends Fragment {

    private View view;

    public AssistantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_assistant, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.assistantRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        AssistantAdapterRecyclerView assistantAdapterRecyclerView =
                new AssistantAdapterRecyclerView(buildAssistants(), R.layout.listview_assistant_item, getActivity());
        recyclerView.setAdapter(assistantAdapterRecyclerView);

        return view;
    }

    private ArrayList<Assistant> buildAssistants(){
        ArrayList<Assistant> assistants = new ArrayList<>();
        assistants.add(new Assistant("1", "BB-5", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("2", "BB-6", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("3", "BB-7", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        assistants.add(new Assistant("4", "BB-8", "Hola mundo", "http://www.punk-emkt.com/blog/myEventAppResource/kylo_ren_thumb.jpg", "Punk E-Marketing & Consulting", "IT Manager", "www.punkmkt.com", "itmanager@punkmkt.com", "+52 (998) 8683251", "facebok.com", "twitter.com", "linkedin.com"));
        return assistants;
    }

}
