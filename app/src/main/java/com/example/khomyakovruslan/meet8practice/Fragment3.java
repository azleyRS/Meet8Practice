package com.example.khomyakovruslan.meet8practice;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment3 extends Fragment implements LoaderManager.LoaderCallbacks<String>  {
    private static final int LOADER_ID = 10001;
    private static final int SHOW_TEXT = 1001;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mManager;
    //h+l
    Handler mHandler;

    private Loader<String> mLoader;

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
        //mAdapter.addData("test");
        mRecyclerView.setAdapter(mAdapter);


        //h+l
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case SHOW_TEXT:
                        mAdapter.addData((String)msg.obj);
                        break;
                }
            }
        };


        mLoader = getActivity().getSupportLoaderManager().initLoader(LOADER_ID,new Bundle(),this);
        mLoader.forceLoad();
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        Loader<String> mLoader = null;
        if (id==LOADER_ID){
            mLoader = new MyLoader(getActivity());
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        //here you can addData
        //mAdapter.addData(data);
        showText(data);
        mAdapter.notifyItemInserted(MyLoader.count);
        mLoader.forceLoad();
    }

    //h+l
    private void showText(String data) {
        Message msg = new Message();
        msg.what = SHOW_TEXT;
        msg.obj = data;
        mHandler.sendMessage(msg);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public static class MyLoader extends AsyncTaskLoader<String>{
        static int count=0;

        public MyLoader(@NonNull Context context) {
            super(context);
        }

        @Nullable
        @Override
        public String loadInBackground() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d("TAG", "" + count);
            return "" + count++;
        }
    }

}
