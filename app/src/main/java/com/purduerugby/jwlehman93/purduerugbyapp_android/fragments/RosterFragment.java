package com.purduerugby.jwlehman93.purduerugbyapp_android.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.purduerugby.jwlehman93.purduerugbyapp_android.PlayerProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.RosterAdapter;

import java.util.List;


public class RosterFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView rosterList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.roster_list, container, false);
        rosterList = (ListView) layout.findViewById(R.id.roster_list);
        rosterList.setAdapter(new RosterAdapter(getActivity()));
        rosterList.setOnItemClickListener(this);
        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), PlayerProvider.getPlayers().get(position).getFirstName(), Toast.LENGTH_SHORT).show();
    }
}