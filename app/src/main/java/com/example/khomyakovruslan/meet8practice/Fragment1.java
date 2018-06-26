package com.example.khomyakovruslan.meet8practice;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class Fragment1 extends Fragment implements LoaderManager.LoaderCallbacks<Integer> {


    private static final int LOADER_ID = 10000;
    private Loader<Integer> mLoader;

    Button mButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.f1_button);

        mLoader = getActivity().getSupportLoaderManager().initLoader(LOADER_ID,new Bundle(),this);
        mLoader.forceLoad();
    }

    @NonNull
    @Override
    public Loader<Integer> onCreateLoader(int id, @Nullable Bundle args) {
        Loader<Integer> mLoader = null;
        if (id == LOADER_ID){
            mLoader = new MyLoader(getActivity());
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Integer> loader, Integer data) {
        mButton.setBackgroundColor(data);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Integer> loader) {

    }

    private static class MyLoader extends AsyncTaskLoader<Integer> {
        public MyLoader(Context context) {
            super(context);
        }

        @Nullable
        @Override
        public Integer loadInBackground() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getRandomString();
        }

        private Integer getRandomString() {
            Random rand = new Random();
            int color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            return color;
        }
    }
}
