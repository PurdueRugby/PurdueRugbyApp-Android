package com.purduerugby.jwlehman93.purduerugbyapp_android.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.adapters.RosterAdapter;
import com.purduerugby.jwlehman93.purduerugbyapp_android.retrofit.ApiService;
import com.purduerugby.jwlehman93.purduerugbyapp_android.singletons.ApiServiceManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class RosterListFragment extends Fragment implements AdapterView.OnItemClickListener   {


    private ListView rosterList;
    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.roster_list, container, false);
        ApiService apiService = ApiServiceManager.getInstance().getApiServiceInstance();
        rosterList = (ListView) layout.findViewById(R.id.roster_list);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        Call<List<Player>> call = apiService.getPlayers();
        call.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {
                    Timber.d("Retrieved roster successfully");
                    rosterList.setAdapter(new RosterAdapter(getActivity(), (List<Player>) response.body()));
                    if(mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                }
                else {
                    Timber.e("Error" + response.errorBody());
                    if(mProgressDialog.isShowing())
                        mProgressDialog.dismiss();
                    rosterList.setAdapter(new RosterAdapter(getActivity(), new ArrayList<Player>()));
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                rosterList.setAdapter(new RosterAdapter(getActivity(), new ArrayList<Player>()));
                Timber.e("Error" + t.getMessage());
            }
        });
        rosterList.setOnItemClickListener(this);
        return layout;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Player player = (Player) parent.getItemAtPosition(position);
        PlayerBioFragment playerFrag = new PlayerBioFragment();
        Bundle args = new Bundle();
        args.putString("playerId", player.get_id());
        playerFrag.setArguments(args);
        android.support.v4.app.FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, playerFrag);
        transaction.addToBackStack(null);
        transaction.commit();
        Toast.makeText(getActivity(), player.getName(), Toast.LENGTH_SHORT).show();
    }


}