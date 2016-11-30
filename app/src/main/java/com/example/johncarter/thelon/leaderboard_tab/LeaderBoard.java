//package com.example.johncarter.thelon.leaderboard_tab;
//
//
//import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.transition.Transition;
//import android.transition.TransitionInflater;
//import android.view.Window;
//import android.widget.ListView;
//
//import com.example.johncarter.thelon.R;
//
//import butterknife.Bind;
//import butterknife.OnClick;
//import butterknife.ButterKnife;
//
//
//public class LeaderBoard extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_leader_board);
//
//
//        ListView listView = (ListView) findViewById(R.id.leaderboard_listView);
//        LeaderBoardController leaderBoardController = new LeaderBoardController();
//        LeaderBoardAdapter leaderBoardAdapter = new LeaderBoardAdapter(this, R.layout.leaderboard_list, leaderBoardController.getLeaderBoard());
//        listView.setAdapter(leaderBoardAdapter);
//
//    }
//}
