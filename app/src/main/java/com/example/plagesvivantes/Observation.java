package com.example.plagesvivantes;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Observation {
    private int numero ;
    private boolean connue;
    private Algue algue;
    private int abondance;
    private Bitmap photo;

    public Observation(int n , Algue a, int abondance, Bitmap image, boolean c){
        if (abondance > 0 && abondance < 5){
            numero = n ;
            algue = a ;
            this.abondance = abondance;
            photo = image;
            connue = c;
        }
    }

    public Algue getAlgue() {
        return algue;
    }

    public int getNumero() {
        return numero;
    }

    public int getAbondance() {
        return abondance;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public boolean isConnue() {
        return connue;
    }

    /** permet d'écrire les observations dans celle enregistrées **/
    public String toString(){
        String nomAlgue = "";
        if (this.getAlgue() == null){
            nomAlgue = "Algue non identifiée";
        }
        else {
            nomAlgue = this.getAlgue().getNomLatin();
        }
        return  "Algue n°" + this.getNumero() + " : " + nomAlgue + " - Abondance : " + this.getAbondance();
    }
}
