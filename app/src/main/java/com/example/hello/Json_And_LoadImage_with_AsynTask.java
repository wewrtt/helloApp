package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hello.api.Volley_String_Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Json_And_LoadImage_with_AsynTask extends AppCompatActivity {
    private Button btn_image,btn_volley;
    private ImageView image;
    private  static  final  String TAG= Json_And_LoadImage_with_AsynTask.class.getSimpleName();
    private ArrayAdapter<ImageView> adapter;
    Context context=this;
    private  void FindById(){
        btn_image=findViewById(R.id.btn_load);
        btn_volley = findViewById(R.id.btn_volley);
        image= findViewById(R.id.image);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_loadimage_with_asyn_task);
        FindById();
        btn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(context, Volley_String_Request.class);
                startActivity(i);
            }
        });
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonObject="{'person':" +
                        "[{'name':'long','age':'22'}" +
                        ",{'name':'nga','age':'24'}" +
                        ",{'name':'chiến','age':'24'}]}";
                try {
                    JSONObject json= new JSONObject(jsonObject);
                    JSONArray arr=json.getJSONArray("person");
                    for(int i=0;i<arr.length();i++){
                        Log.e(TAG,arr.getJSONObject(i).toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
               // new Load_image().execute("https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/thumbnail_title-6e402c277c9a-1592296049904-Jegh031s.png");
            }
        });


    }
    private  class Load_image extends AsyncTask<String,Void, Bitmap>{
        private  Bitmap bitmap_image;
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream inputStream= url.openConnection().getInputStream();
                bitmap_image = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap_image;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            image.setImageBitmap(bitmap);
        }
    }
}