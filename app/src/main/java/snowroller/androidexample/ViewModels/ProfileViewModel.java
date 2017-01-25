package snowroller.androidexample.ViewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.util.Log;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Martin on 2017-01-25.
 */

public class ProfileViewModel extends BaseObservable {

    private String name;
    private boolean isOnline;

    public ProfileViewModel(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
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
        Log.i("AndroidExample","LeftButtonClicked");
        //setName("Martin");
        setOnline(!isOnline());
    }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}







