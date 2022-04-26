package com.example.hello.BaiTap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hello.R;
import com.google.android.material.navigation.NavigationView;

public class SpinnerDemo extends AppCompatActivity {
    private  static  final String TAG= SpinnerDemo.class.getSimpleName();
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private  Button btn;
    public void anhXa(){
        toolbar = findViewById(R.id.toolbar);
        navigationView= findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawaaleLayout);
        listView = findViewById(R.id.lv);
        btn= findViewById(R.id.btn_navigation);
    }
    private void  actionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_x);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_view);
        anhXa();
        actionToolBar();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SpinnerDemo.this,"ok rồi",Toast.LENGTH_LONG).show();
            }
        });
    }
}

// DEMO spinner and text view recoment
//String[] student={"long","thang","thanh","ngoc","nghia","huy",
//                "ha","chien","kien","thanh","tuan"};
//        adapter = new ArrayAdapter<String>(SpinnerDemo.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
//                ,student);
//
//        autoCompleteTextView.setAdapter(adapter);
//        autoCompleteTextView.setThreshold(1);
//
//        adapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(SpinnerDemo.this,"postion :"+position
//                        +"-> value: "+student[position],Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                Toast.makeText(SpinnerDemo.this,"Nothing",Toast.LENGTH_LONG).show();
//            }
//        });