package com.example.johncarter.thelon.notification_tab;

/**
 * Created by john carter on 11/28/2016.
 */

public class NotificationModel {

    private String name;
    private String message;
    private int imageId;

    public NotificationModel(String name, String message, int imageId) {
        this.name = name;
        this.message = message;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
