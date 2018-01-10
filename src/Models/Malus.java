package Models;

import java.io.File;

public class Malus extends Case
{
	static private String FILE_PATH = "assets\\Media\\caseMalus.png";

	final int POINTAGE = -10;
	final int DEPLACEMENT = -2;

	public String jouerCase()
	{
		Joueur.getInstance().incrementer(POINTAGE);
		Des d = Des.getInstance();
		d.setValDes(DEPLACEMENT);
		return "\nVous venez de perdre 10 points!\nReculez de deux cases";
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