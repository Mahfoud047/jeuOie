package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;


public class PartieView extends JFrame implements ActionListener
{	
	final static int TAILLEDEFINITION = 23;
	static int TAILLEIMAGE = 100;
//	private Joueur joueur;
	private PlateauView plat;
//	PanneauInfo panInfo;
	private static ArrayList<String> [] tableauDefinition =new ArrayList[TAILLEDEFINITION];
    private static String [] tableauImage= new String[TAILLEIMAGE];   
	private static TreeSet <Integer> Scores =new TreeSet();
    private static int bestScore;
    private static String bestPlayer;

	public PartieView()
	{
		this.setTitle("");										//Titre de la fentre
	    this.setSize(988, 639);									//Taille de la fenetre
	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//Pour que Fermer ferme reellement
	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionn�e	
	    double width = ( 0.811*(getWidth()))+16;		//taille du plateau de jeu
//	    this.joueur = joueur;							//joueur
	    JPanel content = new JPanel(); 							//Panel Principal    
	    this.plat = new PlateauView(								//Panel des cases
				(int)width,
				610
//				,
//				this.joueur
		);
//		panInfo  = new PanneauInfo(					//Panel Info Joueur et PartieView
//				(getWidth())- (int)width,
//				610
////				,
////				this.joueur
//		);
//	    plat.addMouseListener(panInfo);
//	    (panInfo.getLancerDes()).addActionListener(plat);
//	    (panInfo.getQuitter()).addActionListener(this);
	    JPanel menu = new JPanel();						//menu
	    menu.setPreferredSize(
	    		new Dimension(getWidth()-16 , 20)
	    		);
	    menu.setBackground(Color.BLACK);
	    content.setLayout(new BorderLayout());
	    content.add(menu,BorderLayout.NORTH);
//	    content.add(panInfo,BorderLayout.WEST);
	    content.add(plat,BorderLayout.CENTER);
	    this.setContentPane(content);	    
	    this.setVisible(true);			//Fenetre Visible
	}

	

//	public void setJoueur(Joueur j)
//	{
//		this.joueur = new Joueur(j.getNom(),j.getPion());
//		this.joueur.setPosition(j.getPosition());
//		this.joueur.setScore(j.getScore());
//	}
	
	public PlateauView getPlat()
	{
		return plat;
	}
	
	public void setPlat(PlateauView plat)
	{
		this.plat = plat;
	}
	
//	public PanneauInfo getInfo(){ return panInfo; }
	
	public static String getDefinition(int k,int i) 
	{
		return tableauDefinition[k].get(i);
	}
	
	public static String getImage(int k) 
	{
		return tableauImage[k];
	}
	
	public static void setBestPlayer(String p) 
	{
		bestPlayer = p;
	}
	
	public static TreeSet<Integer> getScores()
	{
		return Scores;
	}
	
	public static void setBestScore(String p) 
	{
		bestScore = Integer.parseInt(p);
	}
	
	public static String getBestPlayer() 
	{
		return bestPlayer;
	}
	
	
	public static String getBestScore() 
	{
		return Integer.toString(bestScore);
	}

	public void actionPerformed(ActionEvent arg0) 
	{	
		int option = JOptionPane.showConfirmDialog(null, 
				"Voulez-vous enregistrer votre partie avant de quitter ?", 
				"Quitter",
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE
				);
		if(option == JOptionPane.OK_OPTION)
		{
//			sauvegarder();
//			this.dispose();
//			FenetreA ac = new FenetreA();
//			ac.setVisible(true);
		}
		else if(option == JOptionPane.CANCEL_OPTION){		}
		else 
		{
//			this.dispose();
//			FenetreA ac = new FenetreA();
//			ac.setVisible(true);
		}
	}
}