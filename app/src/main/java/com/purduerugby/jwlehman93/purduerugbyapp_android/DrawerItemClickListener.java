package com.purduerugby.jwlehman93.purduerugbyapp_android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.AboutActivity;
import com.purduerugby.jwlehman93.purduerugbyapp_android.Activities.MainActivity;


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
               intent.setClass(context, MainActivity.class);
               context.startActivity(intent);
               break;
           }
           case 1: {
               Toast.makeText(context,"about clicked", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent();
               intent.setClass(context, AboutActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
               break;
           }
           /*
           case 2: {
               Intent intent = new Intent(context, RosterActivity.class);
               startActivity(intent);
               break;
           }
           */
           default:
               break;
       }

    }
}
