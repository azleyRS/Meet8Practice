package com.example.khomyakovruslan.meet8practice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity /*implements LoaderManager.LoaderCallbacks<String>*/{

    //private static final int LOADER_ID = 10000;
    //Button button;
    //private Loader<String> mLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1();
        fragmentManager.beginTransaction().add(R.id.frame_container_1,fragment1).commit();
        Fragment2 fragment2 = new Fragment2();
        fragmentManager.beginTransaction().add(R.id.frame_container_2,fragment2).commit();
        Fragment3 fragment3 = new Fragment3();
        fragmentManager.beginTransaction().add(R.id.frame_container_3,fragment3).commit();

/*        button = findViewById(R.id.activity_button);
        Bundle bundle = new Bundle();
        bundle.putString("String-key","some string");
        mLoader = getSupportLoaderManager().initLoader(LOADER_ID,bundle,this);
        mLoader.forceLoad();*/
    }

   /* @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        Loader<String> mLoader = null;
        if (id == LOADER_ID){
            mLoader = new MyLoader(this, args);
        }
        return mLoader;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        //setHere
        button.setText(data);
        mLoader.forceLoad();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public static class MyLoader extends AsyncTaskLoader<String>{
        private String mString;

        public MyLoader(@NonNull Context context,Bundle bundle) {
            super(context);
            mString = bundle.getString("String-key");
        }

        @Nullable
        @Override
        public String loadInBackground() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getRandomString();
        }

        private String getRandomString() {
            Random random = new Random();
            return String.valueOf(random.nextFloat());
        }
    }
*/
}
