package com.example.johncarter.thelon.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.notification_tab.NotificationAdapter;
import com.example.johncarter.thelon.notification_tab.NotificationController;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    FrameLayout fl;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.notification_list,container,false);
        fl = (FrameLayout) rootView.findViewById(R.id.menu_frame);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        NotificationController controller = new NotificationController();
        NotificationAdapter adapter = new NotificationAdapter(rootView.getContext(), R.layout.notification_layout,
                controller.getNotifications());
        listView.setAdapter(adapter);
        return rootView;
    }

}
