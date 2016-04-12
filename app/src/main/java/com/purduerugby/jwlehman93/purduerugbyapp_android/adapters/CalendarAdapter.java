package com.purduerugby.jwlehman93.purduerugbyapp_android.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.purduerugby.jwlehman93.purduerugbyapp_android.R;
import com.purduerugby.jwlehman93.purduerugbyapp_android.model.CalendarItem;
import com.purduerugby.jwlehman93.purduerugbyapp_android.providers.CalendarItemProvider;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jwlehman on 4/7/16.
 */
public class CalendarAdapter extends BaseAdapter{
    private Context context;
    private List<CalendarItem> calendarItems;

    public CalendarAdapter(Context context) {
        this.context = context;
        calendarItems = CalendarItemProvider.getCalendarItems();
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    @Override
    public int getCount() {
        return calendarItems.size();
    }

    @Override
    public Object getItem(int position) {
        return calendarItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(R.layout.calendar_row, parent, false);
        }
        TextView date = (TextView) convertView.findViewById(R.id.calendar_date);
        date.setText(calendarItems.get(position).getDate());
        TextView description = (TextView) convertView.findViewById(R.id.calendar_description);
        description.setText(calendarItems.get(position).getDescription());
        TextView results = (TextView) convertView.findViewById(R.id.calendar_result);
        results.setText(calendarItems.get(position).getResult());

        return convertView;
    }
}
