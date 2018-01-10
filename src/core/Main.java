package core;

import Controllers.PlateauControler;
import Models.Des;
import Models.Joueur;
import Models.Plateau;
import Views.PartieView;
import Views.PlateauView;

public class Main {

    static private PartieView p;

    public static void main(String[] args) {
        nouvellePartie();
    }

    public static void nouvellePartie() {
        if (p != null){
            p.dispose();
            Des.dispose();
            Joueur.dispose();
        }
        Plateau plateau = new Plateau();
        Des des = Des.getInstance();
        des.addObserver(plateau);
        p = new PartieView(plateau, des);
        Joueur.getInstance().setPosition(0);
    }



//    public static void factoryMethode(){
//        Plateau plateau = new Plateau();
//        PlateauView plateauView = new PlateauView();
//        PlateauControler plateauControler =
//        Des des = Des.getInstance();
//
//        des.addObserver(plateau);
//        if (p != null)
//            p.dispose();
//        p = new PartieView(plateau, des);
//    }

}
