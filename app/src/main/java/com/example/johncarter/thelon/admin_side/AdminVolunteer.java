package com.example.johncarter.thelon.admin_side;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.home_tab.recyclerAdapter;
import com.gjiazhe.wavesidebar.WaveSideBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminVolunteer extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    WaveSideBar sideBar;
    public AdminVolunteer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_admin_volunteer,container,false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view_admin);
        layoutManager = new LinearLayoutManager(rootview.getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new VolunteerContactAdapter();
        recyclerView.setAdapter(adapter);



        sideBar = (WaveSideBar) rootview.findViewById(R.id.side_bar);
        sideBar.setPosition(WaveSideBar.POSITION_RIGHT);
        sideBar.setTextColor(Color.BLACK);
        sideBar.setLazyRespond(true);
        sideBar.setMaxOffset(100);
        sideBar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        sideBar.setIndexItems("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                Character c = index.charAt(0);
                int position = new VolunteerContactAdapter().returnWhatIsSearched(c);
                Toast.makeText(rootview.getContext(), position+"", Toast.LENGTH_SHORT).show();

                recyclerView.getLayoutManager().scrollToPosition(position+5);

            }
        });




        return rootview;
    }

}
