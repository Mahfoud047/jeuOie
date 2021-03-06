package Models;

import java.io.File;
import java.util.Observable;

public class Joueur extends Observable {
    private String nom;
    private int score;
    private int position;
    private int pion;
    private static Joueur instance;
    private File pionImage;

    private Joueur() {
        this.nom = "Demo";
        position = 0;
        score = 0;
        setPion(1);
    }

    private synchronized static void effectuerSync() {
        if (instance == null) instance = new Joueur();
    }

    public static Joueur getInstance() {
        if (instance == null) effectuerSync();
        return instance;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        setChanged();
        notifyObservers("pionChanged");
    }

    public static void dispose() {
        instance = null;
    }

    public void setPion(int pion) {
        this.pion = pion;
        pionImage = new File("assets\\Media\\P" + pion + ".png");
    }

    public void incrementer(int i) {
        this.setScore(this.getScore() + i);
        setChanged();
        notifyObservers("scoreChange");
    }

    public File getPionImage() {
        return pionImage;
    }
}