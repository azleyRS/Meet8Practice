package com.example.khomyakovruslan.meet8practice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends Fragment {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mManager);

        // here you can add List you need

        mAdapter = new MyAdapter();
        mAdapter.addData("test");
        mRecyclerView.setAdapter(mAdapter);
    }


}
