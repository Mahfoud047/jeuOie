package Controllers;


import Models.Case;
import Models.Des;
import Models.Joueur;
import Models.Plateau;
import Views.PlateauView;

public class PlateauControler {
    Plateau plateau;

    public PlateauControler(Plateau p) {
        plateau = p;
    }

    public Case[] getCases() {
        return plateau.getCases();
    }

    public String [] deplacerJoueur(int x, int y) {
        String [] msg = {"",""};

        if (plateau.isActif()) {
            int pos = Des.getInstance().getValeurDes1()
                    + Des.getInstance().getValeurDes2()
                    + Joueur.getInstance().getPosition();
            if (pos > 99)
                pos = 100 - (pos - 100) - 2;
            if (isCaseDestination(x, y, pos)) {
                System.out.println("ok");

                Joueur.getInstance().setPosition(pos);

                msg = plateau.jouerCase(pos);

                //// TODO: 09/01/2018
//                lancer.setEnabled(true);

//                //jeu selon case
//                ((Plateau) arg0.getSource()).jouer(this);
//                setScores();//// TODO: 09/01/2018
            } else {
                System.out.println("not case");
                msg[0] = "fausse case !! veuillez cliquer sur la case " + (pos + 1);
                msg[1] = "Aide";
            }
        } else {
            System.out.println("not des");
            msg[0] = "Vous devez D'abord lancer les des !";
            msg[1] = "Aide";
        }

        return msg;
    }

    private Boolean isCaseDestination(int x, int y, int pos) {
        return ((x > PlateauView.coord[pos][0] + 3)
                && (x < (PlateauView.coord[pos][0]) + 45)
                && (y > PlateauView.coord[pos][1] + 3)
                && (y < (PlateauView.coord[pos][1]) + 40));
    }


}
