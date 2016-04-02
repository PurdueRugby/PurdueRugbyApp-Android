package com.purduerugby.jwlehman93.purduerugbyapp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.AboutActivity;
import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.CalendarActivity;
import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.HomeActivity;
import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.RosterActivity;


/**so if I want to start a new activity from a separate class than the current activitydo I pass a context from the class I want to start the new activity from? My app just closes whenever I try to start the new activity
 * Created by jwlehman on 3/30/16.
 */
public class DrawerItemClickListener extends Activity implements ListView.OnItemClickListener {

    Context context;

    public DrawerItemClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       selectItem(position);
    }


    private void selectItem(int position) {
       switch(position) {
           case 0: {
               Toast.makeText(context,"Home clicked", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent();
               intent.setClass(context, HomeActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
               break;
           }
           case 1: {
               Toast.makeText(context,"roster clicked", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent();
               intent.setClass(context, RosterActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
               break;
           }
           case 2: {
               Toast.makeText(context,"calendar clicked", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(context, CalendarActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
               break;
           }
           case 3: {
               Toast.makeText(context,"about clicked", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(context, AboutActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
               break;
           }
           default:
               break;
       }

    }
}
