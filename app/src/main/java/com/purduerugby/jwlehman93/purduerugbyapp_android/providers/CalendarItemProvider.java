package com.purduerugby.jwlehman93.purduerugbyapp_android.providers;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlehman on 4/7/16.
 */
public abstract class CalendarItemProvider {


    private static List<CalendarItem> calendarItems = new ArrayList<CalendarItem>() {{
        add(new CalendarItem("04/02/2016", "OSU 7s", "8th"));
        add(new CalendarItem("04/09/2016", "Iowa 7s", "TBD"));
        add(new CalendarItem("04/16/2016", "BTU 7s Championship", "TBD"));
    }};

    public static List<CalendarItem> getCalendarItems() {
        return calendarItems;
    }

    public static List<String> getDates() {
        ArrayList<String> dates = new ArrayList<>();
        for(CalendarItem item: calendarItems) {
           dates.add(item.getDate());
        }
        return dates;
    }


    public static List<String> getDescriptions() {
        ArrayList<String> descriptions = new ArrayList<>();
        for(CalendarItem item: calendarItems) {
            descriptions.add(item.getDescription());
        }
        return descriptions;
    }


    public static List<String> getResults() {
        ArrayList<String> results = new ArrayList<>();
        for(CalendarItem item: calendarItems) {
            results.add(item.getResult());
        }
        return results;
    }
}
