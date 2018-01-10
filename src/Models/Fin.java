package Models;

import java.io.File;

public class Fin extends Case
{
    static private String FILE_PATH = "assets\\Media\\caseFin.png";

    public String jouerCase(){
		return "Fin de la partie !\nVous avez obtenu un score de "+Joueur.getInstance().getScore()+" points !\n(nouvelle Partie) pour rejouer";
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