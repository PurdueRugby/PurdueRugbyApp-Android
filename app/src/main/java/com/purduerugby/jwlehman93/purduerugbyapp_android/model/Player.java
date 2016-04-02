package com.purduerugby.jwlehman93.purduerugbyapp_android.model;

/**
 * Created by jwlehman on 4/2/16.
 */
public class Player {
    private String firstName;
    private String lastName;
    private int postion ;
    private int year;
    private String hometown;

    public Player(String firstName, String lastName, int postion, int year, String hometown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postion = postion;
        this.year = year;
        this.hometown = hometown;
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

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
