package Models;

import core.DefinitionData;
import core.DefinitionDataFichier;

import java.io.File;

public class Definition extends Question {
    static private String FILE_PATH = "assets\\Media\\caseDef.png";

    private  static final int POINTGAGNE = 20;
    private  static final int POINTPERDU = -10;
    private static String question="La question?";
    private static String reponse="reponse";
    DefinitionData definitionData;

    public Definition(){
        definitionData = new DefinitionDataFichier();
    }

    public String getReponse() {
        return reponse;
    }

    public String getQuestion() {
        String def[] = definitionData.getDifinition();
        question = def[0];
        reponse = def[1];

        return question;
    }


    public String jouerCase() {
        return "definition";

    }

    public int getPOINTGAGNE() {
        return POINTGAGNE;
    }

    public int getPOINTPERDU() {
        return POINTPERDU;
    }

    @Override
    public File getFile() {
        return new File(this.FILE_PATH);
    }

    @Override
    public Boolean bloquerPlateau() {
        return true;
    }
}