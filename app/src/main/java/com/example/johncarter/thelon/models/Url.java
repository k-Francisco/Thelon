package com.example.johncarter.thelon.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by asus on 31/01/2017.
 */

public class Url {
    @JsonProperty
    String Url;

    public Url(String url) {
        Url = url;
    }

    public Url(){
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
