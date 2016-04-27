package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.listeners.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.DrawerMenuItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.fragments.RosterFragment;

import java.util.List;

public class RosterActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = getLayoutInflater().inflate(R.layout.activity_roster, null, false);
        leftDrawerLayout.addView(contentView, 0);
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