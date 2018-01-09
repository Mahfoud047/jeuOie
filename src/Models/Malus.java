package Models;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@SuppressWarnings("serial")
public class Malus extends Case
{
	static private String FILE_PATH = "assets\\Media\\caseMalus.png";

	final int POINTPERDU = -10;
	final int DEPLACEMENT = -2;
	
	public void jouerCase()
	{	
//		Joueur.getInstance().incrementer(POINTPERDU);
//		JOptionPane.showMessageDialog(new Frame(),
//				"Malus! \nVous venez de perdre 10 points!\nReculez de deux cases",
//				"Malus",
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