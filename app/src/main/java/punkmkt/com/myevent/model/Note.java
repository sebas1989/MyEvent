package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 06/03/17.
 */

public class Note {
    private String id;
    private String conferenceTitle;
    private String noteContent;

    public Note(String id, String conferenceTitle, String noteContent) {
        this.id = id;
        this.conferenceTitle = conferenceTitle;
        this.noteContent = noteContent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
