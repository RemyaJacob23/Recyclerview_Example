package com.example.reshmi.myrecyclerview.Activity.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.reshmi.myrecyclerview.Activity.Adapter.VehicleAdapter;
import com.example.reshmi.myrecyclerview.Activity.Classesssss.AppDatabase;
import com.example.reshmi.myrecyclerview.Activity.Classesssss.User;
import com.example.reshmi.myrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.reshmi.myrecyclerview.R.id.float_btn;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;
    AppCompatButton add;
    private List<User> vehicleList;
    private VehicleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (AppCompatButton) findViewById(float_btn);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        vehicleList = new ArrayList<>();


        showList();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),FormActivity.class);
                startActivity(i);
            }
        });

    }

    private void showList() {
        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                try{
                    List<User> users = AppDatabase.getAppDatabase(getApplicationContext()).userDao().getAll();
                    VehicleAdapter adapter = new VehicleAdapter(getApplicationContext(),users);
                    recyclerView.setAdapter(adapter);
                    return true;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return false;
            }
        }.execute();
    }


}

