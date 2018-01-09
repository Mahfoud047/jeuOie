package Models;

//import Controllers.PanneauInfo;

import java.util.Observable;
import java.util.Random;


public class Plateau extends Observable
{
	private Case[] cases;
	private Boolean actif=false;	 
	 
	public Plateau()
	{
		cases = createCases();
	}


	private Case[] createCases(){
		Case [] cases = new Case[100];

		int nombreAleatoire;
		Random rand = new Random();
		int i;

		cases[0] = new Depart();cases[99] = new Fin();
		cases[0].setPosition(0);cases[99].setPosition(99);
		for( i = 1 ; i < 99 ; i++)
		{
			cases[i]= new Parcours();
			cases[i].setPosition(i);
		}
		i=0;
		while (i<10)
		{
			nombreAleatoire = rand.nextInt(98 - 1 + 1 ) + 1;
			if ((cases[nombreAleatoire]instanceof Parcours)&&(nombreAleatoire!=98))
			{
				cases[nombreAleatoire]= new Bonus();
				i++;
			}
		}
		i=0;
		while (i<10)
		{
			nombreAleatoire = rand.nextInt(98 - 1 + 1 ) + 1;
			if((cases[nombreAleatoire]instanceof Parcours)&& (nombreAleatoire!=1))
			{
				if(!(cases[nombreAleatoire-2]instanceof Bonus))
				{
					cases[nombreAleatoire]= new Malus();
					i++;
				}
			}
		}
		i=0;
		while (i<10)
		{
			nombreAleatoire = rand.nextInt(98 - 1 + 1 ) + 1;
			if (cases[nombreAleatoire]instanceof Parcours )
			{
				cases[nombreAleatoire]= new Saut();
				i++;
			}
		}
		i=0;
		while (i<10)
		{
			nombreAleatoire = rand.nextInt(98 - 1 + 1 ) + 1;
			if((cases[nombreAleatoire]instanceof Parcours )&& (nombreAleatoire!=97))
			{
				if(nombreAleatoire<95)
				{
					if((!(cases[nombreAleatoire+2]instanceof Malus ))||(!(cases[nombreAleatoire+4]instanceof Malus )))
					{
						cases[nombreAleatoire]= new Definition();
						i++;
					}
				}
				else
				{
					cases[nombreAleatoire]= new Definition();
					i++;
				}
			}
		}
		i=0;
		while (i<10)
		{
			nombreAleatoire = rand.nextInt(98 - 1 + 1 ) + 1;
			if((cases[nombreAleatoire]instanceof Parcours )&& (nombreAleatoire!=98))
			{
				if(nombreAleatoire<97)
				{
					if(!(cases[nombreAleatoire+2]instanceof Malus ))
					{
						cases[nombreAleatoire]= new Models.Image();
						i++;
					}
				}
				else
				{
					cases[nombreAleatoire]= new Models.Image();
					i++;
				}
			}
		}
		return cases;
	}

	public Case[] getCases() {
		return cases;
	}





										//	no	need for it.
//	public int getPos()
//	{
//		Joueur j=Joueur.getInstance();
//		if(j !=null)
//		{
//			return j.getPosition();
//		}
//		else return -1;
//	}


									//TODO This will be put on the case action
//	public void setPos( int pos)
//	{
//		Joueur j=Joueur.getInstance();
//		if(j !=null)
//		{
//			j.setPosition(pos);
//		}
//	}


	public void activer()
	{
		actif = true;
	}
	
	public void desactiver()
	{
		actif = false;
	}
	
	public Boolean isActif()
	{
		return actif;
	}


	//TODO This will be put on the view plateau and CALL for the plateau controller
//	public void actionPerformed(ActionEvent arg0)
//	{
//		actif = true;
//		//setMsg(true);
//		//repaint();
//		((Bouton)arg0.getSource()).setEnabled(false);
//	}


//	public void jouer(PanneauInfo l)
//	{	Joueur j=Joueur.getInstance();
//		cases[j.getPosition()].jouerCase();
//		if(!(cases[j.getPosition()]instanceof Definition) && !(cases[j.getPosition()]instanceof Models.Image))
//		{
//			if(cases[j.getPosition()].isDeplacing())
//			{
//				l.setSomme(cases[j.getPosition()].getDeplacement());
//				l.getLancerDes().setEnabled(false);
//				actif = true;
//			}
//		}
//	}
		
	public Case[] getTab()
	{
		return cases;
	}

	public void setTab(Case[] cases)
	{
		this.cases = cases;
	}
}