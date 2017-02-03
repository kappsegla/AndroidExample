package snowroller.androidexample.BindingTest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import snowroller.androidexample.R;
import snowroller.androidexample.databinding.ActivityBindingTestBinding;

public class BindingTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_test);
        User user = new User("Andreas", "Lagerhjelm");
        binding.setUserdata(user);

    }
}
