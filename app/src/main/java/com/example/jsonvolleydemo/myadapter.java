package com.example.jsonvolleydemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myadapter extends  RecyclerView.Adapter<myadapter.Viewholder>{

        model data[];

    public myadapter(model[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  myadapter.Viewholder holder, int position) {
        holder.t1.setText(data[position].getName());
        holder.t2.setText(data[position].getDesig());
        Glide.with(holder.t1.getContext()).load("http://192.168.0.152/Server/image/"+data[position].getImage()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView t1,t2;
        public Viewholder(@NonNull  View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
        }
    }
}
