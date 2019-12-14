package com.example.plagesvivantes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Identification extends AppCompatActivity {
    Bitmap photo;
    boolean connue ;
    int numAlgue ;
    Algue algue;
    int abondance;
    boolean nonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        numAlgue = ((MyApplication) this.getApplication()).getQuadrat().nextNum();
        photo = null;
        nonId = false;

        TextView nom = findViewById(R.id.textNumAlgue);
        nom.setText("Algue n°" + numAlgue + " :");


        String[] algues = getResources().getStringArray(R.array.algues);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line , algues );
        AutoCompleteTextView choixAlgue = findViewById(R.id.choixAlgue);
        choixAlgue.setAdapter(adapter);

        abondance = -1;
        algue = null;

        choixAlgue.setEnabled(false);
        Button nonId = findViewById(R.id.nonId);
        nonId.setEnabled(false);
        ImageButton photoButton = findViewById(R.id.photoButton);
        photoButton.setEnabled(false);
        RadioButton choixAbondance1 = findViewById(R.id.ab1);
        choixAbondance1.setEnabled(false);
        RadioButton choixAbondance2 = findViewById(R.id.ab2);
        choixAbondance2.setEnabled(false);
        RadioButton choixAbondance3 = findViewById(R.id.ab3);
        choixAbondance3.setEnabled(false);
        RadioButton choixAbondance4 = findViewById(R.id.ab4);
        choixAbondance4.setEnabled(false);
        Button val = findViewById(R.id.buttonValidation);
        val.setEnabled(false);

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //IMAGE
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });

        /**
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //IMAGE
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        });
         **/
    }

    /**
    private static final String[] ALGUES = new String[] {
            "Algue rouge" , "Algue bleu" , "Algue vert" , "Algue orange" , "Salade César"
    };
     **/

    public void algueConnue(View view) {
        connue = true;

        Button connuButton = findViewById(R.id.button2);
        connuButton.setEnabled(false);
        Button nonConnuButton = findViewById(R.id.button3);
        nonConnuButton.setEnabled(false);

        TextView Xper = findViewById(R.id.Xper);
        Xper.setText("");
        Button nonId = findViewById(R.id.nonId);
        nonId.setEnabled(false);
        TextView textPhoto = findViewById(R.id.photo);
        textPhoto.setText("3. Prendre une photo de l'algue (facultatif)");
        AutoCompleteTextView choixAlgue = findViewById(R.id.choixAlgue);
        choixAlgue.setEnabled(true);
        ImageButton photoButton = findViewById(R.id.photoButton);
        photoButton.setEnabled(true);
        RadioButton choixAbondance1 = findViewById(R.id.ab1);
        choixAbondance1.setEnabled(true);
        RadioButton choixAbondance2 = findViewById(R.id.ab2);
        choixAbondance2.setEnabled(true);
        RadioButton choixAbondance3 = findViewById(R.id.ab3);
        choixAbondance3.setEnabled(true);
        RadioButton choixAbondance4 = findViewById(R.id.ab4);
        choixAbondance4.setEnabled(true);
        Button val = findViewById(R.id.buttonValidation);
        val.setEnabled(true);

    }

    public void algueNonConnue(View view) {
        connue = false;

        Button connuButton = findViewById(R.id.button2);
        connuButton.setEnabled(false);
        Button nonConnuButton = findViewById(R.id.button3);
        nonConnuButton.setEnabled(false);

        TextView Xper = findViewById(R.id.Xper);
        Xper.setText("J'essaie d'identifier avec Xper");
        TextView textPhoto = findViewById(R.id.photo);
        textPhoto.setText("3. Prendre une photo de l'algue");
        AutoCompleteTextView choixAlgue = findViewById(R.id.choixAlgue);
        choixAlgue.setEnabled(true);
        Button nonId = findViewById(R.id.nonId);
        nonId.setEnabled(true);
        ImageButton photoButton = findViewById(R.id.photoButton);
        photoButton.setEnabled(true);
        RadioButton choixAbondance1 = findViewById(R.id.ab1);
        choixAbondance1.setEnabled(true);
        RadioButton choixAbondance2 = findViewById(R.id.ab2);
        choixAbondance2.setEnabled(true);
        RadioButton choixAbondance3 = findViewById(R.id.ab3);
        choixAbondance3.setEnabled(true);
        RadioButton choixAbondance4 = findViewById(R.id.ab4);
        choixAbondance4.setEnabled(true);
        Button val = findViewById(R.id.buttonValidation);
        val.setEnabled(true);
    }

    public void nonIdentifiee(View view){
        nonId = true;
        algue = null;
        /** pas optimal peut etre modifié **/
        AutoCompleteTextView choixAlgue = findViewById(R.id.choixAlgue);
        choixAlgue.clearListSelection();
        choixAlgue.setText("Algue non identifiée");
        choixAlgue.setEnabled(false);
        Button nonId = findViewById(R.id.nonId);
        nonId.setEnabled(false);
    }

    public void abond1(View view){
        abondance = 1;
    }

    public void abond2(View view){
        abondance = 2;
    }

    public void abond3(View view){
        abondance = 3;
    }

    public void abond4(View view){
        abondance = 4;
    }

    public String getTextAlgue(){
        AutoCompleteTextView choixAlgue = findViewById(R.id.choixAlgue);
        return choixAlgue.getText().toString();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        photo = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(bitmap);
        if ( photo != null ){
            TextView isPhoto = findViewById(R.id.isPhoto);
            isPhoto.setText("Photo enregistrée");
        }
    }


    public void validation(View view){
        if (abondance == -1){
            String msg = "Remplissez un indice d'abondance";
            Toast t = Toast.makeText(this , msg , Toast.LENGTH_LONG);
            t.show();
        }
        else if (!connue){
            if (photo == null){
                String msg = "Si vous ne connaissez pas l'algue vous devez ajouter une photo";
                Toast t = Toast.makeText(this , msg , Toast.LENGTH_LONG);
                t.show();
            }
            else {
                if (nonId){
                    Observation obs = new Observation( numAlgue, null, abondance , photo , false);
                    Quadrat quadrat = ((MyApplication) this.getApplication()).getQuadrat();
                    quadrat.addObs(obs);
                    ((MyApplication) this.getApplication()).setQuadrat(quadrat);
                    Intent intent = new Intent(this, Resume.class);
                    startActivity(intent);
                }
                else {
                    String textAlgue = this.getTextAlgue();
                    if (textAlgue.length() == 0){
                        String msg = "Choisissez une algue";
                        Toast t = Toast.makeText(this , msg , Toast.LENGTH_LONG);
                        t.show();
                    }
                    else {
                        Algue algue = new Algue(textAlgue);
                        Observation obs = new Observation( numAlgue , algue , abondance , photo , false);
                        Quadrat quadrat = ((MyApplication) this.getApplication()).getQuadrat();
                        quadrat.addObs(obs);
                        ((MyApplication) this.getApplication()).setQuadrat(quadrat);
                        Intent intent = new Intent(this, Resume.class);
                        startActivity(intent);
                    }
                }
            }
        }
        else {
            String textAlgue = this.getTextAlgue();
            if (textAlgue.length() == 0){
                String msg = "Choisissez une algue";
                Toast t = Toast.makeText(this , msg , Toast.LENGTH_LONG);
                t.show();
            }
            else {
                Algue algue = new Algue(textAlgue);
                Observation obs = new Observation( numAlgue , algue , abondance , photo , true);
                Quadrat quadrat = ((MyApplication) this.getApplication()).getQuadrat();
                quadrat.addObs(obs);
                ((MyApplication) this.getApplication()).setQuadrat(quadrat);
                Intent intent = new Intent(this, Resume.class);
                startActivity(intent);
            }
        }
    }
}