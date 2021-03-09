package com.example.databindingdemo;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

/**
 * @CreateDate: 2021-3-4 18:59
 * @UpdateDate: 2021-3-4 18:59
 * @Description:
 * @Author: uidq2189
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserData {
    private static final String TAG = "UserData_TAG";
    static ObservableField<String> name;
    static ObservableField<Integer> age;

    public UserData(ObservableField<String> name, ObservableField<Integer> age) {
        this.name = name;
        this.age = age;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<Integer> getAge() {
        return age;
    }

    public void setAge(ObservableField<Integer> age) {
        this.age = age;
    }

//    @BindingAdapter("app:bind_input")
//    public static void contentChangeListener(View view, String newAge) {
//        Log.d(TAG, "contentChangeListener: newAge = " + newAge);
//        name.set(newAge);
//    }

    public void click(){
        Log.d(TAG, "click() called");
        Intent intent = new Intent(App.context,MainActivity2.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        App.context.startActivity(intent);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
