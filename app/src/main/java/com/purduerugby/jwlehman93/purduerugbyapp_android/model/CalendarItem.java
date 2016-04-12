package com.purduerugby.jwlehman93.purduerugbyapp_android.model;

import org.joda.time.DateTime;

/**
 * Created by jwlehman on 4/7/16.
 */
public class CalendarItem {
    private String date;
    private String description;
    private String result;

    public CalendarItem( String date, String description, String result) {
        this.date = date;
        this.description = description;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
