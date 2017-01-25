/*
package snowroller.androidexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.ObservableField;
import android.os.Handler;
import android.view.View;

*/
/**
 * Created by Martin on 2017-01-24.
 *//*


public class PersonViewModel {

    public static final int LOADING_SHORT = 1000;

    //public String name;
    public final ObservableField<String> name = new ObservableField<>();
    public String surname;
    public String status;
    private boolean isOnline;
    private boolean isFriend;
    private boolean isLoaded;

    public PersonViewModel()
    {
        name.set("Martin");
        surname = "Blomberg";
        status = "Ojoj mycket text var det inskrivet här. Inte helt lätt att förstå alltid";
        isOnline = true;
        isFriend = false;
        isLoaded = true;
    }



    @Bindable
    public boolean getIsLoaded() {
        return this.isLoaded;
    }

    public void setIsLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
        //notifyPropertyChanged(BR.isLoaded);
    }

    @Bindable
    public boolean getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
        //notifyPropertyChanged(BR.isFriend);
    }

    public void onMessageClick(){
        this.name.set("Donald J Trump");
    }


    public void changeFriendshipStatus(View view) {
        load(new Runnable() {
            @Override
            public void run() {
                setIsFriend(!isFriend);
                setIsLoaded(true);
            }
        });
    }

    private void load(Runnable onLoaded) {
        setIsLoaded(false);
        new Handler().postDelayed(onLoaded, LOADING_SHORT);
    }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }
}
*/
