package com.example.navigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TwoFragment extends Fragment {
    private static final String TAG = "TwoFragment_TAG";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //取出消息
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = TwoFragmentArgs.fromBundle(getArguments()).getName();
            int age = TwoFragmentArgs.fromBundle(getArguments()).getAge();
            Toast.makeText(getContext(), "name = " + name + " age = " + age, Toast.LENGTH_SHORT).show();
        } else {
            Log.d(TAG, "onResume: null");
        }
    }
}