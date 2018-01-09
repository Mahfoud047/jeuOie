package Models;

import java.io.File;

public class Bonus extends Case
{
	static private String FILE_PATH = "assets\\Media\\caseBonus.png";
	final int POINTGAGNE = 10;
	final int DEPLACEMENT = 2;
	
	public void jouerCase()
	{
//		Joueur.getInstance().incrementer(POINTGAGNE);
//		JOptionPane.showMessageDialog(new Frame(),
//				"Bonus! \nVous venez de ganger 10 points!\nAvancez de deux cases",
//				"Bonus",
//				JOptionPane.INFORMATION_MESSAGE);
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