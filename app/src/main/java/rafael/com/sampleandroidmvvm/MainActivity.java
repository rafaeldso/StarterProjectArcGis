package rafael.com.sampleandroidmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rafael.com.sampleandroidmvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();
    }
    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if(message != null)
            Toast.makeText(view.getContext(),message, Toast.LENGTH_SHORT).show();
    }
}
