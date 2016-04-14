package com.purduerugby.jwlehman93.purduerugbyapp_android.model;

/**
 * Created by jwlehman on 4/2/16.
 */
public class Player {
    private String firstName;
    private String lastName;
    private String height;
    private int weight;
    private String postion;
    private String year;
    private String hometown;
    private String homestate;

    public Player(String firstName, String lastName, String height, int weight, String postion, String year, String hometown, String homestate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.postion = postion;
        this.year = year;
        this.hometown = hometown;
        this.homestate = homestate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHomestate() {
        return homestate;
    }

    public void setHomestate(String homestate) {
        this.homestate = homestate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
