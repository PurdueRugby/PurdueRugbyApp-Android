package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.adapters.CalendarAdapter;
import com.purduerugby.jwlehman93.purduerugbyapp_android.listeners.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.CalendarItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.DrawerMenuItemProvider;
import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.retrofit.ApiService;
import com.purduerugby.jwlehman93.purduerugbyapp_android.singletons.ApiServiceManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class CalendarActivity extends AppCompatActivity {
    private List<String> drawerMenuItems;
    private ListView drawerListView;
    private DrawerLayout leftDrawerLayout;
    private ListView calendarListview;
    private List<String> dates;
    private List<String> descriptions;
    private List<String> results;
    private List<CalendarItem> calendarItems;
    private Context mContext;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mContext = this;

        //implement drawer
        drawerMenuItems = DrawerMenuItemProvider.getMenuItems();
        leftDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.menu_drawer);
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerMenuItems));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener(this.getApplicationContext()));
        //implement calendar
        calendarListview = (ListView) findViewById(R.id.calendar_listview);
        ApiService apiService = ApiServiceManager.getInstance().getApiServiceInstance();
        Call <List<CalendarItem>> call = apiService.getCalendar();
        call.enqueue(new Callback<List<CalendarItem>>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    Timber.d("Calendar retrieved successfully");
                    Timber.d("Response" + response.body().toString());
                    calendarListview.setAdapter(new CalendarAdapter(mContext, (List<CalendarItem>) response.body()));
                }
                else {
                    Timber.e("Calendar retrieval unsuccessful");
                    calendarListview.setAdapter(new CalendarAdapter(getApplicationContext(), new ArrayList<CalendarItem>()));
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Timber.e("Something went wrong getting calendar" + t.getMessage());
                calendarListview.setAdapter(new CalendarAdapter(getApplicationContext(), new ArrayList<CalendarItem>()));
            }
        });
    }
}