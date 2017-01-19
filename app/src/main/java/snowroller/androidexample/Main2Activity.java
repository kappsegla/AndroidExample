package snowroller.androidexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    private static String TAG = "AndroidExample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.i(TAG,"2: onCreate");
        Intent i = getIntent();
        handleIntent(i);
    }
    private void handleIntent(Intent intent)
    {

    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    public void buttonClicked(View v)
    {
        Log.i(TAG,"Button clicked in Main2Activity");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"2: onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"2: onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"2: onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"2: onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"2: onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"2: onDestroy");
    }
}
