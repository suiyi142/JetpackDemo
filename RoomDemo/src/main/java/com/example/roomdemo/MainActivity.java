package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {
    private static final String TAG = "MainActivity_Room";

    private UserDao userDao;
    private EditText etName;
    private EditText etAge;
    private List<User> list;
    private SwipeRefreshLayout srl;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        srl = findViewById(R.id.srl);
        ListView lv = findViewById(R.id.lv);

        UserDb userDb = Room.databaseBuilder(this, UserDb.class, "Database")
                .allowMainThreadQueries()
                .build();
        userDao = userDb.getUserDao();
        list = userDao.getAllUser();
        srl.setOnRefreshListener(this);
        adapter = new MyAdapter(this, list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    public void add(View view) {
        userDao.insertUser(new User(etName.getText().toString(), Integer.parseInt(etAge.getText().toString())));
    }

    public void update(View view) {
        int line = userDao.updateUserByName(etName.getText().toString(), Integer.parseInt(etAge.getText().toString()));
        Toast.makeText(this, "修改了" + line + "行", Toast.LENGTH_SHORT).show();
    }

    public void delete(View view) {
        int line = userDao.deleteUserByName(etName.getText().toString());
        Toast.makeText(this, "删除了" + line + "行", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        list.clear();
        list.addAll(userDao.getAllUser());
        Log.d(TAG, "onRefresh: ");
        adapter.notifyDataSetChanged();
        srl.setRefreshing(false);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        etName.setText(list.get(position).getName());
        etAge.setText(list.get(position).getAge() + "");
    }
}