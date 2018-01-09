package Models;

import java.io.File;
import java.util.Random;
import java.util.TreeSet;

public class Definition extends Question
{
	static private String FILE_PATH = "assets\\Media\\caseDef.png";

	static final int POINTGAGNE = 20;
	static final int POINTPERDU = -10;
	@SuppressWarnings("rawtypes")
	private static TreeSet tableauIndice = new TreeSet();
	
	@SuppressWarnings("unchecked")
	public void jouerCase()
	{
//		// generer une question
//		Random rand = new Random();
//		String definition="", secretWord="";
//		k = rand.nextInt(PartieView.TAILLEDEFINITION ) ;
//		if(tableauIndice.size() == PartieView.TAILLEDEFINITION)
//		{
//			tableauIndice.removeAll(tableauIndice);
//			System.out.println("  Reinitialisation  !!! toute les definitions on ete vus !");
//		}
//		while(!(tableauIndice.add(k)))
//			k = rand.nextInt(PartieView.TAILLEDEFINITION );
//		definition = PartieView.getDefinition(k,0);
//		secretWord = PartieView.getDefinition(k,1);
//		tableauIndice.remove(k);
//		//poser les question-------------------------------------------
//		@SuppressWarnings("unused")
//		FenDef fen = new FenDef(definition,secretWord,this);
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
}