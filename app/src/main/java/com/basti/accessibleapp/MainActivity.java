package com.basti.accessibleapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startButton, changeButton;
    TextView contentTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.start_bt);
        changeButton = (Button) findViewById(R.id.change_bt);
        contentTv = (TextView) findViewById(R.id.content_tv);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
            }
        });

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contentTv.setText(String.valueOf(Math.random()));
            }
        });

    }
}
