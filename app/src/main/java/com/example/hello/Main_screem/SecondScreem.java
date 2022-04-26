package com.example.hello.Main_screem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hello.R;
import com.example.hello.listView.ListStudentAdapter;
import com.example.hello.model.Student;

import java.util.ArrayList;
import java.util.List;

public class SecondScreem extends AppCompatActivity {
    public static final String TAG=SecondScreem.class.getSimpleName();
    private ListView listView;
    private Context context;
    private  List<Student> listStudent= new ArrayList<>();
    private ListStudentAdapter adapter;
    private Button b1,b2;
    public void findByID(){
        listView= findViewById(R.id.listViewNumber);
        b1= findViewById(R.id.btn);
        b2=findViewById(R.id.btnYutobe);
    }
    private  void addListStudent(){
        listStudent.add(new Student("Nam","21","Nữ"));
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screem);
        findByID();
        TextView t1= findViewById(R.id.textSecond);
        Bundle extras= getIntent().getExtras();
         // receive String
        String a=extras.getString("key1");
        t1.setText(a);
        // receive Number
        int a1= extras.getInt("So1");
        Log.e(TAG,a1+"");
        //recieve Object
        Student s= (Student) extras.get("Object1");



        context=this;

        listStudent.add(new Student("long","22","nam"));
        listStudent.add(new Student("kiên","22","nam"));
        listStudent.add(new Student("trang","22","nữ"));
        listStudent.add(new Student("thắng","22","nữ"));

        adapter = new ListStudentAdapter( context ,R.layout.student,listStudent);
        listView.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListStudent();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
                startActivity(i);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alerBuilder= new AlertDialog.Builder(context);
                alerBuilder.setTitle("xác nhận");
                alerBuilder.setMessage("bạn có muốn xóa sinh viên này ko?");
                alerBuilder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listStudent.remove(listStudent.get(position));
                        adapter.notifyDataSetChanged();
                    }
                });
                alerBuilder.setNegativeButton("ko ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         alerBuilder.setCancelable(true);
                    }
                });

                AlertDialog a= alerBuilder.create();
                a.show();
                return false;
            }
        });


    }

}