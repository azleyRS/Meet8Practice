package com.example.khomyakovruslan.meet8practice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends android.support.v7.widget.RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<String> mData = new ArrayList<>();

    public void addData(String data) {
        mData.add(data);
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        String text = mData.get(position);
        holder.mButton.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public Button mButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.list_item_button);
        }
    }
}
