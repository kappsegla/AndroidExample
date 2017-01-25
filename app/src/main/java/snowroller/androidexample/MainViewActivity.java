package snowroller.androidexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import snowroller.androidexample.ViewModels.ProfileViewModel;
import snowroller.androidexample.databinding.ActivityMainViewBinding;

public class MainViewActivity extends AppCompatActivity {

    private final ProfileViewModel profile = new ProfileViewModel("Grumpy Cat","Tardar Sauce");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_view);

        ActivityMainViewBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_main_view);

        binding.setProfile(profile);
    }
}
