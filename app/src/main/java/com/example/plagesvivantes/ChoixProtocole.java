package com.example.plagesvivantes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ChoixProtocole extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choixprotocole);
    }

    public void alamer(View view){
        Intent intent = new Intent(this, Protocole.class);
        startActivity(intent);
    }

    }
