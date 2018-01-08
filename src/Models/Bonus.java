package Models;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Bonus extends Case 
{	
	final int POINTGAGNE = 10;
	final int DEPLACEMENT = 2;
	
	public void jouerCase()
	{
		Joueur.getInstance().incrementer(POINTGAGNE);
		JOptionPane.showMessageDialog(new Frame(),
				"Bonus! \nVous venez de ganger 10 points!\nAvancez de deux cases",
				"Bonus",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public Boolean isDeplacing() 
	{
		return true;
	}

	public int getDeplacement() 
	{
		return DEPLACEMENT;
	}
}