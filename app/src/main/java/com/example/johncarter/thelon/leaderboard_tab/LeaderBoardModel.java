package com.example.johncarter.thelon.leaderboard_tab;

/**
 * Created by john carter on 11/26/2016.
 */

public class LeaderBoardModel {

    private String name;
    private String points;
    private int rankingImage;
    private int volunteerImage;

    public LeaderBoardModel() {
    }

    public LeaderBoardModel(String name, String points, int rankingImage, int volunteerImage) {
        this.name = name;
        this.points = points;
        this.rankingImage = rankingImage;
        this.volunteerImage = volunteerImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public int getRankingImage() {
        return rankingImage;
    }

    public void setRankingImage(int rankingImage) {
        this.rankingImage = rankingImage;
    }

    public int getVolunteerImage() {
        return volunteerImage;
    }

    public void setVolunteerImage(int volunteerImage) {
        this.volunteerImage = volunteerImage;
    }
}
