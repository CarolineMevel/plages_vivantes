package com.example.plagesvivantes;

import android.app.Application;

/** Cette classe permet de définir la variable globale quadrat qui nous sera utile pour recueillir
 toutes les observations et toutes les données à envoyer dans la base de données à la fin
 */
public class MyApplication extends Application {

    private Quadrat quadrat;

    public Quadrat getQuadrat(){
        return this.quadrat;
    }

    public void setQuadrat(Quadrat quadrat){
        this.quadrat = quadrat ;
    }

    /** Pour accéder à toutes ces fonctions dans les autres classes :
     ((MyApplication) this.getApplication()).setQuadrat(newQuadrat);
     Quadrat quadrat = ((MyApplication) this.getApplication()).getQuadrat();
     */

}
