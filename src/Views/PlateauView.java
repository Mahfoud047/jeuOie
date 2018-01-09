package Views;

import Controllers.PlateauControler;
import Models.Case;

import java.io.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PlateauView extends JPanel implements ActionListener
{
	PlateauControler plateauControler;

	private final int decXPion = 19-7;
	private final int decYPion = 509 - 475;

	
	
	public  final static int [][] coord =
	{
		  //10 cases /////
			  { 19 ,509},  { 55 ,530},  { 91, 510},  {126, 489},  {163, 510},  {199, 531},  {235, 511},  {271, 532},  {307, 512},  {343, 533},
		  //20 cases /////	
			  {379 ,513},  {415 ,534},  {451 ,514},  {487, 494},  {523, 474},  {559, 495},  {595, 475},  {595, 434},  {631, 414},  {667, 435},
		 //30 cases /////	
			  {703, 415},  {702, 374},  {667, 353},  {667, 311},  {703, 290},  {703, 248},  {667, 227},  {631, 206},  {631, 164},  {667, 143},
		 //40 cases /////	
			  {702, 122},  {702, 80 },  {666, 59 },  {630, 38 },  {594, 17 },  {558, 37 },  {522, 57 },  {486, 36 },  {450, 15 },  {414, 35 },
		 //50 cases 40 -> 49 /////	
			  {378, 14 },  {342, 35 },  {306, 55 },  {270, 34 },  {234, 55 },  {198, 34 },  {162, 13 },  {126, 33 },  { 90, 54 },  { 54, 74 },
		 //60 cases /////	
			  { 54, 116},  {18 , 137},  {18 , 179},  {53 , 200},  {89 , 221},  {89 , 263},  {53 , 284},  {53 , 326},  { 53, 368},  { 88, 389},
		 //70 cases /////	
			  {124, 369},  {160, 390},  {196, 411},  {232, 390},  {268, 370},  {304, 391},  {340, 371},  {376, 392},  {376, 434},  {412, 455},
		 //80 cases /////	
			  {448, 435},  {484, 415},  {484, 374},  {520, 353},  {556, 375},  {592, 355},  {591, 314},  {556, 293},  {556, 251},  {555, 210},
		 //90 cases /////	
			  {520, 189},  {520, 147},  {484, 126},  {448, 146},  {412, 167},  {376, 187},  {340, 166},  {304, 145},  {268, 165},  {232, 144},
		 //100 cases /////	
			  {196, 123},  {160, 144},  {160, 186},  {160, 228},  {196, 249},  {232, 270},  {268, 291},  {304, 271},  {340, 292},  {376, 272},
	};
	  
	private Boolean actif=false;
	 
	public PlateauView(int x, int y)
	{
		super();
		plateauControler = new PlateauControler();
		setPreferredSize(new Dimension(x,y));
	}	  
  
	public PlateauView(){  super(); }

	  
	public void paintComponent(Graphics g)
	{
		String tmp;
		int i;
	    try 
	    {//dessiner le fond
	    	Image img = ImageIO.read(new File("assets\\Media\\fondCases.png"));
	        g.drawImage(img, 0,0, this);
//			todo this is a diff
			Case[] cases = plateauControler.getCases();
	        //dessiner les cases
	        for(i=0;i<coord.length - 1;i++)
	        {
	        	img = ImageIO.read(cases[i].getFile());
	 		    g.drawImage(img, coord[i][0],coord[i][1] , this);
	        }
	        //numeroter les cases
	        img = ImageIO.read(new File("assets\\Media\\numCases.png"));
		    g.drawImage(img, 0,0 , this);


//			todo
//		    //insertion Pion
//	    	tmp = "Media\\P"+j.getPion()+".png";
//        	img = ImageIO.read(new File(tmp));
//        	g.drawImage(img, coord[getPos()][0] - decXPion ,coord[getPos()][1] - decYPion, this);
//	 		img=null;
	    } catch (IOException e) 
	    {
	    	e.printStackTrace();
	    }
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		actif = true;
		//setMsg(true);
		//repaint();
//		((Bouton)arg0.getSource()).setEnabled(false);
	}

	public void sauvegarder(){	}
	
//	public void jouer(PanneauInfo l)
//	{
//		tab[j.getPosition()].jouerCase(j);
//		if(!(tab[j.getPosition()]instanceof Definition)&&!(tab[j.getPosition()]instanceof jeuOie.Image))
//		{
//			if(tab[j.getPosition()].isDeplacing())
//			{
//				l.setSomme(tab[j.getPosition()].getDeplacement());
//				l.getLancerDes().setEnabled(false);
//				actif = true;
//			}
//		}
//	}

}