package org.example;

public class Teacher extends User{
    private String userName;

    public Teacher(int userID,String password, String email){
        super(userID,password,email);
    }
    public Teacher(String email, String password){
        super(email,password);
    }
    public void setUserName(String userName){
        userName = "Joed";
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }

    //bale d pa ako sure kung anong ilakagay ko dine
}
