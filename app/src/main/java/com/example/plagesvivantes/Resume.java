package com.example.plagesvivantes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Resume extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        TextView resume = findViewById(R.id.resumeQuadrat);
        resume.setText(((MyApplication) this.getApplication()).getQuadrat().toString());
    }

    public void endAll(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        String msg = "Merci d'avoir partagé votre observation";
        Toast t = Toast.makeText(this , msg , Toast.LENGTH_LONG);
        t.show();
    }

    public void newObs(View view) {

        Intent intent = new Intent(this, Identification.class);
        startActivity(intent);
    }
}

