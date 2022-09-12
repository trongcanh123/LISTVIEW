package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button them,capnhap;
    EditText ed;
    int vitri =-1;
    ArrayList <String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anh_xa();
        arrayList =new ArrayList<>();
        arrayList.add("ANDROID");
        arrayList.add("IOS");
        arrayList.add("PYTHON");
        arrayList.add("JAVA");
        arrayList.add("C#/C++");
        ArrayAdapter adapter =new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(adapter);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mon = ed.getText().toString();
                arrayList.add(mon);
                if(mon.length()!=0) {
                    adapter.notifyDataSetChanged();
                }else Toast.makeText(MainActivity.this, "Nhập môn học!", Toast.LENGTH_SHORT).show();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
            ed.setText(arrayList.get(i));
            vitri=i;
            }
        });
        capnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            arrayList.set(vitri,ed.getText().toString());
            adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                arrayList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    void Anh_xa(){
        lv=(ListView) findViewById(R.id.listview1);
        them=(Button) findViewById(R.id.button1);
        ed=(EditText) findViewById(R.id.editText1);
        capnhap=(Button) findViewById(R.id.button2);
    }
}