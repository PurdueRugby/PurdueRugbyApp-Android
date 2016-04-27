package com.purduerugby.jwlehman93.purduerugbyapp_android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;
import com.purduerugby.jwlehman93.purduerugbyapp_android.retrofit.ApiService;
import com.purduerugby.jwlehman93.purduerugbyapp_android.singletons.ApiServiceManager;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by jwlehman on 4/4/16.
 */
public class PlayerBioFragment extends Fragment{
    private Player selectedPlayer;
    private TextView firstName;
    private TextView lastName;
    private TextView height;
    private TextView weight;
    private TextView position;
    private TextView homeTown;
    private TextView year;
    private View layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.playerbio_fragment, container, false);
        Bundle args = getArguments();
        ApiService apiService = ApiServiceManager.getInstance().getApiServiceInstance();
        Timber.d(args.getString("playerId"));
        Call<Player> call = apiService.getPlayer(args.getString("playerId"));
        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {
                    Timber.d("In Method %s", ((Player) response.body()).get_id());
                    selectedPlayer = (Player) response.body();
                    setTextViews(layout, selectedPlayer);

                }
                else {
                    selectedPlayer = new Player();
                    Timber.e("Error getting Player");
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Timber.e("Error %s", t.getMessage());
                selectedPlayer = new Player();
            }
        });
        return layout;
    }


    public void setTextViews(View layout, Player player) {
        String name = player.getName();
        firstName = (TextView) layout.findViewById(R.id.firstname_text);
        firstName.setText(name.split(" ")[0]);
        lastName = (TextView) layout.findViewById(R.id.lastname_text);
        lastName.setText(name.split(" ")[1]);
        height = (TextView) layout.findViewById(R.id.height_text);
        height.setText(String.format(getString(R.string.bio_height), player.getHeight()));
        weight = (TextView) layout.findViewById(R.id.weight_text);
        weight.setText(String.format(getString(R.string.bio_weight),player.getWeight()));
        position = (TextView) layout.findViewById(R.id.position_text);
        position.setText(String.format(getString(R.string.bio_position), player.getPosition()));
        homeTown = (TextView) layout.findViewById(R.id.hometown_text);
        homeTown.setText(String.format(getString(R.string.bio_hometown),player.getHometown(), player.getHomestate()));
        year = (TextView) layout.findViewById(R.id.year_text);
        year.setText(String.format(getString(R.string.bio_year), player.getYear()));
    }
}
