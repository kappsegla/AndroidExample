package snowroller.androidexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

/**
 * Created by Martin on 2017-01-21.
 */

public class MyDataBindingHelper extends BaseObservable {
    private String salutation;

    public static MyDataBindingHelper get(String salutation) {
        return new MyDataBindingHelper(salutation);
    }

    public MyDataBindingHelper(String salutation) {
        this.salutation = salutation;
    }

    @Bindable
    public String getMessage() {
        return salutation;
    }

    public void setMessage(String salutation){
        this.salutation = salutation;
        notifyPropertyChanged(BR.message);
    }

    public void doSomething(View view) {
        setMessage("Martin");
    }
}
