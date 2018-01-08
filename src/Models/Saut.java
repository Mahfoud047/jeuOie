package Models;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@SuppressWarnings("serial")
public class Saut extends Case
{	
	private Joueur player;
	
	public void jouerCase(Joueur j)
	{
		player = j;
	}
	
	public Boolean isDeplacing() 
	{
		return true;
	}
	
	public int getDeplacement() 
	{
		Random rand = new Random();
		int dep = rand.nextInt(100) + 1;
		JOptionPane.showMessageDialog(new Frame(), 
				"Case Saut! \nAvancer vers la case N�"+(dep+1),
				"Saut",
				JOptionPane.INFORMATION_MESSAGE);	
		return (dep - player.getPosition());
	}
}