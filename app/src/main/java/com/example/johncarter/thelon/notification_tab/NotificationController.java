package com.example.johncarter.thelon.notification_tab;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john carter on 11/28/2016.
 */

public class NotificationController {

    private List<NotificationModel> nNotifications;

    public NotificationController(){
        nNotifications = new ArrayList<>();
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message", R.drawable.movie01));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie02));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie03));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie04));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie05));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie06));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie07));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie08));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie09));
        nNotifications.add(new NotificationModel("Charles Cruz","has sent you a message",R.drawable.movie10));
    }

    public List<NotificationModel> getNotifications() {
        return nNotifications;
    }
}
