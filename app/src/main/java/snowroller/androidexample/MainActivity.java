package snowroller.androidexample;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "AndroidExample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver br = new MyBroadCastReceiver();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_CALL);
        this.registerReceiver(br, filter);
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







