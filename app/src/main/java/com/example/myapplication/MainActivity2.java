package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView chitiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chitiet = findViewById(R.id.chitiet);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        chitiet.setText("MÔN HỌC: "+data);
    }
}