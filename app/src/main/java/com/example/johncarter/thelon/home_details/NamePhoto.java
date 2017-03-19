package com.example.johncarter.thelon.home_details;

/**
 * Created by asus on 18/03/2017.
 */

public class NamePhoto {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public NamePhoto(String name, String photo) {

        this.name = name;
        this.photo = photo;
    }

    String name;
    String photo;
}
