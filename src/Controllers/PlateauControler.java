package Controllers;


import Models.Case;
import Models.Plateau;

public class PlateauControler {
    Plateau plateau;

    public PlateauControler(){
            plateau = new Plateau();
    }

    public Case[] getCases(){
        return plateau.getCases();
    }
}
