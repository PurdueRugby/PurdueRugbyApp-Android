package com.purduerugby.jwlehman93.purduerugbyapp_android.retrofit;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by jwlehman on 4/7/16.
 */
public interface ApiService {
    @GET("/roster")
    Call<List<Player>> getPlayers();

    @GET("/roster/{player_id}")
    Call <Player> getPlayer(@Path("player_id") String _id);

    @FormUrlEncoded
    @POST("/roster/register")
    Call <Player> addUser(@Field("first_name" ) String first, @Field("last_name") String Last,
                          @Field("position") String position, @Field("hometown") String hometown,
                          @Field("year") String year);

    @FormUrlEncoded
    @PUT("/roster/{player_id}")
    Call <Player> editUser(@Path("player_id") String _id, @Field("lname") String name,
                          @Field("position") String position, @Field("hometown") String hometown,
                           @Field("homestate") String homestate, @Field("year") String year);

    @DELETE("/roster/{player_id}")
    Call <Player> deleteUser(@Path("player_id") String _id);

    @GET("/calendar")
    Call<List<CalendarItem>> getCalendar();

}
