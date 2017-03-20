package punkmkt.com.myevent.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.timqi.collapsibletextview.CollapsibleTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import punkmkt.com.myevent.R;
import punkmkt.com.myevent.model.New;
import punkmkt.com.myevent.view.NewsFeedDetailActivity;

/**
 * Created by sebastianmendezgiron on 24/02/17.
 */

public class NewsFeedAdapterRecyclerView extends RecyclerView.Adapter<NewsFeedAdapterRecyclerView.NewsFeedViewHolder>{

    private ArrayList<New> news;
    private int resource;
    private Activity activity;

    public NewsFeedAdapterRecyclerView(ArrayList<New> news, int resource, Activity activity) {
        this.news = news;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public NewsFeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new NewsFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsFeedViewHolder holder, int position) {
        New newItem = news.get(position);
        holder.userName.setText(newItem.getUserName());
        holder.timePublishedNumber.setText(newItem.getTime());
        holder.collapsibleTextView.setFullString(newItem.getNewDescription());
        holder.favoriteNumber.setText(newItem.getFavoriteNumber());
        Picasso.with(activity).load(newItem.getUserThumb()).into(holder.userThumb);
        Picasso.with(activity).load(newItem.getNewPicture()).into(holder.newPicture);

        /*if ( holder.collapsibleTextView.getExpandedText().equals(newItem.getNewDescription()) ){
            holder.collapsibleTextView.setExpanded(true);
            if ( holder.collapsibleTextView.isExpanded() ){
                holder.collapsibleTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String adjust = "";
                        Intent intent = new Intent(activity, NewsFeedDetailActivity.class);
                        intent.putExtra("adjust", adjust);
                        activity.startActivity(intent);
                    }
                });
            }
        }*/
        holder.newPicture.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String adjust = "";
                Intent intent = new Intent(activity, NewsFeedDetailActivity.class);
                intent.putExtra("adjust", adjust);
                activity.startActivity(intent);
            }

        });
        holder.addComment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String adjust = "adjustWindow";
                Intent intent = new Intent(activity, NewsFeedDetailActivity.class);
                intent.putExtra("adjust", adjust);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class NewsFeedViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout cardViewContentContainer;
        private CollapsibleTextView collapsibleTextView;
        private Button addComment;
        private ImageView userThumb, newPicture;
        private TextView userName, timePublishedNumber, timePublishedText, newDescription, favoriteNumber, commentsNumber;

        public NewsFeedViewHolder(View itemView) {
            super(itemView);

            cardViewContentContainer = (LinearLayout) itemView.findViewById(R.id.cardViewContentContainer);
            collapsibleTextView = (CollapsibleTextView) itemView.findViewById(R.id.newDescription);
            userThumb = (CircleImageView) itemView.findViewById(R.id.userThumb);
            userName  = (TextView) itemView.findViewById(R.id.userName);
            timePublishedNumber  = (TextView) itemView.findViewById(R.id.timePublishedNumber);
            timePublishedText  = (TextView) itemView.findViewById(R.id.timePublishedText);
            //newDescription  = (TextView) itemView.findViewById(R.id.newDescription);
            newPicture = (ImageView) itemView.findViewById(R.id.newsImage);
            favoriteNumber  = (TextView) itemView.findViewById(R.id.favoriteNumber);
            //commentsNumber  = (TextView) itemView.findViewById(R.id.commentsNumber);
            addComment = (Button) itemView.findViewById(R.id.addComment);
        }
    }

}
