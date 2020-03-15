package com.example.class10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ExampleViewHolder> {

    private Context mContext;
    private List<Actors.ActorList> actorsArrayList;


    public ActorsAdapter (Context mContext,List<Actors.ActorList> arrayList){
        this.mContext = mContext;
        actorsArrayList = arrayList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_myjson_profile,parent,false);


        return new ActorsAdapter.ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        Actors.ActorList currentPosition = actorsArrayList.get(position);


        String name = currentPosition.getName();
        String age = currentPosition.getAge();
        String address = currentPosition.getAddress();
        String birth_date = currentPosition.getBirthdate();
        String photo = currentPosition.getPhoto();


        holder.name.setText(name + " " + age);
        holder.address.setText(address);
        holder.birth.setText(birth_date);


        Picasso.get().load(photo).into(holder.mjProfileImage);

    }

    @Override
    public int getItemCount() {
        return actorsArrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mjProfileImage;
        TextView name,birth,address;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mjProfileImage = itemView.findViewById(R.id.picId);
            name = itemView.findViewById(R.id.nameId);
            birth =itemView.findViewById(R.id.birthdateId);
            address = itemView.findViewById(R.id.addressId);


        }
    }
}
