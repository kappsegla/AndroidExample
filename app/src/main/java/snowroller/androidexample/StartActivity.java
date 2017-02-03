package snowroller.androidexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import snowroller.androidexample.BindingTest.BindingTestActivity;
import snowroller.androidexample.listviewexample.ListViewActivity;

public class StartActivity extends AppCompatActivity {

    private static String TAG = "AndroidExample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

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
        Log.i(TAG,"Button clicked in StartActivity");
        if( v.getId() == R.id.start_main_view_activity_button)
        {
            Intent intent = new Intent(this, MainViewActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.start_list_view_example_button)
        {
            Intent intent = new Intent(this, ListViewActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.start_bindingtest_activity)
        {
            Intent intent = new Intent(this, BindingTestActivity.class);
            startActivity(intent);
        }
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
