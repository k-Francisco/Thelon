package com.example.johncarter.thelon.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Acer on 29/01/2017.
 */

public class Users {
    String displayName;
    String userType;
    String Email;
    String key;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public Users(String displayName, String userType, String email,String key) {
        this.displayName = displayName;
        this.userType = userType;
        this.Email = email;
        this.key = key;
    }
}
