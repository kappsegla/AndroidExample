package snowroller.androidexample;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "AndroidExample";
    public final static int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 11;

    private int counter;

    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "1: onCreate");
        counter = 0;

        textView3 = (TextView)findViewById(R.id.textView3);

        if(savedInstanceState != null)
        {
            counter = savedInstanceState.getInt("counter");
            Log.i(TAG, "Instance state excisted in create");

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i(TAG, "onBackPressed");
        //this.finish();
     /*   new AlertDialog.Builder(this)
                .setMessage("Hej!")
                .setCancelable(true)
                .show();*/
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter",counter);
        Log.i(TAG,"SaveInstanceState: " + counter);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG,"ConfigurationChanged");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.i(TAG,"RestoreInstanceState: " + counter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"1: onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"1: onStop " + isFinishing());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"1: onStart");
        textView3.setText("" + counter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"1: onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"1: onResume");
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
        counter++;
        textView3.setText("" + counter);
        //finish();
          Intent intent = new Intent(this, Main2Activity.class);
          startActivity(intent);
     /*   Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,"Hello World!");
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(sendIntent);
        }*/
//        Uri webpage = Uri.parse("http://www.gp.se");
//        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
//        Intent intentChooser = Intent.createChooser(intent, "Öppna med");
//
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intentChooser);
//        }

    }
}







