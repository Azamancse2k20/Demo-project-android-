package com.example.class10;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("18biy2")

        Call<Actors> getActors();

}
