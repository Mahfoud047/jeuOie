package Controllers;

import Models.Des;

public class DesControler {
    Des des;

    public DesControler() {
        des = new Des();
    }

    public int[] lancerDes() {
        int resultatDes[] = des.Lancer();
        return resultatDes;
    }
}
