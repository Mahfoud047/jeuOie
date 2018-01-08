package Models;

import Controllers.PanneauInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;


@SuppressWarnings("serial")
public class Partie extends JFrame implements ActionListener
{	
	final static int TAILLEDEFINITION = 23;
	static int TAILLEIMAGE = 100;
	private Joueur joueur;
	private Plateau plat;
	PanneauInfo panInfo;
    @SuppressWarnings("unchecked")
	private static ArrayList<String> [] tableauDefinition =new ArrayList[TAILLEDEFINITION];
    private static String [] tableauImage= new String[TAILLEIMAGE];   
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static TreeSet <Integer> Scores =new TreeSet();
    private static int bestScore;
    private static String bestPlayer;

	public Partie(Joueur j)
	{
//		this.setTitle("");										//Titre de la fentre
//	    this.setSize(988, 639);									//Taille de la fenetre
//	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
//	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//Pour que Fermer ferme reellement
//	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionn�e
//        double width = ( 0.811*(getWidth()))+16;		//taille du plateau de jeu
        this.joueur = j;							//joueur
//		this.chagerFichier();
//	    JPanel content = new JPanel(); 							//Panel Principal
//	    this.plat = new Plateau(								//Panel des cases
//				(int)width,
//				610,
//				Joueur.getInstance());
//		panInfo  = new PanneauInfo(					//Panel Info Joueur et Partie
//				(getWidth())- (int)width,
//				610,
//				Joueur.getInstance());
//	    plat.addMouseListener(panInfo);
//	    (panInfo.getLancerDes()).addActionListener(plat);
//	    (panInfo.getQuitter()).addActionListener(this);
//	    JPanel menu = new JPanel();						//menu
//	    menu.setPreferredSize(
//	    		new Dimension(getWidth()-16 , 20)
//	    		);
//	    menu.setBackground(Color.BLACK);
//	    content.setLayout(new BorderLayout());
//	    content.add(menu,BorderLayout.NORTH);
//	    content.add(panInfo,BorderLayout.WEST);
//	    content.add(plat,BorderLayout.CENTER);
//	    this.setContentPane(content);
//	    this.setVisible(true);			//Fenetre Visible
	}

public void chagerFichier()
{
//		for(int r = 0 ; r < TAILLEDEFINITION ; r++)
//		{
//			tableauDefinition[r] = new ArrayList<String>();
//		}
//		BufferedReader entree = null;
//		try
//		{
//			int j =0;
//			String secretWord;
//			String ligneLue=null;
//			entree = new BufferedReader(new FileReader("Dictionary.txt"));
//		    while(j<TAILLEDEFINITION)
//		    {
//				ligneLue = entree.readLine();
//				if(ligneLue == null)
//					break;
//				StringTokenizer tok = new StringTokenizer(ligneLue, "#");
//				while(tok.hasMoreTokens())
//				{
//					secretWord = (String)tok.nextElement();
//					tableauDefinition[j].add(secretWord);
//					if(tok.hasMoreTokens())
//					{
//						secretWord = (String)tok.nextElement();
//						tableauDefinition[j].add(secretWord);
//					}
//				}
//				j++;
//			}
//		}catch(FileNotFoundException e)
//		{
//			e.printStackTrace();
//		}catch(IOException e)
//		{
//			e.printStackTrace();
//		}finally
//		{
//			try
//			{
//				if(entree != null)
//				{
//					entree.close();
//				}
//			}catch(IOException e){e.printStackTrace();
//		}
//	}
//
//	File img = new File("Image");
//	int j=0;
//	for(File nom : img.listFiles())
//	{
//		String mot =nom.getName();
//		if((mot.endsWith(".png"))&&!(mot.endsWith("S.png")))
//		{
//			StringTokenizer stok = new StringTokenizer(mot,".");
//			if(stok.hasMoreElements())
//				tableauImage[j]=(String)stok.nextElement();
//			j++;
//		}
//	}
//	TAILLEIMAGE=j;
		
//	img = new File("sauvegardes");
//	String ligneLue;
//	Boolean prem =true;
//	bestScore =0;			//Meilleur Score
//	bestPlayer=" ";			//Nom du joueur qui a le meilleur score
//	Scores.removeAll(Scores);
//	for(File nom : img.listFiles())
//	{
//		String fich ="sauvegardes\\"+nom.getName();
//		entree = null;
//		if(fich.toLowerCase().endsWith(".sco"))
//		{
//			try
//			{
//				entree = new BufferedReader(new FileReader(fich));
//				if(nom.getName().equalsIgnoreCase(joueur.getNom()+".sco"))
//				{
//					while(true)
//					{
//						ligneLue = entree.readLine();
//						if(ligneLue == null)break;
//						if (prem || bestScore < Integer.parseInt(ligneLue))
//						{
//							bestScore = Integer.parseInt(ligneLue);
//							bestPlayer = nom.getName();
//							prem =false;
//						}
//						Scores.add(Integer.parseInt(ligneLue));
//					}
//				}else
//				{
//					while(true)
//					{
//						ligneLue = entree.readLine();
//						if(ligneLue == null)break;
//						if (prem || bestScore < Integer.parseInt(ligneLue))
//						{
//							bestScore = Integer.parseInt(ligneLue);
//							bestPlayer = nom.getName();
//							prem=false;
//						}
//					}
//				}
//			}catch(FileNotFoundException e) {e.printStackTrace();}
//			catch(IOException e){e.printStackTrace();}
//			catch(NumberFormatException e){e.printStackTrace();}
//			finally
//			{
//				try
//				{
//					if(entree != null)
//					{
//						entree.close();
//					}
//				}catch(IOException e){e.printStackTrace();}
//			}
//		}
//	}
//	if (!prem)
//	{
//		StringTokenizer stok = new StringTokenizer(bestPlayer,".");
//		if(stok.hasMoreElements())
//			bestPlayer=(String)stok.nextElement();
//	}
}
	
