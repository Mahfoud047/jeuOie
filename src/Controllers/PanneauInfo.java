package Controllers;

import Models.Des;
import Models.Joueur;
import Models.Partie;
import Models.Plateau;
import Views.ImageUser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class PanneauInfo extends JPanel implements MouseListener, ActionListener { 
	//private int bestScore;
	private Joueur j;
	private int somme=0;
	private JLabel bestScoreString;
	private JLabel NomMeilleurScore;
	private PanelDes panelDes =new PanelDes(0,0);
	private Bouton lancer,nouvelle,susp,sauv,quitter, scor ;
	//private boolean finJeu;
	
	public PanneauInfo(int x, int y, Joueur j){
		super();
		this.j =j;
		setPreferredSize(new Dimension(x,y));		
		//meilleur Score
		JLabel tmp= new JLabel("Meilleur Score   ");
					add(tmp);
					Font font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
					tmp.setFont(font);
					tmp.setForeground(Color.WHITE);	
		JPanel best = new JPanel();	font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 15);	
		//Extraire le best score 
		String bestPlayer= Partie.getBestPlayer();
		String bestScore=Partie.getBestScore();	
		NomMeilleurScore = new JLabel(bestPlayer);		
		NomMeilleurScore.setFont(font);
		NomMeilleurScore.setForeground(Color.WHITE);
		bestScoreString= new JLabel(bestScore);
		bestScoreString.setFont(font);
		bestScoreString.setForeground(Color.YELLOW);
		best.setLayout(new FlowLayout());
		best.add(NomMeilleurScore);	
		best.add(bestScoreString);
		best.setBackground(new Color(123,217,108));
		add(best);
		//Joueur
		add(new ImageUser(j.getPion()));
		tmp= new JLabel("Nom Du Joueur");		add(tmp);
		font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
		tmp.setFont(font);
		tmp.setForeground(Color.WHITE);	
		tmp= new JLabel(this.j.getNom());		add(tmp);
		font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
		tmp.setFont(font);
		tmp.setForeground(new Color(0,0,0));
		JPanel player = new JPanel();
		NomMeilleurScore = new JLabel("Score ");		
		NomMeilleurScore.setFont(font);
		NomMeilleurScore.setForeground(Color.white);
		bestScoreString= new JLabel(Integer.toString(this.j.getScore()));		
		bestScoreString.setFont(font);
		bestScoreString.setForeground(new Color(0,0,0));
		player.setLayout(new FlowLayout());
		player.add(NomMeilleurScore);	
		player.add(bestScoreString);
		player.setBackground(new Color(123,217,108));
		add(player);
		add(panelDes);
		lancer = new Bouton("           Lancer les des    ");
		lancer.addActionListener(this);
		add(lancer);
		nouvelle =new Bouton("         Nouvelle Partie    ");
		nouvelle.addActionListener(this);
		add(nouvelle);
		susp=new Bouton("     Charger une Partie  ");
		susp.addActionListener(this);
		add(susp);
		sauv=new Bouton("  Sauvegarder la Partie");
		sauv.addActionListener(this);
		add(sauv);
		scor = new Bouton("                Scores");
		scor.addActionListener(this);
		add(scor);
		quitter= new Bouton("                Accueil");
		quitter.addActionListener(this);
		add(quitter);
	}
	
	public void paintComponent(Graphics g)
	{
	    try 
	    {
	        Image img = ImageIO.read(new File("Media\\fondInfo.png"));
	        g.drawImage(img, 0, 00, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) 
	    {
	    	Color c = g.getColor();
	    	g.setColor(new Color(123,217,108));
	        g.fillRect(0, 0, this.getWidth(), this.getHeight());
	        g.setColor(c);
	    }
	}
	
	public void mouseClicked(MouseEvent arg0) 
	{
		int pos = somme+((Plateau)arg0.getSource()).getPos();
		if (pos >99) 
			pos =100 - (pos - 100) -2;
		if ((((Plateau)arg0.getSource()).isActif())&&(
				(arg0.getX()> Plateau.coord[ pos][0]+3)				
			 && (arg0.getX()<(Plateau.coord[ pos][0])+45)
			 && (arg0.getY()> Plateau.coord[ pos][1]+3)				
			 && (arg0.getY()<(Plateau.coord[ pos][1])+40)))
		{
			((Plateau)arg0.getSource()).setPos(pos);
			((Plateau)arg0.getSource()).repaint();
			panelDes.setImages(0,0);
			panelDes.setSomme(0);
			panelDes.repaint();	
			somme =0;			
			((Plateau)arg0.getSource()).desactiver();	
			lancer.setEnabled(true);	
			//jeu selon case
			((Plateau)arg0.getSource()).jouer(this);
			setScores();
		}
		else if (((Plateau)arg0.getSource()).isActif())
		{
			try
			{
				throw new CaseException();
			}catch (Exception e)
			{
				JOptionPane.showMessageDialog(new Frame(), "fausse case !! veuillez cliquer sur la case "+(pos+1), "Aide",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else JOptionPane.showMessageDialog(new Frame(), "Vous devez D'abord lancer les des !", "Aide",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setScores()
	{
		bestScoreString.setText(Integer.toString(this.j.getScore()));
	}

	public Bouton getLancerDes(){	return lancer;	}
	public Bouton getQuitter(){	return quitter;	}
	public void mouseEntered(MouseEvent arg0) {		}
	public void mouseExited(MouseEvent arg0) { 	}
	public void mousePressed(MouseEvent arg0) {		}
	public void mouseReleased(MouseEvent arg0) {	}

	public void actionPerformed(ActionEvent arg0) 
	{
		int j=0,k=0;	
		if (arg0.getSource()==lancer)
		{	
			Des des1;
			Des des2;
			des1 = new Des();
			des2 =new Des();
			try
			{
				j=des1.Lancer();
				k=des2.Lancer();
			}catch (Exception e) {    }
			panelDes.setImages(j, k);
			somme = (j+k);
			panelDes.setSomme(somme);
		}
		else if(arg0.getSource()==nouvelle)
		{
			LeMain.setPartie();
		}
		else if(arg0.getSource()==susp)
		{
			LeMain.getPartie().restaurer();
		}
		else if(arg0.getSource()==sauv)
		{
			LeMain.getPartie().sauvegarder();
			JOptionPane.showMessageDialog(new Frame(),
					"La partie a �t� sauvegard�e avec succ�s !",
					"Sauvegarde",
					JOptionPane.INFORMATION_MESSAGE);	
		}
		else if(arg0.getSource()== scor)
		{
			@SuppressWarnings("unused")
			FenMeilleurScore fen;
			if(Partie.getScores().isEmpty())
			{
				JOptionPane.showMessageDialog(new Frame(),
					" Ce joueur n'a jamais termin� une partie jusqu'aux bout !\nChoisissez un autre joueur ayant arriv� � la case Fin avant de r�esayer.",
					"Pas de score pour ce joueur",
					JOptionPane.ERROR_MESSAGE);
			}
	    	else
	    		fen = new FenMeilleurScore(this.j);
		}
	}
	
	public int getSomme()
	{
		return somme;
	}
	
	public void setSomme( int somme)
	{
		this.somme = somme;
	}
	  
	public int getde1()
	{
		return panelDes.getDe1();
	}

	public int getde2()
	{
		return panelDes.getDe2();
	}
	  
	public void setDes(int[] des)
	{
		panelDes.setDe1(des[0]);
		panelDes.setDe2(des[1]);
		panelDes.repaint();
	}	
}