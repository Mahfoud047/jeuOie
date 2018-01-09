package Models;

import java.io.File;
import java.util.Random;
import java.util.TreeSet;

public class Image extends Question
{
	static private String FILE_PATH = "assets\\Media\\caseImg.png";

	final static int POINTGAGNE = 10;

	private static TreeSet tableauIndice = new TreeSet();


	public void jouerCase()
	{
//		int i,l;
//		// generer les images----------------------------------------
//		Random rand = new Random();
//		TreeSet nombres = new TreeSet();
//		String images[]=new String[4];
//		for (i =1;i<4;i++){
//			images[i]="Selma";
//		}
//		k = rand.nextInt(PartieView.TAILLEIMAGE );
//		if(tableauIndice.size() == PartieView.TAILLEIMAGE)
//		{
//			tableauIndice.removeAll(tableauIndice);
//			System.out.println("  Reinitialisation  !!! toute les images on ete vus !");
//		}
//		while(!tableauIndice.add(k))
//		{
//			k = rand.nextInt(PartieView.TAILLEIMAGE );
//		}
//		nombres.add(k);
//		images[0]=PartieView.getImage(k);
//		tableauIndice.remove(k);
//		for (i =1;i<4;i++)
//		{
//			l=rand.nextInt(PartieView.TAILLEIMAGE);
//			while(!nombres.add(l))
//			{
//				l=rand.nextInt(PartieView.TAILLEIMAGE);
//			}
//			images[i]=PartieView.getImage(l);
//		}
//		//poser les questions
//		@SuppressWarnings("unused")
//		FenIm fen = new FenIm(images,this);
//		LeMain.getPartie().setEnabled(false);
	}

	public Boolean isDeplacing() 
	{
		if(DEPLACEMENT > 0)return true;
		else return false;
	}

	public int getDeplacement() 
	{
		return DEPLACEMENT;
	}
	
	public void setDeplacement(int k) 
	{
		DEPLACEMENT = k;
	}
	@SuppressWarnings("unchecked")
	
	public void add()
	{
		tableauIndice.add(k);
	}
	@SuppressWarnings("rawtypes")
	
	public static TreeSet getTableauIndice()
	{
		return tableauIndice;
	}
	@SuppressWarnings("rawtypes")
	
	public static void setTableauIndice(TreeSet set)
	{
		 tableauIndice = set;
	}

	@Override
	public File getFile() {
		return new File(this.FILE_PATH);
	}

	@Override
	public Boolean bloquerPlateau() {
		return true;
	}
}