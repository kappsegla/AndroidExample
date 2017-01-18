package snowroller.androidexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Martin on 2017-01-18.
 */
public class MyBroadCastReceiver extends BroadcastReceiver {
    private static String TAG = "AndroidExample";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "BroadcastReceiver says hi!");
    }
}
