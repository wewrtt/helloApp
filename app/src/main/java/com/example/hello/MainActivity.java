package com.example.hello;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG=MainActivity.class.getSimpleName();
    public  static  EditText editText1,editText2;
    public static  Button button,button2,btnMenu,button3;
    public static TextView textView;

    public  int a, b;
    public   void Exeption(){
        Toast.makeText(this,"2 số ko để trống",Toast.LENGTH_SHORT).show();
    }

    public  void anhXa(){
        editText1 = findViewById(R.id.edittext1);
        editText2 = findViewById(R.id.edittext2);
        textView= findViewById(R.id.result);
        btnMenu=findViewById(R.id.btnpopUpMenu);
        button3=findViewById(R.id.btnScreem3);
    }
    //chọn từ menu tổng

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return  menuSeclect(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected  void onSaveInstanceState(Bundle outState){
            super.onSaveInstanceState(outState);
            if(!textView.getText().toString().isEmpty()){
                try{
                    outState.putInt("a",Integer.parseInt(editText1.getText().toString()));
                    outState.putInt("b",Integer.parseInt(editText1.getText().toString()));
                    outState.putInt("tong",Integer.parseInt(textView.getText().toString()));
                }catch (Exception e){
                   // Exeption();
                }

            }
    }
    public void clickButton1(){
        try {
            a=Integer.parseInt(editText1.getText().toString());
            b=Integer.parseInt(editText2.getText().toString());

            int result;
            CaculaterAdd tong= new CaculaterAdd(a,b);
            result=tong.add();
            textView.setText(result+"");
        }catch (Exception e){
            Exeption();
        }
    };
    public  void clickButton2(){
        Intent i= new Intent(this,SecondScreem.class);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dinhdangngay= new SimpleDateFormat("dd/MM/yyyy");
        String a= dinhdangngay.format(calendar.getTime());
        //String
        i.putExtra("key1",a);
        // number
        i.putExtra("So1",2842000);
        //object
        Student s= new Student("Long","22","nam");
        i.putExtra("Object1",s);


        startActivity(i);
    }
    public  void clickButton3(){
        Intent i= new Intent(this,ThirdScreem.class);
        startActivity(i);
    }
    // pop menu in btn

    public  void clickBtnMenu(){

        PopupMenu popupMenu = new PopupMenu(this,btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_demo,  popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                    return menuSeclect(item);
            }
        });
        popupMenu.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        if(savedInstanceState !=null){
            editText1.setText(savedInstanceState.getInt("a")+"");
            editText1.setText(savedInstanceState.getInt("b")+"");
            textView.setText(savedInstanceState.getInt("tong")+"");
        }
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.buttonChuyenIntent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton2();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton3();
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBtnMenu();
            }
        });

    }
    public  boolean menuSeclect(MenuItem item){
        Context context=this;
        switch (item.getItemId()){

            case  R.id.menu_setting:
                Toast.makeText(context,"setting",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.menu_share:
                Toast.makeText(context,"share",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.menu_search:
                Toast.makeText(context,"search",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return  false;
        }
    }

}

