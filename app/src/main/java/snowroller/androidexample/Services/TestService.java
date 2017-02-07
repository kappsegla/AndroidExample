package snowroller.androidexample.Services;

import android.app.Service;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import snowroller.androidexample.Models.Model;
import snowroller.androidexample.R;

/**
 * Created by Martin on 2017-02-07.
 */

public class TestService extends Service {

    Model model;

    @Override
    public void onCreate() {
        model = Model.getInstance();
        Log.i("AndroidExample","TestService: onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AndroidExample", "TestService: onStartCommand");

        //Gör nätverksläsningen.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
             downloadFromSkistar();
            }
        });
        t.start();
        //MediaPlayer mp = MediaPlayer.create(this, R.raw.banana);
        //mp.start();
        this.stopSelf(startId);
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void downloadFromSkistar()
    {
        //Anslut till http endpoint och läs json data
        // https://api.github.com/users/kappsegla/repos
        try {
            URL url = new URL("https://api.github.com/users/kappsegla/repos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            // Starts the query
            conn.connect();

            int response = conn.getResponseCode();
            Log.i("AndroidExample", "Response: " + response);

            if (response == 200) {
                String json = getJson(conn.getInputStream());

                //JSONObject jsonObject= new JSONObject(json);
                JSONArray jsonArray = new JSONArray(json);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String reponame = jsonObject.getString("name");
                    model.addItem(reponame);
                }
            }
        } catch (Exception e) {
            Log.i("AndroidExample", "Error");
        } finally {

        }
    }
    private String getJson(InputStream stream) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            builder.append(line + '\n');
        }
        //Should be placed in finally
        stream.close();
        return builder.toString();
    }

}
