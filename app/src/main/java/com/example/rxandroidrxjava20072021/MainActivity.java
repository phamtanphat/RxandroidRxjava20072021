package com.example.rxandroidrxjava20072021;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> mangTen = new ArrayList<>();
        mangTen.add("A");
        mangTen.add("B");
        mangTen.add("C");
        mangTen.add("D");

        Iterable<String> data = new Iterable<String>() {
            @NonNull
            @Override
            public Iterator<String> iterator() {
                return mangTen.iterator();
            }
        };

        data.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                Log.d("BBB",s);
            }
        });
    }
}