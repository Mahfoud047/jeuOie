package Models;

import java.util.Observable;
import java.util.Random;

public class Des extends Observable
{
	private int valDes1;
	private int valDes2;

	public Des(){}
	
	public int[] Lancer()
	{
		int resultatDes[] = { 0 , 0 };

		Random rand = new Random();

		valDes1 = rand.nextInt(6) + 1;
		valDes2 = rand.nextInt(6) + 1;

		resultatDes[0] = valDes1;
		resultatDes[1] = valDes2;

		return resultatDes;
	}

	public int getValeurDes1() {
		return valDes1;
	}

	public int getValeurDes2() {
		return valDes2;
	}
}
