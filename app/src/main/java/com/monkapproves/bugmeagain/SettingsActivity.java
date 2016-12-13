package com.monkapproves.bugmeagain;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;
public class SettingsActivity extends Activity {
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
        txtView = (TextView) findViewById(R.id.textView);
    }

    public void buttonClicked(View v) {
        if (v.getId() == R.id.btnCreateNotify) {
            NotificationCompat.Action action1 =
                    new NotificationCompat.Action.Builder(R.drawable.ic_info_black_24dp,
                            getString(R.string.app_name1), null)
                            .build();
            NotificationCompat.Action action2 =
                    new NotificationCompat.Action.Builder(R.drawable.ic_info_black_24dp,
                            getString(R.string.app_name2), null)
                            .build();
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.ic_info_black_24dp)
                            .setContentTitle("My notification number : "+ Math.random())
                            .setContentText("Hello World!")
                            .addAction(action1)
                            .addAction(action2);
            int mNotificationId = 001;
            NotificationManager mNotifyMgr =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            // Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());
        } else if (v.getId() == R.id.btnClearNotify) {
            Intent i = new Intent("com.monkapproves.bugmelater.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
            i.putExtra("command", "clearAll");
            sendBroadcast(i);
        } else if (v.getId() == R.id.btnListNotify) {
            Intent i = new Intent("com.monkapproves.bugmelater.NOTIFICATION_LISTENER_SERVICE_EXAMPLE");
            i.putExtra("command", "flush");
            sendBroadcast(i);
        } else if (v.getId() == R.id.btnGetPermissions) {
            Intent intent=new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
        }
    }
}
