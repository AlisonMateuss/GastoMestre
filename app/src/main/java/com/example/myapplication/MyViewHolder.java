package com.example.myapplication;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView value, date;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        value = itemView.findViewById(R.id.value);
        date = itemView.findViewById(R.id.date);
    }
}
