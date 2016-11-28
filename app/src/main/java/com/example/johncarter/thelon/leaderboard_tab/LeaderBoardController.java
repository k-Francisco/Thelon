package com.example.johncarter.thelon.leaderboard_tab;

import com.example.johncarter.thelon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john carter on 11/26/2016.
 */

public class LeaderBoardController {

    private List<LeaderBoardModel> mLeaderBoard;

    public LeaderBoardController(){
        mLeaderBoard = new ArrayList<>();
    }

    public List<LeaderBoardModel> getLeaderBoard(){

        mLeaderBoard = new ArrayList<>();

        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_two, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_three, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_four, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_five, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_five, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_five, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_five, R.drawable.leaderboard_pic));
        mLeaderBoard.add(new LeaderBoardModel("Anton Ven Wycoco", "1000 points", R.drawable.leaderboard_five, R.drawable.leaderboard_pic));


        return mLeaderBoard;
    }
}
