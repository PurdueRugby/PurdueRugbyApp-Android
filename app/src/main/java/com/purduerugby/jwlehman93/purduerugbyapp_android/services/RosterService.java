package com.purduerugby.jwlehman93.purduerugbyapp_android.services;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by jwlehman on 4/7/16.
 */
public interface RosterService {
    @GET("roster")
    Call<List<Player>> listPlayers();

    @GET("roster/{player_id}")
    Call <Player> getPlayer();

    @FormUrlEncoded
    @POST("roster/register")
    Call <Player> addUser(@Field("first_name" ) String first, @Field("last_name") String Last,
                          @Field("position") String position, @Field("hometown") String hometown,
                          @Field("year") String year);

    @FormUrlEncoded
    @PUT("roster/{player_id}")
    Call <Player> editUser(@Field("first_name" ) String first, @Field("last_name") String Last,
                          @Field("position") String position, @Field("hometown") String hometown,
                          @Field("year") String year);

    @DELETE
    Call <Player> deleteUser();

}
