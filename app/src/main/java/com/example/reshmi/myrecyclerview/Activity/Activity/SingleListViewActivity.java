package com.example.reshmi.myrecyclerview.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.reshmi.myrecyclerview.R;

public class SingleListViewActivity extends AppCompatActivity {
    TextView text1,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_list_view);
        text1 = (TextView) findViewById(R.id.eName);
        text2 = (TextView) findViewById(R.id.eAge);
        text3 = (TextView) findViewById(R.id.eNumber);
    }
}