package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.fragments.RosterListFragment;

public class RosterActivity extends BaseActivity {
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View contentView = getLayoutInflater().inflate(R.layout.activity_roster, null, false);
        leftDrawerLayout.addView(contentView, 0);

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null)
                return;
            RosterListFragment initialFrag = new RosterListFragment();
            initialFrag.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, initialFrag)
                    .commit();
        }
    }
}