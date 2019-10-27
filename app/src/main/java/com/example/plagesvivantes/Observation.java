package com.example.plagesvivantes;

import android.widget.ImageView;

public class Observation {
    private int numero ;
    private boolean connue;
    private Algue algue;
    private int abondance;
    private ImageView photo;

    public Observation(int n , Algue a, int abondance, ImageView image, boolean c){
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

    public ImageView getPhoto() {
        return photo;
    }

    public boolean isConnue() {
        return connue;
    }

    /** permet d'écrire les observations dans celle enregistrées **/
    public String toString(){
        return  "Algue n°" + this.getNumero() + " : " + this.getAlgue().getNomLatin() + "Abondance : " + this.getAbondance();
    }
}
