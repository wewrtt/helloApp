package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Json_And_LoadImage_with_AsynTask extends AppCompatActivity {
    private Button btn_image;
    private ImageView image;
    private ArrayAdapter<ImageView> adapter;
    Context context=this;
    private  void FindById(){
        btn_image=findViewById(R.id.btn_load);
        image= findViewById(R.id.image);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_loadimage_with_asyn_task);
        FindById();
        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonObject="{'name':'long','age':'18'}";
                try {
                    JSONObject json= new JSONObject(jsonObject);
                    Toast.makeText(Json_And_LoadImage_with_AsynTask.this,json.getString("age")
                            ,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                new Load_image().execute("https://vnw-img-cdn.popsww.com/api/v2/containers/file2/cms_topic/thumbnail_title-6e402c277c9a-1592296049904-Jegh031s.png");
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