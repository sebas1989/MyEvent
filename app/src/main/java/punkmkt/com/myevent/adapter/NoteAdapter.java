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
import punkmkt.com.myevent.model.Note;
import punkmkt.com.myevent.view.AddNoteActivity;
import punkmkt.com.myevent.view.ViewNoteActivity;

/**
 * Created by sebastianmendezgiron on 06/03/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    private ArrayList<Note> notes;
    private int resource;
    private Activity activity;

    public NoteAdapter(ArrayList<Note> notes, int resource, Activity activity) {
        this.notes = notes;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new NoteAdapter.NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note noteItem = notes.get(position);
        holder.noteConferenceTitle.setText(noteItem.getConferenceTitle());
        holder.conferenceNoteContent.setText(noteItem.getNoteContent());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ViewNoteActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }


    public class NoteViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private TextView noteConferenceTitle, conferenceNoteContent;
        public NoteViewHolder(View itemView) {
            super(itemView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.noteResume);
            noteConferenceTitle = (TextView) itemView.findViewById(R.id.noteConferenceTitle);
            conferenceNoteContent = (TextView) itemView.findViewById(R.id.conferenceNoteContent);
        }
    }
}
