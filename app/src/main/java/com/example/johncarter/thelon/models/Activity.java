package com.example.johncarter.thelon.models;

/**
 * Created by Acer on 29/01/2017.
 */

public class Activity {
    String name;
    String date;
    String time;
    String street;
    String city;
    String address;
    String idCreator;
    String foundationCreator;
    String personInCharge;
    String contactNumber;
    String emailAddress;
    String location;
    String gender;
    String occupation;
    String age;
    String key;

    public Activity(){

    }

    public Activity(String name, String date, String time, String street, String city, String address, String idCreator,
                    String foundationCreator, String personInCharge, String contactNumber, String emailAddress, String location, String gender, String occupation, String age, String key) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.street = street;
        this.city = city;
        this.address = address;
        this.idCreator = idCreator;
        this.foundationCreator = foundationCreator;
        this.personInCharge = personInCharge;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
        this.location = location;
        this.gender = gender;
        this.occupation = occupation;
        this.age = age;
        this.key = key;
    }

    public String getName() {

        return name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCreator() {
        return idCreator;
    }

    public void setIdCreator(String idCreator) {
        this.idCreator = idCreator;
    }

    public String getFoundationCreator() {
        return foundationCreator;
    }

    public void setFoundationCreator(String foundationCreator) {
        this.foundationCreator = foundationCreator;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        occupation = occupation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        age = age;
    }
}
