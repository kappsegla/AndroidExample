package snowroller.androidexample.Models;

import android.databinding.ObservableArrayList;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 2017-02-02.
 */

public class Model
{

    private static final Model model = new Model();

    private Model(){}
    public static Model getInstance()
    {
        return model;
    }

    private ObservableArrayList<String> list = new ObservableArrayList<>();

    public ObservableArrayList<String> getList() {
        return list;
    }


    public void addItem(String text)
    {
        if(!text.isEmpty()) {
            list.add(text);
        }
    }



    public void updateRepos() {
      //  DownloadAsync download = new DownloadAsync();
      //  download.execute();
    }
}
