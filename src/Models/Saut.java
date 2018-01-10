package Models;

import java.io.File;
import java.util.Random;

public class Saut extends Case {
    static private String FILE_PATH = "assets\\Media\\caseSaut.png";

    @Override
    public String jouerCase() {
        Random rand = new Random();
        int dep = rand.nextInt(100) + 1;

        Des d = Des.getInstance();
        d.setValDes(dep - Joueur.getInstance().getPosition());
        return "Case Saut! \nAvancer vers la case N°"+(dep+1);
    }

    @Override
    public File getFile() {
        return new File(this.FILE_PATH);
    }

    @Override
    public Boolean bloquerPlateau() {
        return false;
    }
}