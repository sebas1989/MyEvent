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
import punkmkt.com.myevent.adapter.NoteAdapter;
import punkmkt.com.myevent.model.Note;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {

    private View view;
    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_notes, container, false);

        RecyclerView noteRecycler = (RecyclerView) view.findViewById(R.id.notesRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        noteRecycler.setLayoutManager(linearLayoutManager);

        NoteAdapter noteAdapterRecyclerView =
                new NoteAdapter(buildNotes(), R.layout.listview_note_item, getActivity());

        noteRecycler.setAdapter(noteAdapterRecyclerView);
        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<Note> buildNotes(){
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        notes.add(new Note("1", "TÍTULO DE LA CONFERENCIA", "Creamos estrategias integrales de e-Marketing, Diseño, Desarrollo Web y Design Thinking para alcanzar tus objetivos comerciales y agregar valor a tu marca."));
        return notes;
    }

}
