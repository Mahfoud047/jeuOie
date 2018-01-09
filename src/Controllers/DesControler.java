package Controllers;

import Models.Des;

public class DesControler {
    Des des;

    public DesControler(Des d) {
        des = d;
    }

    public int[] lancerDes() {
        int resultatDes[] = { 0 , 0 };
        if (des.isActif()){
            resultatDes = des.Lancer();
        }
        return resultatDes;
    }
}
