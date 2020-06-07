package punkmkt.com.myevent.model;

/**
 * Created by sebastianmendezgiron on 24/02/17.
 */

public class New {

    private String idNew;
    private String userThumb;
    private String userName;
    private String time;
    private String newPicture;
    private String newDescription;
    private String favoriteNumber = "15";
    private String commentsNumber = "10";

    public New(String idNew, String userThumb, String userName, String time, String newPicture, String newDescription, String favoriteNumbre, String commentsNumber) {
        this.idNew = idNew;
        this.userThumb = userThumb;
        this.userName = userName;
        this.time = time;
        this.newPicture = newPicture;
        this.newDescription = newDescription;
        this.favoriteNumber = favoriteNumbre;
        this.commentsNumber = commentsNumber;
    }

    public String getIdNew() {
        return idNew;
    }

    public void setIdNew(String idNew) {
        this.idNew = idNew;
    }

    public String getUserThumb() {
        return userThumb;
    }

    public void setUserThumb(String userThumb) {
        this.userThumb = userThumb;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNewPicture() {
        return newPicture;
    }

    public void setNewPicture(String newPicture) {
        this.newPicture = newPicture;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getCommentsNumber() {
        return commentsNumber;
    }

    public void setCommentsNumber(String commentsNumber) {
        this.commentsNumber = commentsNumber;
    }
}
