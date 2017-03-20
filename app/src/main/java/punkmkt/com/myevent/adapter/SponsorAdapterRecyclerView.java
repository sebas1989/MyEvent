package punkmkt.com.myevent.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import punkmkt.com.myevent.R;
import punkmkt.com.myevent.model.Sponsor;
import punkmkt.com.myevent.view.SponsorViewDatailActivity;

/**
 * Created by sebastianmendezgiron on 09/03/17.
 */

public class SponsorAdapterRecyclerView extends RecyclerView.Adapter<SponsorAdapterRecyclerView.SponsorViewHolder>{

    private ArrayList<Sponsor> sponsors;
    private int resource;
    private Activity activity;

    public SponsorAdapterRecyclerView(ArrayList<Sponsor> sponsors, int resource, Activity activity) {
        this.sponsors = sponsors;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public SponsorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new SponsorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SponsorViewHolder holder, int position) {
        Sponsor sponsorItem = sponsors.get(position);
        Picasso.with(activity).load(sponsorItem.getThumb()).into(holder.sponsorThumb);
        holder.sponsorName.setText(sponsorItem.getName());
        holder.sponsorListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, SponsorViewDatailActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sponsors.size();
    }

    public class SponsorViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout sponsorListItem;
        private TextView sponsorName;
        private CircleImageView sponsorThumb;

        public SponsorViewHolder(View itemView) {
            super(itemView);

            sponsorListItem = (LinearLayout) itemView.findViewById(R.id.sponsorListItem);
            sponsorThumb = (CircleImageView) itemView.findViewById(R.id.sponsorThumb);
            sponsorName = (TextView) itemView.findViewById(R.id.sponsorName);

        }
    }
}
