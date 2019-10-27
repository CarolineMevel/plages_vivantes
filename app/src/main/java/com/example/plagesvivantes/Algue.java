package com.example.plagesvivantes;

public class Algue {
    private String ref;
    private String nomLatin;
    private String nomCommun;

    public Algue(String ref, String nomLatin , String nomCommun){
        this.ref = ref;
        this.nomLatin = nomLatin;
        this.nomCommun = nomCommun;
    }

    public String getRef() {
        return ref;
    }

    public String getNomCommun() {
        return nomCommun;
    }

    public String getNomLatin() {
        return nomLatin;
    }

    /** permet d'écrire l'algue dans les menus déroulant comme dans identification par exemple **/
    public String toString(){
        return this.getRef() + " - " + this.getNomLatin() + " - " + this.getNomCommun();
    }

}
