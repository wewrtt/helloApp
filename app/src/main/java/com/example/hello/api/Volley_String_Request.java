package com.example.hello.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hello.R;
import com.example.hello.model.Person;
import com.example.hello.model.Room;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Volley_String_Request extends AppCompatActivity {
    private static final String TAG=Volley_String_Request.class.getSimpleName() ;
    private Button btn,btn2,btn3;
    private EditText edtxt;
    public  void FindByID(){
        btn=findViewById(R.id.btn);
        btn2 = findViewById(R.id.button2);
        edtxt=findViewById(R.id.edtxtName);
        btn3=findViewById(R.id.btn_post);
    }
    public void click3(Person person){
        APIService.apiService.postPerson(person).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Toast.makeText(Volley_String_Request.this,"post success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Toast.makeText(Volley_String_Request.this,"post FA",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void click2(String name){
        APIService.apiService.getPerson(name).enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                Person person= (Person) response.body();
                Person nullPerson= new Person();
                if(person!=null) Log.e(TAG,person.toString());
                else Log.e(TAG,nullPerson.toString());
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {
                Log.e(TAG,t.toString());
            }
        });
    }
    public void click(){
        APIService.apiService.getPersons().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {

                List<Person> personList= response.body();
                for (Person i : personList){
                    Log.e(TAG,i.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.e(TAG,t+"");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_string_request);
        FindByID();
        Room room= new Room("1","vip","120k");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edtxt.getText().toString();
                if(!name.isEmpty()) click2(name);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person= new Person("long","22","nữ");
                click3(person);
            }
        });

    }
}