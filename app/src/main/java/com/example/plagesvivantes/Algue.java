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

    public Algue(String chaine){
        String[] parts = chaine.split("-");
        String code = parts[0].trim();
        String latin = "";
        String commun = "";

        if (parts[1].contains("-")){
            String[] parts2 = parts[1].split("-");
            latin = parts2[0].trim();
            commun = parts2[1].trim();
        }
        else {
            latin = parts[1].trim();
            commun = null;
        }
        this.ref = code;
        this.nomLatin = latin;
        this.nomCommun = commun;
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
        if (this == null){
            return "Algue non identifiée";
        }
        if (this.getNomCommun() != null){
            return  this.getRef() + " - " + this.getNomLatin() + " - " + this.getNomCommun();
        }
        else {
            return this.getRef() + " - " + this.getNomLatin();
        }
    }

}