package com.purduerugby.jwlehman93.purduerugbyapp_android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.RosterProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;

/**
 * Created by jwlehman on 4/4/16.
 */
public class PlayerBioFragment extends Fragment{
    TextView firstName;
    TextView lastName;
    TextView position;
    TextView homeTown;
    TextView year;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.playerbio_fragment, container, false);
        Bundle args = getArguments();
        Player selectedPlayer = RosterProvider.getPlayers().get(args.getInt("playerPos"));
        setTextViews(layout, selectedPlayer);
        return layout;
    }


    public void setTextViews(View layout, Player player) {
        firstName = (TextView) layout.findViewById(R.id.firstname_text);
        firstName.setText(player.getFirstName());
        lastName = (TextView) layout.findViewById(R.id.lastname_text);
        lastName.setText(player.getLastName());
        position = (TextView) layout.findViewById(R.id.position_text);
        position.setText("Position: " + player.getPostion());
        homeTown = (TextView) layout.findViewById(R.id.hometown_text);
        homeTown.setText("Hometown: " + player.getPostion());
        year = (TextView) layout.findViewById(R.id.year_text);
        year.setText("Year in School: " + player.getYear());
    }
}
