package Models;

import java.io.File;

public class Bonus extends Case
{
	static private String FILE_PATH = "assets\\Media\\caseBonus.png";
	final int POINTAGE = 10;
	final int DEPLACEMENT = 2;
	
	public String jouerCase()
	{
		Joueur.getInstance().incrementer(POINTAGE);
        Des d = Des.getInstance();
        d.setValDes(DEPLACEMENT);
//		JOptionPane.showMessageDialog(new Frame(),
//				"Bonus! \nVous venez de ganger 10 points!\nAvancez de deux cases",
//				"Bonus",
//				JOptionPane.INFORMATION_MESSAGE);
        return "\nVous venez de ganger 10 points!\nAvancez de deux cases";
	}
	
	public Boolean isDeplacing() 
	{
		return true;
	}

	public int getDeplacement() 
	{
		return DEPLACEMENT;
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