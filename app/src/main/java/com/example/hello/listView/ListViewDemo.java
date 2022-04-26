package com.example.hello.listView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hello.R;

import java.util.ArrayList;

public class ListViewDemo extends AppCompatActivity {
    public static final String TAG= ListViewDemo.class.getSimpleName();
    private ListView listView;
    private ArrayList<String> data= new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private Context context;
    private Button b1,b2;
    private EditText editText;
    private  int index=-1;
    private void addListView() {
        String a= editText.getText().toString();
        if(a.isEmpty()) {

            Toast.makeText(this,"tên ko để trống",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            data.add(a);
            adapter.notifyDataSetChanged();

        }
    }
    private void updateListView() {
        String a= editText.getText().toString();
        if(a.isEmpty()) {
            Toast.makeText(this,"tên ko để trống",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            data.set(index,a);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if( !editText.getText().toString().isEmpty()||data.size()>0){
             outState.putStringArrayList("data",data);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        listView =(ListView) findViewById(R.id.listName);
        b1= findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editListView);
        b2=findViewById(R.id.btnUpdate);
        context = this;

        String[] a= context.getResources().getStringArray(R.array.List_Array);
        if(savedInstanceState==null)  for(String i:a) data.add(i);
        else data=savedInstanceState.getStringArrayList("data");

        adapter= new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item ,data);
        listView.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addListView();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 index=position;
                 editText.setText(data.get(position));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateListView();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alerb= new AlertDialog.Builder(context);
                alerb.setTitle("xác nhận");
                alerb.setMessage("Bạn có muốn xóa ko");

                alerb.setPositiveButton("đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                         data.remove(position);
                         adapter.notifyDataSetChanged();
                    }
                });
                alerb.setNegativeButton("ko đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alerb.setCancelable(true);
                    }
                });
                AlertDialog alertDialog= alerb.create();
                alertDialog.show();
                return false;
            }
        });

    }


}