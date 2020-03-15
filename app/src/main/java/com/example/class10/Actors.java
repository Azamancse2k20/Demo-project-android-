package com.example.class10;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Actors {

    public List<ActorList> Actors = null;


    public static class ActorList{

        public ActorList(String name, String age, String address, String birthdate, String photo) {
            this.name = name;
            this.age = age;
            this.address = address;
            Birthdate = birthdate;
            Photo = photo;
        }

        private  String name;
        private String age;

        @SerializedName("Born At")

        private String address;

        private String Birthdate;

        @SerializedName("photo")
        private String Photo;


        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

        public String getBirthdate() {
            return Birthdate;
        }

        public String getPhoto() {
            return Photo;
        }
    }
}