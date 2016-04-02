package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.DrawerMenuItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private List<String> drawerMenuItems;
    private DrawerLayout leftDrawerLayout;
    private ListView drawerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerMenuItems = DrawerMenuItemProvider.getMenuItems();
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.menu_drawer);
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerMenuItems));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener(this.getApplicationContext()));
        }
}
