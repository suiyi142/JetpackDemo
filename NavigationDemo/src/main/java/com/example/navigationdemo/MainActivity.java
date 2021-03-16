package com.example.navigationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) throws IOException {
        switch (view.getId()) {
            case R.id.bt_default:
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_threeFragment_to_defaultFragment);
                break;
            case R.id.bt_1:
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_defaultFragment_to_oneFragment);
                break;
            case R.id.bt_2:
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_oneFragment_to_twoFragment);
                break;
            case R.id.bt_3:
                //带参数的
                Bundle bundle = new Bundle();
                bundle.putString("key", "value 1111");

                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.action_twoFragment_to_threeFragment, bundle);
                break;
            case R.id.bt_back:
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
                break;
        }
    }
}