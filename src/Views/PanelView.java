package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class PanelView extends JPanel implements MouseListener, ActionListener {
	private int somme=0;
	private DeView deView =new DeView();
	private BoutonView nouvelle,quitter;
	//private boolean finJeu;

	public PanelView(int x, int y){
        super();

        JLabel scoreLabel;
        JLabel nomJoueurLabel;

		setPreferredSize(new Dimension(x,y));

		//meilleur Score
		JLabel tmp= new JLabel("Meilleur Score   ");
					add(tmp);
					Font font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
					tmp.setFont(font);
					tmp.setForeground(Color.WHITE);	
		JPanel best = new JPanel();	font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 15);	

        //Extraire le best score
		nomJoueurLabel = new JLabel("Selma");
		nomJoueurLabel.setFont(font);
		nomJoueurLabel.setForeground(Color.WHITE);
		scoreLabel= new JLabel("60");
		scoreLabel.setFont(font);
		scoreLabel.setForeground(Color.YELLOW);
		best.setLayout(new FlowLayout());
		best.add(nomJoueurLabel);
		best.add(scoreLabel);
		best.setBackground(new Color(123,217,108));
		add(best);

        //Joueur
		add(new ImageUserView(1));
		tmp= new JLabel("Nom Du Joueur");		add(tmp);
		font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
		tmp.setFont(font);
		tmp.setForeground(Color.WHITE);	
		tmp= new JLabel("Demo");
        add(tmp);
		font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
		tmp.setFont(font);
		tmp.setForeground(new Color(0,0,0));
		JPanel player = new JPanel();
		nomJoueurLabel = new JLabel("Score ");
		nomJoueurLabel.setFont(font);
		nomJoueurLabel.setForeground(Color.white);
		scoreLabel= new JLabel("xxxx"); //// TODO: 09/01/2018 call controler to get score j 
        scoreLabel.setFont(font);
		scoreLabel.setForeground(new Color(0,0,0));
		player.setLayout(new FlowLayout());
		player.add(nomJoueurLabel);
		player.add(scoreLabel);
		player.setBackground(new Color(123,217,108));
		add(player);
		add(deView);
		nouvelle =new BoutonView("         Nouvelle Partie    ");
		nouvelle.addActionListener(this);
		add(nouvelle);

		quitter= new BoutonView("                Quitter");
		quitter.addActionListener(this);
		add(quitter);

	}

	//TODO with panel controleur
	public void paintComponent(Graphics g)
	{
	    try 
	    {
	        Image img = ImageIO.read(new File("assets\\Media\\fondInfo.png"));
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
////		int pos = somme+((Plateau)arg0.getSource()).getPos();
////		if (pos >99)
////			pos =100 - (pos - 100) -2;
//
//		if ((((Plateau)arg0.getSource()).isActif()) &&(
//				(arg0.getX()> Plateau.coord[ pos][0]+3)
//			 && (arg0.getX()<(Plateau.coord[ pos][0])+45)
//			 && (arg0.getY()> Plateau.coord[ pos][1]+3)
//			 && (arg0.getY()<(Plateau.coord[ pos][1])+40)))
//		{
//			((Plateau)arg0.getSource()).setPos(pos);
//			((Plateau)arg0.getSource()).repaint();
//			deView.setImages(0,0);
//			deView.setSomme(0);
//			deView.repaint();
//			somme =0;
//			((Plateau)arg0.getSource()).desactiver();
//			lancer.setEnabled(true);
//			//jeu selon case
//			((Plateau)arg0.getSource()).jouer(this);
//			setScores();
//		}
//		else if (((Plateau)arg0.getSource()).isActif())
//		{
//			try
//			{
//				throw new CaseException();
//			}catch (Exception e)
//			{
//				JOptionPane.showMessageDialog(new Frame(), "fausse case !! veuillez cliquer sur la case "+(pos+1), "Aide",JOptionPane.INFORMATION_MESSAGE);
//			}
//		}
//		else JOptionPane.showMessageDialog(new Frame(), "Vous devez D'abord lancer les des !", "Aide",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setScores()
	{
//		bestScoreString.setText(Integer.toString(this.j.getScore()));
	}

//	public BoutonView getLancerDes(){	return lancer;	}
//	public BoutonView getQuitter(){	return quitter;	}
	public void mouseEntered(MouseEvent arg0) {

    }
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {	}

	public void actionPerformed(ActionEvent arg0) 
	{
//		int j=0,k=0;
//		if (arg0.getSource()==lancer)
//		{
//			Des des1;
//			Des des2;
//			des1 = new Des();
//			des2 =new Des();
//			try
//			{
//				j=des1.Lancer();
//				k=des2.Lancer();
//			}catch (Exception e) {    }
//			deView.setImages(j, k);
//			somme = (j+k);
//			deView.setSomme(somme);
//		}
//		else if(arg0.getSource()==nouvelle)
//		{
//			LeMain.setPartie();
//		}

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
		return deView.getDe(0);
	}

	public int getde2()
	{
		return deView.getDe(1);
	}
	  
	public void setDes(int[] des)
	{
		deView.setDe(0,des[0]);
		deView.setDe(1,des[1]);
		deView.repaint();
	}


}