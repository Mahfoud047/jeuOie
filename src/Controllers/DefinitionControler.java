package Controllers;

import Models.Definition;
import Models.Joueur;

/**
 * Created by Mahfoud on 10/01/2018.
 */
public class DefinitionControler {
Definition definition;
    public DefinitionControler(Definition definition){
        this.definition=definition;
    }

    public String getQuestion(){
        return definition.getQuestion();
    }
    public String getReponse(){
        return definition.getReponse();
    }

    public void changerScoreJoueur(boolean gagner){
        if (gagner)
        Joueur.getInstance().incrementer(Definition.getPOINTGAGNE());
        else
        Joueur.getInstance().incrementer(Definition.getPOINTPERDU());
    }
}
