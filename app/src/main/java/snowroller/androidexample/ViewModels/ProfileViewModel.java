package snowroller.androidexample.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;

import snowroller.androidexample.InfoViewModelAdapter;
import snowroller.androidexample.Models.Model;
import snowroller.androidexample.R;

/**
 * Created by Martin on 2017-01-25.
 */

public class ProfileViewModel extends BaseObservable {

    public static final int LOADING_SHORT = 1000;

    public final ObservableField<String> realName = new ObservableField<>();
    public final ObservableField<String> profileText = new ObservableField<>();

    //For RecyclerView
    public ObservableArrayList<InfoViewModel> list = new ObservableArrayList<>();

    private String name;
    private boolean isOnline;
    private boolean isLoaded;

    private Model model;

    public ProfileViewModel(String name, String realname)
    {
        this.name = name;
        this.realName.set(realname);
        this.profileText.set("Lorum ipsum placeholder text att visa på demoprofiler.");
        isOnline = false;
        isLoaded = true;
        model = Model.getInstance();

        model.getList().addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<String>>() {
            @Override
            public void onChanged(ObservableList<String> strings) {
            }

            @Override
            public void onItemRangeChanged(ObservableList<String> strings, int i, int i1) {

            }

            @Override
            public void onItemRangeInserted(ObservableList<String> strings, int i, int i1) {
                list.clear();
                for (String s : strings) {
                    list.add(new InfoViewModel(R.drawable.cat, s));
                }
            }

            @Override
            public void onItemRangeMoved(ObservableList<String> strings, int i, int i1, int i2) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList<String> strings, int i, int i1) {

            }
        });

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

    public void bottomButtonClicked() {
       model.updateRepos();

        //list.add(new InfoViewModel(R.drawable.cat,"Row " + (list.size()+1)));
    }

    //Replaces ? View.VISIBLE : View.GONE
    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter("app:items")
    public static void bindList(RecyclerView view, ObservableArrayList<InfoViewModel> list) {
        //Recyclerview layout setting moved to xml. Shouldn't be here.
        //LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        //view.setLayoutManager(layoutManager);
        view.setAdapter(new InfoViewModelAdapter(list));
    }
    @BindingAdapter("bind:imageRes")
    public static void bindImage(ImageView view, int r) {
        view.setImageResource(r);
    }
}







