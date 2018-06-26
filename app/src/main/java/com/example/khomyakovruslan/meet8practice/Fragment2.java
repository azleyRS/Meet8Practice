package com.example.khomyakovruslan.meet8practice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class Fragment2 extends Fragment {
    Button mButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mButton = view.findViewById(R.id.f2_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask task = new MyAsyncTask();
                mButton.setEnabled(false);
                task.execute();
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<Void,Void,String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random rand = new Random();
            return String.valueOf(rand.nextFloat());
        }

        @Override
        protected void onPostExecute(String s) {
            mButton.setText(s);
            mButton.setEnabled(true);
        }
    }
}
