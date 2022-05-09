package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<Mydataviewholder> {

    private List<MyDataSet> list;
    private Context context;

    public MyAdapter(List<MyDataSet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Mydataviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.eachrow,parent,false);


        return new Mydataviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Mydataviewholder holder, int position) {
        MyDataSet mycurrentdata = list.get(position);
        holder.name.setText(mycurrentdata.getCountry());
        holder.type.setText(mycurrentdata.getSlug());
        holder.desc.setText(mycurrentdata.getISO2());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
