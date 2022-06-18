package com.example.smash;

public class GetSet {

    String School;
    String User;
    String Password;

    public String getSchool() {
        return School;
    }
    public void setSchool(String school) {
        this.School = school;
    }

    public String getUser() {
        return User;
    }
    public void setUser(String user) {
        this.User = user;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        this.Password = password;
    }

    public GetSet(String school, String user, String password){
        this.School = school;
        this.User = user;
        this.Password = password;
    }
}
