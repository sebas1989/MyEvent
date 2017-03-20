package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 09/03/17.
 */

public class Sponsor {

    private String id;
    private String name;
    private String description;
    private String thumb;
    private String fullImage;
    private String webSite;
    private String address;
    private String phoneNumber;
    private String locationLat;
    private String getLocationLong;
    private String locationLatLong;

    public Sponsor(String id, String name, String description, String thumb, String fullImage, String webSite, String address, String phoneNumber, String locationLat, String getLocationLong, String locationLatLong) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumb = thumb;
        this.fullImage = fullImage;
        this.webSite = webSite;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.locationLat = locationLat;
        this.getLocationLong = getLocationLong;
        this.locationLatLong = locationLatLong;
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

    public String getFullImage() {
        return fullImage;
    }

    public void setFullImage(String fullImage) {
        this.fullImage = fullImage;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(String locationLat) {
        this.locationLat = locationLat;
    }

    public String getGetLocationLong() {
        return getLocationLong;
    }

    public void setGetLocationLong(String getLocationLong) {
        this.getLocationLong = getLocationLong;
    }

    public String getLocationLatLong() {
        return locationLatLong;
    }

    public void setLocationLatLong(String locationLatLong) {
        this.locationLatLong = locationLatLong;
    }
}
