package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.adapters.CalendarAdapter;
import com.purduerugby.jwlehman93.purduerugbyapp_android.listeners.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.CalendarItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.DrawerMenuItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;

import java.util.List;

public class CalendarActivity extends AppCompatActivity {
    private List<String> drawerMenuItems;
    private ListView drawerListView;
    private DrawerLayout leftDrawerLayout;
    private ListView calendarListview;
    private List<String> dates;
    private List<String> descriptions;
    private List<String> results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //implement drawer
        drawerMenuItems = DrawerMenuItemProvider.getMenuItems();
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.menu_drawer);
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerMenuItems));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener(this.getApplicationContext()));

        //implement calendar
        calendarListview = (ListView) findViewById(R.id.calendar_listview);
        calendarListview.setAdapter(new CalendarAdapter(this));

    }
}