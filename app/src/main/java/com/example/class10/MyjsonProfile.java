package com.example.class10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyjsonProfile extends AppCompatActivity {

    private String name;
    private String age;
    private String bornAt;
    private String birthdate;
    private String photos;

    private String avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myjson_profile);
    }
}
