package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 02/03/17.
 */

public class Conference {

    private String id;
    private String title;
    private String description;
    private String location;
    private String date;
    private String start_hour;
    private String end_hour;
    private String latitude;
    private String longitude;
    private String puntuation;

    public Conference(String id, String title, String description, String location, String date, String start_hour, String end_hour, String latitude, String longitude, String puntuation) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.date = date;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.latitude = latitude;
        this.longitude = longitude;
        this.puntuation = puntuation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(String start_hour) {
        this.start_hour = start_hour;
    }

    public String getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(String end_hour) {
        this.end_hour = end_hour;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPuntuation() {
        return puntuation;
    }

    public void setPuntuation(String puntuation) {
        this.puntuation = puntuation;
    }
}
