package Models;

import java.util.Observable;
import java.util.Random;

public class Des extends Observable
{
	public Des(){}
	
	public int Lancer()
	{
		Random rand = new Random();
		return rand.nextInt(6) + 1;
	}
}
