package com.purduerugby.jwlehman93.purduerugbyapp_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.RosterProvider;

import java.util.List;

/**
 * Created by jwlehman on 4/4/16.
 */
public class RosterAdapter extends BaseAdapter {
    private Context context;
    private List<Player> players;

    public RosterAdapter(Context context) {
        this.context = context;
        players = RosterProvider.getPlayers();
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.roster_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.roster_player_name);
        name.setText(players.get(position).getFirstName() + " " + players.get(position).getLastName());
        TextView positionTitle = (TextView) convertView.findViewById(R.id.roster_player_position);
        positionTitle.setTextKeepState(players.get(position).getPostion());
        return convertView;
    }
}
