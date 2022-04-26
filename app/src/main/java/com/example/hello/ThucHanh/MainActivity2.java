package com.example.hello.ThucHanh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hello.R;

public class MainActivity2 extends AppCompatActivity {
    public String TAG= MainActivity2.class.getSimpleName();
    public Button btn_save;
    public EditText txt_age;
    private SharedPreferences sharedPreferences;
    private  int tuoi=0;
    private  int backGround=0;
    public ConstraintLayout layout;
    public  void anhXa(){
        txt_age= findViewById(R.id.edt_age);
        btn_save=findViewById(R.id.save);
        layout= findViewById(R.id.background);
        sharedPreferences =getSharedPreferences("config",MODE_PRIVATE);
    }
    public void save(int  age,int img){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("age",age);
        editor.putInt("backGround",img);
        editor.commit();
    };
    public void getParameter(){
        txt_age.setText(sharedPreferences.getInt("age",0)+"");
        layout.setBackground(getDrawable(sharedPreferences.getInt("backGround",R.drawable.thieunhi)));
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        getParameter();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this,"save",Toast.LENGTH_LONG).show();
                int age=Integer.parseInt(txt_age.getText().toString());
                if(age<1){
                    Toast.makeText(MainActivity2.this,"nhập tuổi > 0",Toast.LENGTH_LONG).show();
                }
                else if(age>=1 && age<=10){
                    tuoi =age;
                    backGround= R.drawable.thieunhi;
                    layout.setBackground(getDrawable(backGround));
                }
                else if(age>=11 && age<=17){
                    tuoi =age;
                    backGround= R.drawable.tuoiteen;
                    layout.setBackground(getDrawable(backGround));
                }
                else {
                    tuoi =age;
                    backGround= R.drawable.nguoilon;
                    layout.setBackground(getDrawable(backGround));
                }

                save(tuoi,backGround);
            }
        });


    }
}