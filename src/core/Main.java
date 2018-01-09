package core;

import Models.Des;
import Models.Joueur;
import Models.Plateau;
import Views.PartieView;

public class Main {

    static private PartieView p;

    public static void main(String[] args) {
        setPartie();
        Joueur.getInstance().setPosition(0);
    }
//// TODO: 09/01/2018 dispose player and des
    public static void setPartie() {
        Plateau plateau = new Plateau();
        Des des = Des.getInstance();
        des.addObserver(plateau);
        if (p != null)
            p.dispose();
        p = new PartieView(plateau, des);
    }
}
