package com.example.johncarter.thelon.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.johncarter.thelon.R;
import com.example.johncarter.thelon.home_details.AttendaceCheckinig;
import com.example.johncarter.thelon.models.PortfolioActivity;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

/**
 * Created by Acer on 28/01/2017.
 */

public class PorfolioNew extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portfolio_listview);

        ListView theListView = (ListView) findViewById(R.id.mainListView);

        final ArrayList<PortfolioActivity> items = PortfolioActivity.getTestingList();

//        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "CUSTOM HANDLER FOR FIRST BUTTON", Toast.LENGTH_SHORT).show();
//            }
//        });

        final PorfolioNewAdapter adapter = new PorfolioNewAdapter(this, items);

        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "DEFAULT HANDLER FOR ALL BUTTONS", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PorfolioNew.this,AttendaceCheckinig.class));
            }
        });

        theListView.setAdapter(adapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);
            }
        });
    }
}
