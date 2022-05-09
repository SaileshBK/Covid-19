package com.example.finalproject;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Mydataviewholder extends RecyclerView.ViewHolder {
    TextView name,desc,type;
    public Mydataviewholder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.desc);
        type = itemView.findViewById(R.id.type);
    }
}
