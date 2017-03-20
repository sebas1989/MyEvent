package punkmkt.com.myevent.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import punkmkt.com.myevent.R;
import punkmkt.com.myevent.model.Conference;
import punkmkt.com.myevent.view.DiaryConferenceViewActivity;

/**
 * Created by sebastianmendezgiron on 02/03/17.
 */

public class ConferenceAdapterRecyclerView extends RecyclerView.Adapter<ConferenceAdapterRecyclerView.ConferenceViewHolder>{

    private ArrayList<Conference> conferences;
    private int resource;
    private Activity activity;

    public ConferenceAdapterRecyclerView(ArrayList<Conference> conferences, int resource, Activity activity) {
        this.conferences = conferences;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public ConferenceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new ConferenceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConferenceViewHolder holder, int position) {
        Conference conferenceItem = conferences.get(position);
        holder.conferenceTitle.setText(conferenceItem.getTitle());
        holder.conferenceSchedule.setText(conferenceItem.getStart_hour());
        holder.conferenceLocation.setText(conferenceItem.getLocation());
        holder.conferenceListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, DiaryConferenceViewActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return conferences.size();
    }

    public class ConferenceViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout conferenceListItem;
        private TextView conferenceTitle, conferenceSchedule, conferenceLocation;

        public ConferenceViewHolder(View itemView) {
            super(itemView);

            conferenceListItem = (LinearLayout) itemView.findViewById(R.id.conferenceListItem);
            conferenceTitle = (TextView) itemView.findViewById(R.id.conferenceTitle);
            conferenceSchedule = (TextView) itemView.findViewById(R.id.conferenceSchedule);
            conferenceLocation = (TextView) itemView.findViewById(R.id.conferenceLocation);

        }
    }
}
