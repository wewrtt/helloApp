package com.example.hello;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class GridviewDmo extends AppCompatActivity {
    private Context context;
    private List<Student> listStudent=new ArrayList<>();
    private GridView gridView;
    private ListStudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_dmo);
        gridView = findViewById(R.id.GridView);
        context=this;
        listStudent.add(new Student("long","22","nam"));
        listStudent.add(new Student("kiên","22","nam"));
        listStudent.add(new Student("trang","22","nữ"));
        listStudent.add(new Student("thắng","22","nữ"));
        adapter= new ListStudentAdapter(context,R.layout.student,listStudent);
        gridView.setAdapter(adapter);

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alBuilder= new AlertDialog.Builder(context);
                alBuilder.setTitle("xác nhận");
                alBuilder.setMessage("bạn có muốn xóa sinh viên này ko?");
                alBuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listStudent.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                alBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alBuilder.setCancelable(true);
                    }
                });
                AlertDialog alertDialog= alBuilder.create();
                alertDialog.show();
                return false;
            }
        });
    }

}