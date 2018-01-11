package Controllers;


import Models.*;
import Views.DefinitionView;
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

                Joueur.getInstance().setPosition(pos);

                msg = plateau.jouerCase(pos);
                if (msg[0]=="definition") {
                    new DefinitionView((Definition) this.plateau.getCases()[pos]);
                    msg[0]=null;
                }

            } else {
                msg[0] = "fausse case !! veuillez cliquer sur la case " + (pos + 1);
                msg[1] = "Aide";
            }
        } else {
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
