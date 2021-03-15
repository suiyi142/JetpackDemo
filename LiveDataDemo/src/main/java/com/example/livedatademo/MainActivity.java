package com.example.livedatademo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);

        PeopleLiveData peopleLiveData = new PeopleLiveData(new PeopleBean("张三", 2));
//        tv.setText("name = " + peopleLiveData.getValue().getName() + " age = " + peopleLiveData.getValue().getAge());

        peopleLiveData.observe(this, new Observer<PeopleBean>() {
            @Override
            public void onChanged(PeopleBean peopleBean) {
                Log.d(TAG, "onChanged() called with: peopleBean = [" + peopleBean + "]");
                tv.setText("name = " + peopleBean.getName() + " age = " + peopleBean.getAge());
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }
}