	public Joueur getJoueur() 
	{
		return joueur;
	}
	
	public void setJoueur(Joueur j) 
	{
		this.joueur=Joueur.getInstance();
		this.joueur.setNom(j.getNom());
		this.joueur.setPion(j.getPion());
		this.joueur.setPosition(j.getPosition());
		this.joueur.setScore(j.getScore());
	}
	
	public Plateau getPlat() 
	{
		return plat;
	}
	
	public void setPlat(Plateau plat) 
	{
		this.plat = plat;
	}
	
	public PanneauInfo getInfo(){ return panInfo; }
	
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
	
	public void sauvegarder()
	{
//		Data d = new Data();
//		if(joueur.getPosition()!=99)
//		{
//			d.setJoueur(joueur);
//			d.setActif(plat.isActif());
//			d.setTab(plat.getTab());
//			d.setSomme(panInfo.getSomme());
//			d.setDes(panInfo.getde1(),panInfo.getde2());
//			d.setTableauIndice(Definition.getTableauIndice(),Image.getTableauIndice());
//			try
//			{
//			    FileOutputStream fichier = new FileOutputStream("sauvegardes\\"+joueur.getNom()+".ser");
//			    ObjectOutputStream oos = new ObjectOutputStream(fichier);
//			    oos.writeObject(d);
//			    oos.flush();
//			    oos.close();
//			}catch (IOException e1) {
//			    e1.printStackTrace();
//			}
//		}
	}
	
	public  void restaurer()
	{	
//		ObjectInputStream ois=null;
//		Data d=null;
//		Partie part=null;
//
//		try
//		{
//			ois = new ObjectInputStream(new FileInputStream( new File("sauvegardes\\"+joueur.getNom()+".ser")));
//			d = (Data)ois.readObject();
//			part = new Partie(d.getJoueur());
//			Definition.setTableauIndice(d.getTableauIndice(0));
//			Image.setTableauIndice(d.getTableauIndice(1));
//			if(d.getActif())
//			{
//				part.getPlat().activer();
//				part.getInfo().getLancerDes().setEnabled(false);
//			}
//			else part.getPlat().desactiver();
//			part.getPlat().setTab(d.getTab());
//			part.getInfo().setSomme(d.getSomme());
//			part.getInfo().setDes(d.getDes());
//			part.repaint();
//			Controllers.LeMain.setPartie(part);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
			sauvegarder();
			this.dispose();
			FenetreA ac = new FenetreA();
			ac.setVisible(true);
		}
		else if(option == JOptionPane.CANCEL_OPTION){		}
		else 
		{
			this.dispose();
			FenetreA ac = new FenetreA();
			ac.setVisible(true);
		}
	}
}