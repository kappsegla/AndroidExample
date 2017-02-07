package snowroller.androidexample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);
        //return Service.START_NOT_STICKY or Service.START_STICKY

        //Do Something... maybe start a thread?
        MediaPlayer mp = MediaPlayer.create(this, R.raw.banana);
        mp.start();

        this.stopSelf(startId);

        //Tell what should happen when the service is killed on low resources
        //Does not apply when using stopSelf...
       return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
