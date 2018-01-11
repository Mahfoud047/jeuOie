package Models;

import java.io.File;

public class Definition extends Question {
    static private String FILE_PATH = "assets\\Media\\caseDef.png";

    private  static final int POINTGAGNE = 20;
    private  static final int POINTPERDU = -10;
    private static String question="La question?";
    private static String reponse="reponse";


    public static String getReponse() {
        return reponse;
    }

    public static String getQuestion() {
        return question;
    }


    public String jouerCase() {
        return "definition";

    }

    public int getDeplacement() {
        return DEPLACEMENT;
    }

    public static int getPOINTGAGNE() {
        return POINTGAGNE;
    }

    public static int getPOINTPERDU() {
        return POINTPERDU;
    }

    public void setDeplacement(int k) {
        DEPLACEMENT = k;
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