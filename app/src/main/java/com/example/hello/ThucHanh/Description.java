package com.example.hello.ThucHanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hello.R;
import com.example.hello.model.Address;

public class Description extends AppCompatActivity {
    private ImageView img;
    private  TextView dienTich,danSo;
    public void anhxa(){
        img=findViewById(R.id.imageView2);
        dienTich = findViewById(R.id.txt_dienTich);
        danSo= findViewById(R.id.txt_danSo);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        anhxa();
        Bundle bundle= getIntent().getExtras();
        Address add= (Address) bundle.get("address");
        img.setImageResource(add.getImg());
        dienTich.setText("Diện Tích: "+add.getDienTich()+" km2");
        danSo.setText("Dân Số: "+add.getDanSo()+ " triệu người");
    }
}