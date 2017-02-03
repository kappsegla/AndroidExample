package snowroller.androidexample.BindingTest;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import snowroller.androidexample.BR;


/**
 * Created by Martin on 2017-02-03.
 */

public class User extends BaseObservable {

    @Bindable
    public String firstName;
    public String lastName;
    public String newName;


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void onBtnClick(View view){
        this.firstName = newName;
        notifyPropertyChanged(BR.firstName);
    }

}

