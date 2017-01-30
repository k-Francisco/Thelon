package com.example.johncarter.thelon.models;

import android.view.View;

import com.example.johncarter.thelon.R;

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
    private int event_status;

    private View.OnClickListener requestBtnClickListener;


    public PortfolioActivity(int photo, String date, String time, String eventName, String eventHost, String volunteerCount, String points, int event_status) {
        this.photo = photo;
        this.date = date;
        this.time = time;
        this.eventName = eventName;
        this.eventHost = eventHost;
        this.volunteerCount = volunteerCount;
        this.points = points;
        this.event_status = event_status;
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

    public static ArrayList<PortfolioActivity> getTestingList(){
        ArrayList<PortfolioActivity> items = new ArrayList<>();
        items.add(new PortfolioActivity(R.drawable.ic_user,"2/27/2017","2:00 am","Feeding Program","Rise Above Foundation","50","100",R.drawable.ribbon2));
        items.add(new PortfolioActivity(R.drawable.ic_user,"2/27/2017","2:00 am","Feeding Program","Rise Above Foundation","50","100",R.drawable.ribbon2));
        items.add(new PortfolioActivity(R.drawable.ic_user,"3/14/2017","2:00 am","Feeding Program","Rise Above Foundation","50","100",R.drawable.ribbon_done2));
        items.add(new PortfolioActivity(R.drawable.ic_user,"4/1/2017","2:00 am","Feeding Program","Rise Above Foundation","50","100",R.drawable.ribbon_done2));
        items.add(new PortfolioActivity(R.drawable.ic_user,"4/5/2017","2:00 am","Feeding Program","Rise Above Foundation","50","100",R.drawable.ribbon_done2));
        return items;
    }
}
