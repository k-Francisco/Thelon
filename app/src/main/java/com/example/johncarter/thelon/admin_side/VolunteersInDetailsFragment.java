package com.example.johncarter.thelon.admin_side;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;

/**
 * Created by asus on 03/12/2016.
 */

public class VolunteersInDetailsFragment extends Fragment {
    private ArrayList<Integer> arr = new ArrayList<>();

    private int[] images = {R.drawable.charles,
            R.drawable.tyler,
            R.drawable.kobe,
            R.drawable.kf,
            R.drawable.mark,
            R.drawable.kix,
            R.drawable.anton,
            R.drawable.fanz,
            R.drawable.gil,
            R.drawable.ice};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.notification_list,container,false);

        arr.add(images[0]);
        arr.add(images[1]);
        arr.add(images[2]);
        arr.add(images[3]);
        arr.add(images[4]);
        arr.add(images[5]);
        arr.add(images[6]);
        arr.add(images[7]);
        arr.add(images[8]);
        arr.add(images[9]);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.listView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new VolunteerListahanAdapter(arr);
        recyclerView.setAdapter(adapter);
        StaggeredGridLayoutManager sgm = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(sgm);
        return rootView;
    }
}
