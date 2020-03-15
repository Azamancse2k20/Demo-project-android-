package com.example.class10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Address;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ApiInterface apiInterface;
    private RecyclerView recyclerView;
    private List<Actors.ActorList> actorLists;
    private ActorsAdapter actorsAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.resultTextId);

        apiInterface = ApiCall.getRetrofit().create(ApiInterface.class);


        recyclerView =findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);

                actorLists =new ArrayList<>();


     Call<Actors> actorsCall = apiInterface.getActors();

     actorsCall.enqueue(new Callback<Actors>() {
         @Override
         public void onResponse(Call<Actors> call, Response<Actors> response) {

             List<Actors.ActorList> lists = response.body().Actors;

             for (Actors.ActorList actorList : lists){

                 String Name = actorList.getName();
                 String age = actorList.getAge();
                 String address = actorList.getAddress();
                 String birth_date = actorList.getBirthdate();
                 String photo = actorList.getPhoto();

                 actorLists.add(new Actors.ActorList(Name,age,address,birth_date,photo));

             }
             actorsAdapter =new ActorsAdapter(MainActivity.this,actorLists);
             recyclerView.setAdapter(actorsAdapter);
//             textView.setText(result);
         }

         @Override
         public void onFailure(Call<Actors> call, Throwable t) {

         }
     });

    }
}
