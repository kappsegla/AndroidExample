package snowroller.androidexample.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import snowroller.androidexample.R;

/**
 * Created by Martin on 2017-02-07.
 */

public class TestService extends Service {

    @Override
    public void onCreate() {
        Log.i("AndroidExample","TestService: onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AndroidExample", "TestService: onStartCommand");
        MediaPlayer mp = MediaPlayer.create(this, R.raw.banana);
        mp.start();

        this.stopSelf(startId);
        return Service.START_NOT_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
