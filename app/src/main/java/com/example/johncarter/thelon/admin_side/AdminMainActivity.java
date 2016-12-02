package com.example.johncarter.thelon.admin_side;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.johncarter.thelon.R;

import br.com.mauker.materialsearchview.MaterialSearchView;

/**
 * Created by asus on 02/12/2016.
 */

public class AdminMainActivity extends AppCompatActivity {
    MaterialSearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminmainactivity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Ethelon");

        searchView = (MaterialSearchView)findViewById(R.id.search_view);
        Button butt = (Button)findViewById(R.id.searchbutton);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.openSearch();
            }
        });


        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewOpened() {
                // Do something once the view is open.
            }

            @Override
            public void onSearchViewClosed() {
                // Do something once the view is closed.
            }
        });

        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do something when the suggestion list is clicked.
                String suggestion = searchView.getSuggestionAtPosition(position);

                searchView.setQuery(suggestion, false);
            }
        });

        searchView.adjustTintAlpha(0.8f);
        final Context context = this;
        searchView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "Long clicked position: " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        searchView.setOnVoiceClickedListener(new MaterialSearchView.OnVoiceClickedListener() {
            @Override
            public void onVoiceClicked() {
                Toast.makeText(context, "Voice clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
