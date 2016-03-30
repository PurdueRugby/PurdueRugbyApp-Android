package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mMenuItems;
    private DrawerLayout mDrawerLayout;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMenuItems = new String[3];
        mMenuItems[0] = "Home";
        mMenuItems[1] = "About";
        mMenuItems[2] = "Roster";
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.menu_drawer);
        mListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, mMenuItems));
        mListView.setOnItemClickListener(new DrawerItemClickListener(this));
        }
}
