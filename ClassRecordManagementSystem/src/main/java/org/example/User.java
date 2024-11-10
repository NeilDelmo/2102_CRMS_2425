package org.example;

public class User {
    // Ito ang ating baryabolds
    private int userID;
    private String password;
    private String email;
    private String userName;

    //ito ang constructor
    public User(int userID, String password, String email) {
        this.userID = userID;
        this.password = password;
        this.email = email;
    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    //Ito ang getters - bali di na ako naggawa ng setters kasi nasa constructor naman na iyon
    public int getUserID() {
        return userID;
    }
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }
}
