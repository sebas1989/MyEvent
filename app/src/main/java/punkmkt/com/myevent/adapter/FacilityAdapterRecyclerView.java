package punkmkt.com.myevent.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import punkmkt.com.myevent.R;
import punkmkt.com.myevent.model.Facility;
import punkmkt.com.myevent.view.FacilityViewActivity;
import punkmkt.com.myevent.view.MapsActivity;

/**
 * Created by sebastianmendezgiron on 15/03/17.
 */

public class FacilityAdapterRecyclerView extends RecyclerView.Adapter<FacilityAdapterRecyclerView.FacilityViewHolder>{

    private ArrayList<Facility> facilities;
    private int resource;
    private Activity activity;

    public FacilityAdapterRecyclerView(ArrayList<Facility> facilities, int resource, Activity activity) {
        this.facilities = facilities;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public FacilityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new FacilityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FacilityViewHolder holder, int position) {
        Facility facilityItem = facilities.get(position);
        Picasso.with(activity).load(facilityItem.getLogo()).into(holder.facilityLogo);
        holder.facilityName.setText(facilityItem.getName());
        holder.listFacilityItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, FacilityViewActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }


    public class FacilityViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout listFacilityItem;
        private CircleImageView facilityLogo;
        private TextView facilityName;

        public FacilityViewHolder(View itemView) {
            super(itemView);

            listFacilityItem = (LinearLayout) itemView.findViewById(R.id.facilityListItem);
            facilityLogo = (CircleImageView) itemView.findViewById(R.id.facilityThumb);
            facilityName = (TextView) itemView.findViewById(R.id.facilityName);

        }
    }
}
