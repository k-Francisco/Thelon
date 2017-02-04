package com.example.johncarter.thelon.models;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Acer on 29/01/2017.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Activity {
    @JsonProperty
    String actname;
    @JsonProperty
    String actDate;
    @JsonProperty
    String actTime;
    @JsonProperty
    String actStreet;
    @JsonProperty
    String actCity;
    @JsonProperty
    String actAddress;
    @JsonProperty
    String actIdCreator;
    @JsonProperty
    String actFoundationCreator;
    @JsonProperty
    String ppersonInCharge;
    @JsonProperty
    String pcontactNumber;
    @JsonProperty
    String pemailAddress;
    @JsonProperty
    String vLocation;
    @JsonProperty
    String vGender;
    @JsonProperty
    String vOccupation;
    @JsonProperty
    String vAge;
    @JsonProperty
    String key;

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate;
    }

    public String getActTime() {
        return actTime;
    }

    public void setActTime(String actTime) {
        this.actTime = actTime;
    }

    public String getActStreet() {
        return actStreet;
    }

    public void setActStreet(String actStreet) {
        this.actStreet = actStreet;
    }

    public String getActCity() {
        return actCity;
    }

    public void setActCity(String actCity) {
        this.actCity = actCity;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress;
    }

    public String getActIdCreator() {
        return actIdCreator;
    }

    public void setActIdCreator(String actIdCreator) {
        this.actIdCreator = actIdCreator;
    }

    public String getActFoundationCreator() {
        return actFoundationCreator;
    }

    public void setActFoundationCreator(String actFoundationCreator) {
        this.actFoundationCreator = actFoundationCreator;
    }

    public String getPpersonInCharge() {
        return ppersonInCharge;
    }

    public void setPpersonInCharge(String ppersonInCharge) {
        this.ppersonInCharge = ppersonInCharge;
    }

    public String getPcontactNumber() {
        return pcontactNumber;
    }

    public void setPcontactNumber(String pcontactNumber) {
        this.pcontactNumber = pcontactNumber;
    }

    public String getPemailAddress() {
        return pemailAddress;
    }

    public void setPemailAddress(String pemailAddress) {
        this.pemailAddress = pemailAddress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Activity(String actname, String actDate, String actTime, String actStreet, String actCity,
                    String actAddress, String actIdCreator, String actFoundationCreator, String ppersonInCharge,
                    String pcontactNumber, String pemailAddress, String vLocation, String vGender, String vOccupation,
                    String vAge, String key) {

        this.actname = actname;
        this.actDate = actDate;
        this.actTime = actTime;
        this.actStreet = actStreet;
        this.actCity = actCity;
        this.actAddress = actAddress;
        this.actIdCreator = actIdCreator;
        this.actFoundationCreator = actFoundationCreator;
        this.ppersonInCharge = ppersonInCharge;
        this.pcontactNumber = pcontactNumber;
        this.pemailAddress = pemailAddress;
        this.vLocation = vLocation;
        this.vGender = vGender;
        this.vOccupation = vOccupation;
        this.vAge = vAge;
        this.key = key;
    }


    public Activity(){

    }

    public String getvLocation() {
        return vLocation;
    }

    public void setvLocation(String vLocation) {
        this.vLocation = vLocation;
    }

    public String getvGender() {
        return vGender;
    }

    public void setvGender(String vGender) {
        this.vGender = vGender;
    }

    public String getvOccupation() {
        return vOccupation;
    }

    public void setvOccupation(String vOccupation) {
        this.vOccupation = vOccupation;
    }

    public String getvAge() {
        return vAge;
    }

    public void setvAge(String vAge) {
        this.vAge = vAge;
    }




}
