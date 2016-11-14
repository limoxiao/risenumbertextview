package com.github.czy1121.risenumbertextview.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.czy1121.view.RiseNumberTextView;


public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RiseNumberTextView rise = (RiseNumberTextView) findViewById(R.id.rise);

        rise.riseTo(5f);
        rise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rise.rise(0, 9.9f);
            }
        });


     }
}
