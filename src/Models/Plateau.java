package Models;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;


public class Plateau extends Observable implements Observer {
    private Case[] cases;
    private Boolean actif;

    public Plateau() {
        actif = false;
        cases = createCases();
    }


    private Case[] createCases() {
        Case[] cases = new Case[100];

        int nombreAleatoire;
        Random rand = new Random();
        int i;

        cases[0] = new Depart();
        cases[99] = new Fin();

        Parcours parcours = new Parcours();
        Malus malus=new Malus();
        Bonus bonus=new Bonus();
        Definition definition=new Definition();
        Image image=new Image();
        Saut saut=new Saut();

        for (i = 1; i < 99; i++) {
            cases[i] = new Parcours();
        }
        i = 0;
        while (i < 10) {
            nombreAleatoire = rand.nextInt(98 - 1 + 1) + 1;
            if ((cases[nombreAleatoire] instanceof Parcours) && (nombreAleatoire != 98)) {
                cases[nombreAleatoire] = new Bonus();
                i++;
            }
        }
        i = 0;
        while (i < 10) {
            nombreAleatoire = rand.nextInt(98 - 1 + 1) + 1;
            if ((cases[nombreAleatoire] instanceof Parcours) && (nombreAleatoire != 1)) {
                if (!(cases[nombreAleatoire - 2] instanceof Bonus)) {
                    cases[nombreAleatoire] = new Malus();
                    i++;
                }
            }
        }
        i = 0;
        while (i < 10) {
            nombreAleatoire = rand.nextInt(98 - 1 + 1) + 1;
            if (cases[nombreAleatoire] instanceof Parcours) {
                cases[nombreAleatoire] = new Saut();
                i++;
            }
        }
        i = 0;
        while (i < 10) {
            nombreAleatoire = rand.nextInt(98 - 1 + 1) + 1;
            if ((cases[nombreAleatoire] instanceof Parcours) && (nombreAleatoire != 97)) {
                if (nombreAleatoire < 95) {
                    if ((!(cases[nombreAleatoire + 2] instanceof Malus)) || (!(cases[nombreAleatoire + 4] instanceof Malus))) {
                        cases[nombreAleatoire] = new Definition();
                        i++;
                    }
                } else {
                    cases[nombreAleatoire] = new Definition();
                    i++;
                }
            }
        }
        i = 0;
        while (i < 10) {
            nombreAleatoire = rand.nextInt(98 - 1 + 1) + 1;
            if ((cases[nombreAleatoire] instanceof Parcours) && (nombreAleatoire != 98)) {
                if (nombreAleatoire < 97) {
                    if (!(cases[nombreAleatoire + 2] instanceof Malus)) {
                        cases[nombreAleatoire] = new Models.Image();
                        i++;
                    }
                } else {
                    cases[nombreAleatoire] = new Models.Image();
                    i++;
                }
            }
        }
        return cases;
    }

    public Case[] getCases() {
        return cases;
    }


    public void activer() {
        actif = true;
    }

    public void desactiver() {
        actif = false;
        Des.getInstance().activer();
    }

    public Boolean isActif() {
        return actif;
    }

    public String[] jouerCase(int position) {

        String[] msg = {"",""};

        msg[1] = cases[position].getClass().getSimpleName();
        msg[0] = cases[position].jouerCase();

        if (cases[position].bloquerPlateau())
            desactiver();

        setChanged();
        notifyObservers("caseJouer");

        return msg;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Des && arg.equals("desLances")) {
            activer();
        }
    }
}