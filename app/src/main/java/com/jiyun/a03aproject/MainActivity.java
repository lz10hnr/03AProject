package com.jiyun.a03aproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("MainActivity", "03a");
        Toast.makeText(this, "03b", Toast.LENGTH_SHORT).show();


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();



    }
}
