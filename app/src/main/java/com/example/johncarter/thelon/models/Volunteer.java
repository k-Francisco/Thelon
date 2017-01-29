package com.example.johncarter.thelon.models;

/**
 * Created by Acer on 29/01/2017.
 */

public class Volunteer {
    String displayName;
    String Email;
    String ID;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Volunteer(String displayName, String email, String ID) {

        this.displayName = displayName;
        Email = email;
        this.ID = ID;
    }
}
