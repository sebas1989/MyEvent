package punkmkt.com.myevent.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import punkmkt.com.myevent.BuildConfig;
import punkmkt.com.myevent.R;
import punkmkt.com.myevent.model.Speaker;
import punkmkt.com.myevent.view.NewDetailActivity;
import punkmkt.com.myevent.view.SendNewFeedActivity;
import punkmkt.com.myevent.view.SpeakerViewActivity;

/**
 * Created by sebastianmendezgiron on 07/03/17.
 */

public class SpeakerAdapterRecyclerView extends RecyclerView.Adapter<SpeakerAdapterRecyclerView.SpeakerViewHolder>{

    private ArrayList<Speaker> speakers;
    private int resource;
    private Activity activity;

    public SpeakerAdapterRecyclerView(ArrayList<Speaker> speakers, int resource, Activity activity) {
        this.speakers = speakers;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new SpeakerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SpeakerViewHolder holder, int position) {
        Speaker speakerItem = speakers.get(position);
        Picasso.with(activity).load(speakerItem.getThumb()).into(holder.circleImageView);
        holder.speakerName.setText(speakerItem.getName());
        holder.speakerConference.setText(speakerItem.getConferenceTitle());
        holder.speakerPosition.setText(speakerItem.getPosition());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SpeakerViewActivity.class);
                activity.startActivity(intent);
                /*validar versiones mayores 5
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname)).toBundle());
                    //recibir el elmento en el detalle del elemento
                }else {
                    activity.startActivity(intent);
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return speakers.size();
    }

    public class SpeakerViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private CircleImageView circleImageView;
        private TextView speakerName, speakerConference, speakerPosition;

        public SpeakerViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.speakerListItem);
            circleImageView = (CircleImageView) itemView.findViewById(R.id.userThumb);
            speakerName = (TextView) itemView.findViewById(R.id.userName);
            speakerConference = (TextView) itemView.findViewById(R.id.speakerConference);
            speakerPosition = (TextView) itemView.findViewById(R.id.speakerPosition);

        }

    }
}
