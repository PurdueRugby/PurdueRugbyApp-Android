package com.purduerugby.jwlehman93.purduerugbyapp_android.model;

/**
 * Created by jwlehman on 4/2/16.
 */
public class Player {
    String _id;
    String name;
    String height;
    String weight;
    String position;
    String year;
    String hometown;
    String homestate;

    public Player() {
        name = "";
        height = "";
        weight = "";
        position = "";
        year = "";
        hometown = "";
        homestate = "";
        _id = "";
    }
    public Player(String id, String name, String height, String weight, String position, String year, String hometown, String homestate) {
        this._id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.year = year;
        this.hometown = hometown;
        this.homestate = homestate;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHomestate() {
        return homestate;
    }

    public void setHomestate(String homestate) {
        this.homestate = homestate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String postion) {
        this.position = postion;
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
