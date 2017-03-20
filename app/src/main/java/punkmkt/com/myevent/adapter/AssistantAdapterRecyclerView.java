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
import punkmkt.com.myevent.model.Assistant;
import punkmkt.com.myevent.view.AssistantViewActivity;

/**
 * Created by sebastianmendezgiron on 08/03/17.
 */

public class AssistantAdapterRecyclerView extends RecyclerView.Adapter<AssistantAdapterRecyclerView.AssistantViewHolder>{

    private ArrayList<Assistant> assistants;
    private int resource;
    private Activity activity;

    public AssistantAdapterRecyclerView(ArrayList<Assistant> assistants, int resource, Activity activity) {
        this.assistants = assistants;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public AssistantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new AssistantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AssistantViewHolder holder, int position) {
        Assistant assistantItem = assistants.get(position);
        Picasso.with(activity).load(assistantItem.getThumb()).into(holder.assistantCircleImageView);
        holder.assistantName.setText(assistantItem.getName());
        holder.assistantCompany.setText(assistantItem.getCompany());
        holder.assistantPosition.setText(assistantItem.getPosition());
        holder.assistantLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, AssistantViewActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return assistants.size();
    }


    public class AssistantViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout assistantLinearLayout;
        private TextView assistantName, assistantCompany, assistantPosition;
        private CircleImageView assistantCircleImageView;

        public AssistantViewHolder(View itemView) {
            super(itemView);
            assistantLinearLayout = (LinearLayout) itemView.findViewById(R.id.assistantLinearLayout);
            assistantCircleImageView = (CircleImageView) itemView.findViewById(R.id.assistantThumb);
            assistantName = (TextView) itemView.findViewById(R.id.assistantName);
            assistantCompany = (TextView) itemView.findViewById(R.id.assistantCompany);
            assistantPosition = (TextView) itemView.findViewById(R.id.assistantPosition);
        }

    }
}
