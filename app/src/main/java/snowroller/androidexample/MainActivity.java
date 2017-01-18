package snowroller.androidexample;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "AndroidExample";
    public final static int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*//Register BroadcastReceiver from code onto context
        BroadcastReceiver br = new MyBroadCastReceiver();

        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        //filter.addAction(Intent.ACTION_CAMERA_BUTTON);
        this.registerReceiver(br, filter);
        //For longer life cycle use applicationcontext
        //this.getApplicationContext().registerReceiver(br,filter);
        */
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                }
                return;
            }
        }
    }

    public void buttonclicked(View v){
        Log.i(TAG,"Button clicked in MainActivity");
//        Intent intent = new Intent(this, Main2Activity.class);
//        startActivity(intent);
       Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Hello World!");
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(sendIntent);
        }
//        Uri webpage = Uri.parse("http://www.gp.se");
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//        Intent intentChooser = Intent.createChooser(intent, "Öppna med");
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intentChooser);
//        }

    }
}







