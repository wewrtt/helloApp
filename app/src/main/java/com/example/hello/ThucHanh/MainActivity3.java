package com.example.hello.ThucHanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hello.BaiTap.SpinnerDemo;
import com.example.hello.R;
import com.example.hello.model.Address;

public class MainActivity3 extends AppCompatActivity {
    private ListView listView ;
    private ArrayAdapter<String> adapter;
    public void anhXa(){
        listView =findViewById(R.id.listviewDemo);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        anhXa();
        String SV="Trịnh Thành Long + B18DCAT151";
        String[] arr={SV,"Hà Nội","TP. Hồ Chí Minh","Đà Nẵng","Hải Phòng","Thanh Hóa","Ninh Bình"};
        adapter = new ArrayAdapter<String>(MainActivity3.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                   int img=R.drawable.hanoi;
                   double dienTich=2.095;
                   double danSo=7.162;
                   Address address = new Address(dienTich,danSo,img);
                    clickItem(address);

                }
                else if(position==2){
                    int img=R.drawable.tphcm;
                    double dienTich=3.3586;
                    double danSo=8.25;
                    Address address = new Address(dienTich,danSo,img);
                    clickItem(address);

                }
                else if(position==3){
                    int img=R.drawable.nangda;
                    double dienTich=1.285;
                    double danSo=1.134;
                    Address address = new Address(dienTich,danSo,img);
                    clickItem(address);

                }
                else if(position==4){
                    int img=R.drawable.haiphong;
                    double dienTich=1.562 ;
                    double danSo=2.029 ;
                    Address address = new Address(dienTich,danSo,img);
                    clickItem(address);

                }
                else if(position==5){
                    int img=R.drawable.thanhhoa;
                    double dienTich=146.8;
                    double danSo=340.512;
                    Address address = new Address(dienTich,danSo,img);
                    clickItem(address);
                }
                else if(position==6){
                    int img=R.drawable.ninhbinh;
                    double dienTich=48.36;
                    double danSo=160.166;
                    Address address = new Address(dienTich,danSo,img);
                    clickItem(address);
                }
            }
        });
    }
    public void clickItem(Address address){
        Intent i = new Intent(MainActivity3.this,Description.class);
        i.putExtra("address",address);
        startActivity(i);
    }
}