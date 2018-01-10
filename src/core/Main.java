package core;

import Models.Des;
import Models.Joueur;
import Models.Plateau;
import Views.PartieView;

public class Main {

    static private PartieView p;

    public static void main(String[] args) {
        nouvellePartie();
    }

    public static void nouvellePartie() {
        if (p != null) {
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
}
