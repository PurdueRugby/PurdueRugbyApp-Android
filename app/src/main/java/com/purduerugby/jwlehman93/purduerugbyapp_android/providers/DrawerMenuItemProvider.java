package com.purduerugby.jwlehman93.purduerugbyapp_android.providers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlehman on 3/31/16.
 */
public abstract class DrawerMenuItemProvider {

    private static List<String> menuItems = new ArrayList<String>() {{
        add("Home");
        add("Roster");
        add("Calendar");
        add("About");

    }};


    public static List<String> getMenuItems() {
        return menuItems;
    }

}
