package snowroller.androidexample.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;

import snowroller.androidexample.AndroidInfoAdapter;

/**
 * Created by Martin on 2017-01-25.
 */

public class ProfileViewModel extends BaseObservable {

    public static final int LOADING_SHORT = 1000;

    public final ObservableField<String> realName = new ObservableField<>();
    public final ObservableField<String> profileText = new ObservableField<>();

    //For RecyclerView
    public ObservableArrayList<AndroidInfo> list = new ObservableArrayList<>();

    private String name;
    private boolean isOnline;
    private boolean isLoaded;

    public ProfileViewModel(String name, String realname)
    {
        this.name = name;
        this.realName.set(realname);
        this.profileText.set("Lorum ipsum placeholder text att visa på demoprofiler.");
        isOnline = false;
        isLoaded = true;
        list.add(new AndroidInfo(0,"Row 1"));
        list.add(new AndroidInfo(0,"Row 2"));
        list.add(new AndroidInfo(0,"Row 3"));
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {

            this.name = name;
            notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean isLoaded() {
        return isLoaded;
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
        notifyPropertyChanged(BR.loaded);
    }

    @Bindable
    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
        notifyPropertyChanged(BR.online);
    }

    public void leftButtonClicked(View view)
    {
       // Log.i("AndroidExample","LeftButtonClicked");
        this.profileText.set("Ny text att förundras över");
    }

    public void rightButtonClicked(View view) {
        setLoaded(false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setOnline(!isOnline());
                setLoaded(true);
            }
        }, 1000);
    }

    public void bottomButtonClicked(View view) {
        list.add(new AndroidInfo(0,"Row " + (list.size()+1)));
    }
/*
        load(new Runnable() {
        @Override
        public void run() {
            setOnline(!isOnline());
            setLoaded(true);
        }
    });
*/
  private void load(Runnable onLoaded) {
        setLoaded(false);
        new Handler().postDelayed(onLoaded, LOADING_SHORT);
    }

    //Replaces ? View.VISIBLE : View.GONE
    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter("app:items")
    public static void bindList(RecyclerView view, ObservableArrayList<AndroidInfo> list) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(layoutManager);
        view.setAdapter(new AndroidInfoAdapter(list));
    }
    @BindingAdapter("app:imageRes")
    public static void bindImage(ImageView view, int r) {
        view.setImageResource(r);
    }
}







