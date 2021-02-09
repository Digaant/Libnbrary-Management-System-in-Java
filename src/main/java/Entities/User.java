package Entities;

public class User {
    private Long UID;
    private String userName;
    private String password;
    private Boolean admin;

    public User(Long UID, String userName, String password, Boolean admin) {
        this.UID = UID;
        this.userName = userName;
        this.password = password;
        this.admin = admin;
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "UID=" + UID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
