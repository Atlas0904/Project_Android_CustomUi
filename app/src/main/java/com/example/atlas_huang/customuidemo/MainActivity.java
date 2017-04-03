package com.example.atlas_huang.customuidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeView cusTimeView = (TimeView) findViewById(R.id.timeView);
//        cusTimeView.setTitle("set title");
    }
}
