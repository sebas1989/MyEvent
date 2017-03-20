package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 08/03/17.
 */

public class Assistant {

    private String id;
    private String name;
    private String description;
    private String thumb;
    private String company;
    private String position;
    private String website;
    private String email;
    private String phonenumber;
    private String facebok;
    private String twiter;
    private String linkedin;

    public Assistant(String id, String name, String description, String thumb, String company, String position, String website, String email, String phonenumber, String facebok, String twiter, String linkedin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumb = thumb;
        this.company = company;
        this.position = position;
        this.website = website;
        this.email = email;
        this.phonenumber = phonenumber;
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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
