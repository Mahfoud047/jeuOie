package Controllers;

import Models.Definition;
import Models.Joueur;

public class DefinitionControler {
Definition definition;
    public DefinitionControler(Definition definition){
        this.definition=definition;
    }

    public String getQuestion(){
        return definition.getQuestion();
    }
    public int getLengthReponse(){
        return definition.getReponse().length();
    }

    public boolean reponseIsCorrect(String reponseJoueur){
        return reponseJoueur.equalsIgnoreCase(definition.getReponse());
    }
    public void changerScoreJoueur(boolean gagner){
        if (gagner)
        Joueur.getInstance().incrementer(definition.getPOINTGAGNE());
        else
        Joueur.getInstance().incrementer(definition.getPOINTPERDU());
    }
}
