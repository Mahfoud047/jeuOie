package Controllers;

import Models.Joueur;
import Models.Partie;

public class LeMain
{	
	private static Partie partie ;
	
	public static Partie getPartie()
	{
		return partie;
	}
	
	public static void main(String[] args)
	{
		FenetreA fen = new FenetreA();
		fen.setVisible(true);
	}
	
	public static void setPartie( Partie part) 
	{
		partie.dispose();
		partie = part;
		partie.repaint();
	}
	
	public static void setPartie (String nom, int pion)
	{
		partie = new Partie(Joueur.getInstance());
	}
	
	public static void setPartie()
	{
		Joueur gamer =partie.getJoueur();
		gamer.setPosition(0);
		gamer.setScore(0);
		partie.dispose();
		partie = new Partie(gamer);
	}
}