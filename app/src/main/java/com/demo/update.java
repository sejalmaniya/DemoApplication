package com.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class update extends AppCompatActivity {

    String screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        screen = getIntent().getStringExtra("selected_screen");


        if (screen.equals("login"))
        {
            Toast.makeText(this, "Login Screen", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Signup Screen", Toast.LENGTH_SHORT).show();
        }
    }
}
