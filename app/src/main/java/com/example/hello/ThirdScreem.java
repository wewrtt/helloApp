package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ThirdScreem extends AppCompatActivity {
    private  static final String TAG=ThirdScreem.class.getSimpleName();
    private ImageView message,browser,phone;
    private EditText txt_username,txt_password;
    private CheckBox checkBox;
    private Button btn_login;
    private Context context=this;
    private SharedPreferences sharedPreferences;
    public  void findById(){
        message= findViewById(R.id.imageView_message);
        browser=findViewById(R.id.imageViewa_browser);
        phone=findViewById(R.id.imageView_phone);
        txt_username=findViewById(R.id.edt_username);
        txt_password=findViewById(R.id.edt_password);
        checkBox=findViewById(R.id.checkBox);
        btn_login= findViewById(R.id.login);
    }
    public  void getParameter(){
        txt_username.setText(sharedPreferences.getString("tk",""));
        txt_password.setText(sharedPreferences.getString("mk",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screem);
        findById();

        // ghi nhớ mk;
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        getParameter();
        //sendto activity
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:0358355048"));
                i.putExtra("sms_body","chào bạn.......");
                startActivity(i);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(i);
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_CALL, Uri.parse("tel:0358355048"));
                startActivity(i);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk,mk;
                tk=txt_username.getText().toString();
                mk=txt_password.getText().toString();
                if(tk.equals("long28")&&mk.equals("2842000")){
                    Toast.makeText(context,"login successfully",Toast.LENGTH_SHORT).show();
                    if(checkBox.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("tk",tk);
                        editor.putString("mk",mk);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else {
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.remove("tk"); editor.remove("mk"); editor.remove("checked");
                        editor.commit();
                    }
                }
                else Toast.makeText(context,"login Unsuccessfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}