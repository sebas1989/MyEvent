package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 15/03/17.
 */

public class Facility {

    private String id;
    private String name;
    private String logo;
    private String description;
    private String phoneNumber;
    private String emailAdress;
    private String adress;
    private String locationAdress;
    private String lon;
    private String lat;

    public Facility(String id, String name, String logo, String description, String phoneNumber, String emailAdress, String adress, String locationAdress, String lon, String lat) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
        this.adress = adress;
        this.locationAdress = locationAdress;
        this.lon = lon;
        this.lat = lat;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getLocationAdress() {
        return locationAdress;
    }

    public void setLocationAdress(String locationAdress) {
        this.locationAdress = locationAdress;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
