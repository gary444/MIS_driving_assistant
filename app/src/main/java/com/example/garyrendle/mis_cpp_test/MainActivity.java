package com.example.garyrendle.mis_cpp_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("sign-finder-lib");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String url = "https://overpass-api.de/api/interpreter?data=[out:json];way[maxspeed](around:50.0,50.9896629,11.3221793);out%20tags;";
        new GetContentTask(this).execute(url);


        // Button to call Sign Finder Activity
        Button signFinder = (Button)findViewById(R.id.signFinder);
        signFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignFinder.class);
                startActivity(i);
            }
        });
    }

}
