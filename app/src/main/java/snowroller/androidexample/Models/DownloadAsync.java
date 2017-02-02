package snowroller.androidexample.Models;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Martin on 2017-02-02.
 */

public class DownloadAsync extends AsyncTask<String, Void, Object>{

    @Override
    protected Object doInBackground(String... params) {

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

            if(response == 200) {
                String json = getJson(conn.getInputStream());


            }
        }catch (Exception e)
        {

        }
        //Läs json data och läs ut information vi vill ha
        return null;
    }

    private String getJson(InputStream stream) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        StringBuilder builder = new StringBuilder();
        String line;

        while( (line = reader.readLine())!= null) {
            builder.append(line + '\n');
        }
        return builder.toString();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
