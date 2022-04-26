package com.example.hello.api;

import com.example.hello.model.Person;
import com.example.hello.model.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
    APIService apiService= new Retrofit.Builder()
            .baseUrl("http://192.168.1.100:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(APIService.class);
    @GET("api/persons")
    Call<List<Person>> getPersons();
    @GET("api/persons/{name}")
    Call<Person> getPerson(@Path("name") String name);
    @POST("person/store")
    Call<Person> postPerson(@Body Person user);
}
//     APIService apiService = new Retrofit.Builder()
//            .baseUrl("http://192.168.1.100:3000/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build().create(APIService.class);
//    @GET("api/roomAPI")
//    Call<List<Room>> callAPI();