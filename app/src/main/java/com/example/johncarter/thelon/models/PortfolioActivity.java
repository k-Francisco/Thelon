package com.example.johncarter.thelon.models;

import android.view.View;

import com.example.johncarter.thelon.R;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by Acer on 29/01/2017.
 */

public class PortfolioActivity {

    private int photo;
    private String date;
    private String time;
    private String eventName;
    private String eventHost;
    private String volunteerCount;
    private String points;
    private String type;
    private String contactNumber;
    private String contactPerson;
    private String city;
    private String street;
    private StorageReference image;


    private int event_status;

    private View.OnClickListener requestBtnClickListener;

    public PortfolioActivity(int photo, String date, String time, String eventName, String eventHost, String volunteerCount, String points, String type, String contactNumber,
                             String contactPerson, String city, String street, StorageReference image, int event_status) {
        this.photo = photo;
        this.date = date;
        this.time = time;
        this.eventName = eventName;
        this.eventHost = eventHost;
        this.volunteerCount = volunteerCount;
        this.points = points;
        this.type = type;
        this.contactNumber = contactNumber;
        this.contactPerson = contactPerson;
        this.city = city;
        this.street = street;
        this.image = image;
        this.event_status = event_status;
    }

    public StorageReference getImage() {
        return image;
    }

    public void setImage(StorageReference image) {
        this.image = image;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEventHost() {
        return eventHost;
    }

    public void setEventHost(String eventHost) {
        this.eventHost = eventHost;
    }

    public String getVolunteerCount() {
        return volunteerCount;
    }

    public void setVolunteerCount(String volunteerCount) {
        this.volunteerCount = volunteerCount;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getEvent_status() {
        return event_status;
    }

    public void setEvent_status(int event_status) {
        this.event_status = event_status;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortfolioActivity item = (PortfolioActivity) o;

        if (photo != item.photo)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null)
            return false;
        if (time != null ? !time.equals(item.time) : item.time != null)
            return false;
        if (eventName != null ? !eventName.equals(item.eventName) : item.eventName != null)
            return false;
        if (eventHost != null ? !eventHost.equals(item.eventHost) : item.eventHost != null)
            return false;
        if (volunteerCount != null ? !volunteerCount.equals(item.volunteerCount) : item.volunteerCount != null)
            return false;

        return !(points != null ? !points.equals(item.points) : item.points != null);
    }

    @Override
    public int hashCode() {
        int result = photo != 0 ? photo : 0;

        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (eventName != null ? eventName.hashCode() : 0);
        result = 31 * result + (eventHost != null ? eventHost.hashCode() : 0);
        result = 31 * result + (volunteerCount != null ? volunteerCount.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }



}
