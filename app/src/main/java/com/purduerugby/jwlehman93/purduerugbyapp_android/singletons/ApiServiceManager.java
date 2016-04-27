package com.purduerugby.jwlehman93.purduerugbyapp_android.singletons;

import com.purduerugby.jwlehman93.purduerugbyapp_android.retrofit.ApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jwlehman on 4/14/16.
 */
public class ApiServiceManager {
    private static ApiServiceManager INSTANCE;

    public static ApiServiceManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiServiceManager();
        }
        return INSTANCE;
    }

    private ApiService mApiServiceInstance;

    public ApiServiceManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://purdue-rugby-android.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiServiceInstance = retrofit.create(ApiService.class);
    }

    public ApiService getApiServiceInstance() {
        return mApiServiceInstance;
    }
}
