package com.example.johncarter.thelon.notification_tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.johncarter.thelon.R;

import java.util.List;

/**
 * Created by john carter on 11/28/2016.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationModel> {
    private Context mContext;
    private int         mResource;
    private List<NotificationModel> nNotifications;

    public NotificationAdapter(Context context, int resource, List<NotificationModel> notifications) {
        super(context, resource, notifications);

        mContext = context;
        mResource = resource;
        nNotifications = notifications;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        NotificationModel notification = nNotifications.get(position);
        if (notification != null) {
            if (holder.heading != null) {
                holder.heading.setText(notification.getName() + " " + notification.getMessage());
            }
            if (holder.notifImg != null) {
                holder.notifImg.setImageResource(notification.getImageId());
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView heading;
        ImageView notifImg;

        public ViewHolder(View view) {
            heading = (TextView) view.findViewById(R.id.heading);
            notifImg = (ImageView) view.findViewById(R.id.notifImg);
        }
    }
}
