package com.example.plagesvivantes;

import android.location.Location;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Quadrat {
    private List<Observation> listObs ;
    private Location GPS ;
    private ImageView photo ;
    private Date date ;

    /** Doit être utilisé au moment de la prise de photo pour créer le quadrat qu'on envoit à la fin à la base de données **/
    public Quadrat (Location l , ImageView i , Date d){
        listObs = new ArrayList<>();
        GPS = l ;
        photo = i ;
        date = d ;
    }

    public Quadrat(){
        this(null,null,null);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setGPS(Location GPS) {
        this.GPS = GPS;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public Location getGPS() {
        return GPS;
    }

    public List<Observation> getListObs() {
        return listObs;
    }

    public Date getDate() {
        return date;
    }

    /** doit être utilisé à chaque fois qu'on valide une observation pour l'ajouter au quadrat**/
    public void addObs(Observation obs){
        listObs.add(obs) ;
    }

    public int nextNum(){
        return this.getListObs().size() + 1 ;
    }


    /** peut être utilisé pour écrire toutes les observations les unes  la suite des autres **/
    public String toString(){
        if (listObs.size() == 0) {
            return "Pas d'observations pour le moment";
        }
        String res = "";
        for (Observation o : this.getListObs()){
            res += "  " + o.toString() + "\n\n";
        }
        return res;
    }
}
