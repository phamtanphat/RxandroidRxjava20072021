package com.example.rxandroidrxjava20072021;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    int a = 0;
    private ExecutorService executors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        executors = Executors.newFixedThreadPool(1);

       Future future = executors.submit(new Callable<Object>() {
           @Override
           public Object call() throws Exception {
               Log.d("BBB",Thread.currentThread().getName());
               Thread.sleep(2000);
               a = 0;
               Integer b = null;
               a = a / b;
               return a;
           }
       });

        try {
            Log.d("BBB",future.get().toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}