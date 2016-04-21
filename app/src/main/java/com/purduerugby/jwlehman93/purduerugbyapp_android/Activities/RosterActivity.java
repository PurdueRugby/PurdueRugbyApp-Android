package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.listeners.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.DrawerMenuItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.fragments.RosterFragment;

import java.util.List;

public class RosterActivity extends AppCompatActivity {
    private List<String> drawerMenuItems;
    private ListView drawerListView;
    private DrawerLayout leftDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
        drawerMenuItems = DrawerMenuItemProvider.getMenuItems();
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.menu_drawer);
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerMenuItems));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener(this.getApplicationContext()));
        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null)
                return;
            RosterFragment initialFrag = new RosterFragment();
            initialFrag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, initialFrag)
                    .commit();
        }
    }

}