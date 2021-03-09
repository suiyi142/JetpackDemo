package com.example.databindingdemo;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import com.example.databindingdemo.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private static final String url1 = "https://upload.jianshu.io/users/upload_avatars/17298751/10d83b02-dd3a-4efb-a3a4-4717edc65a73.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/80/h/80/format/webp";
    private static final String url2 ="https://upload.jianshu.io/users/upload_avatars/8690467/de6a715d-ca34-48dc-9afc-b89fb1fb1504.jpeg?imageMogr2/auto-orient/strip|imageView2/1/w/80/h/80/format/webp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMain2Binding binding =  DataBindingUtil.setContentView(this,R.layout.activity_main2);
        binding.setUser(new UserData());
        UserDataAttr userDataAttr = new UserDataAttr();
        binding.setDataAttr(userDataAttr);
        //先设置一个url
        userDataAttr.setUrl(new ObservableField<>(url1));
        //5s后再设置一个新的url
        new Handler().postDelayed(() -> userDataAttr.getUrl().set(url2),5000);
    }
}