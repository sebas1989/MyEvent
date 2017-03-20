package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 07/03/17.
 */

public class Speaker {

    private String id;
    private String thumb;
    private String name;
    private String description;
    private String conferenceId;
    private String conferenceTitle;
    private String position;
    private String facebok;
    private String twiter;
    private String linkedin;

    public Speaker(String id, String thumb, String name, String description, String conferenceId, String conferenceTitle, String position, String facebok, String twiter, String linkedin) {
        this.id = id;
        this.thumb = thumb;
        this.name = name;
        this.description = description;
        this.conferenceId = conferenceId;
        this.conferenceTitle = conferenceTitle;
        this.position = position;
        this.facebok = facebok;
        this.twiter = twiter;
        this.linkedin = linkedin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getConferenceTitle() {
        return conferenceTitle;
    }

    public void setConferenceTitle(String conferenceTitle) {
        this.conferenceTitle = conferenceTitle;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFacebok() {
        return facebok;
    }

    public void setFacebok(String facebok) {
        this.facebok = facebok;
    }

    public String getTwiter() {
        return twiter;
    }

    public void setTwiter(String twiter) {
        this.twiter = twiter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}
