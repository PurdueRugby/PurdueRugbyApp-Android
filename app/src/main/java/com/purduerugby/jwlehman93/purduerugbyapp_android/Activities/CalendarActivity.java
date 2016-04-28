package com.purduerugby.jwlehman93.purduerugbyapp_android.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.adapters.CalendarAdapter;
import com.purduerugby.jwlehman93.purduerugbyapp_android.listeners.DrawerItemClickListener;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;
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

public class CalendarActivity extends BaseActivity {
    private ListView calendarListview;
    private ProgressDialog mProgressDialog;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    View contentView = getLayoutInflater().inflate(R.layout.activity_calendar, null, false);
    leftDrawerLayout.addView(contentView, 0);
    //implement calendar
    calendarListview = (ListView) findViewById(R.id.calendar_listview);
    mProgressDialog = new ProgressDialog(this);
    mProgressDialog.setIndeterminate(true);
    mProgressDialog.setMessage("Loading...");
    mProgressDialog.show();
    ApiService apiService = ApiServiceManager.getInstance().getApiServiceInstance();
    Call <List<CalendarItem>> call = apiService.getCalendar();
    call.enqueue(new Callback<List<CalendarItem>>() {
        @Override
        public void onResponse(Call call, Response response) {
            if(response.isSuccessful()){
                Timber.d("Calendar retrieved successfully");
                Timber.d("Response: %s" , response.body().toString());
                calendarListview.setAdapter(new CalendarAdapter(CalendarActivity.this.getApplicationContext(), (List<CalendarItem>) response.body()));
                if(mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
            }
            else {
                Timber.e("Calendar retrieval unsuccessful");
                calendarListview.setAdapter(new CalendarAdapter(getApplicationContext(), new ArrayList<CalendarItem>()));
                if(mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
            }
        }
        @Override
        public void onFailure(Call call, Throwable t) {
            Timber.e("Something went wrong getting calendar: %s", t.getMessage());
            calendarListview.setAdapter(new CalendarAdapter(getApplicationContext(), new ArrayList<CalendarItem>()));
            if(mProgressDialog.isShowing())
                mProgressDialog.dismiss();
        }
    });
}
}