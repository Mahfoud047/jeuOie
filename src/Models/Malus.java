package Models;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Malus extends Case
{	
	final int POINTPERDU = -10;
	final int DEPLACEMENT = -2;
	
	public void jouerCase()
	{	
		Joueur.getInstance().incrementer(POINTPERDU);
		JOptionPane.showMessageDialog(new Frame(),
				"Malus! \nVous venez de perdre 10 points!\nReculez de deux cases",
				"Malus",
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