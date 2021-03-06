package snowroller.androidexample.Helpers;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import snowroller.androidexample.R;
import snowroller.androidexample.StartActivity;

/**
 * Created by Martin on 2017-02-03.
 */

public class Notifications {
    public static void showSimpleNotification(Context context) {
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.cat);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        //The above three is minimum to show notification
                        .setAutoCancel(true)
                        .setLargeIcon(bm);


// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, StartActivity.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(StartActivity.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        int mId = 100;
        mNotificationManager.notify(mId, mBuilder.build());
    }

}
