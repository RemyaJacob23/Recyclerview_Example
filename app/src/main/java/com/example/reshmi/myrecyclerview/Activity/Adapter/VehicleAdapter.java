package com.example.reshmi.myrecyclerview.Activity.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.reshmi.myrecyclerview.Activity.Classesssss.User;
import com.example.reshmi.myrecyclerview.R;

import java.util.List;

/**
 * Created by Reshmi on 10-12-2017.
 */


public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleHolder> {
    private List<User> users;

    private Context context;

    public VehicleAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;

    }


    @Override
    public VehicleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_single_list_view, parent, false);
        return new VehicleHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onBindViewHolder(VehicleHolder holder, int position) {
        holder.onBind(users.get(position));
    }


    class VehicleHolder extends RecyclerView.ViewHolder {
        //declare Textviews here
        public TextView name;
        public TextView age;
        public TextView number;

        public VehicleHolder(View itemView) {
            super(itemView);
            //initialise here
            name = itemView.findViewById(R.id.name);
            //do this way
            age = itemView.findViewById(R.id.age);
            number = itemView.findViewById(R.id.number);
        }

        //create a function to set values
        public void onBind(User user) {
            name.setText(user.getFirstName());
            age.setText(user.getAge());
            number.setText(user.getNumber());
        }
    }
}

