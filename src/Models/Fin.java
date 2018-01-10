package Models;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class Fin extends Case
{
    static private String FILE_PATH = "assets\\Media\\caseFin.png";

    public String jouerCase()
	{
		return "";
//		Joueur j=Joueur.getInstance();
//		BufferedWriter fich = null;
//		BufferedReader in =null;
//		int i=0,min;
//		TreeSet <Integer> sco = new TreeSet <Integer>();
//		Boolean exist=false;
//		String ligneLue=null;
//		try
//		{
//			in = new BufferedReader(new FileReader("sauvegardes\\"+j.getNom()+".sco"));
//		    while(i<=10)
//		    {
//				ligneLue = in.readLine();
//				if(ligneLue == null)
//					break;
//				if(sco.add(Integer.parseInt(ligneLue)))
//				{
//					i++;
//				}
//			}
//		}catch(FileNotFoundException e){e.printStackTrace();}
//		catch(IOException e){e.printStackTrace();}
//		catch(NumberFormatException e){e.printStackTrace();}
//		finally
//		{
//			if (in != null)
//			try
//			{
//				in.close();
//			} catch (IOException e)
//			{
//				e.printStackTrace();
//			}
//		}
//	    if(i<10)
//	    {
//	    	if(!sco.add(j.getScore()))
//	    		exist = true;
//	    }else
//	    {
//	    	min=sco.first();
//	    	System.out.println(" min= " + min);
//	    	if(sco.add(j.getScore()))
//	    		sco.remove(min);
//	    	else exist = true;
//	    }
//		if(!exist)
//		{
//			try
//			{
//				Object[] tabSco= sco.toArray();
//				fich = new BufferedWriter (new FileWriter("sauvegardes\\"+j.getNom()+".sco",false));
//				for(int l =0;l<tabSco.length;l++)
//				{
//					fich.write(Integer.toString((int) tabSco[l]));
//					fich.newLine();
//				}
//			}catch(FileNotFoundException e){e.printStackTrace();}
//			catch(IOException e){e.printStackTrace();}
//			finally
//			{
//				if (fich != null)
//				try
//				{
//					fich.close();
//				} catch (IOException e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//		LeMain.getPartie().getInfo().getLancerDes().setEnabled(false);
//		JOptionPane.showMessageDialog(new Frame(),
//				"Fin de la partie !\nVous avez obtenu un score de "+j.getScore()+" points !\n(nouvelle PartieView) pour rejouer",
//				"Fin",
//				JOptionPane.INFORMATION_MESSAGE);
//				j.setPosition(0);
//				j.setScore(0);
	}
	
	public Boolean isDeplacing() 
	{
		return false;
	}
	
	public int getDeplacement() 
	{
		return 0;
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