package com.btech.IucHostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       //getSupportActionBar().hide();
    }


    public void nextStep(View view) {
        Intent intent = new Intent(login.this, MainActivity2.class);
        startActivity(intent);
    }
}
