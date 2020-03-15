package com.example.class10;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {

    public  static final  String BASEURL = "http://api.myjson.com/bins/";

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit (){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }
}
