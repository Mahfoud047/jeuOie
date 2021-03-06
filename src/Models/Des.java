package Models;

import java.util.Observable;
import java.util.Random;

public class Des extends Observable
{
	private int valDes1;
	private int valDes2;

    private Boolean actif;

    static private Des instance;

    private Des(){
        actif = true;
    }

    private synchronized static void effectuerSync() {
        if (instance==null) instance= new Des ();
    }

    public static Des getInstance() {
        if (instance==null) effectuerSync();
        return instance;
    }
	
	public int[] Lancer()
	{
		int resultatDes[] = { 0 , 0 };

		Random rand = new Random();

		valDes1 = rand.nextInt(6) + 1;
		valDes2 = rand.nextInt(6) + 1;

		resultatDes[0] = valDes1;
		resultatDes[1] = valDes2;

        actif = false;

        //notif plateau
        setChanged();
        notifyObservers("desLances");

		return resultatDes;
	}

	public int getValeurDes1() {
		return valDes1;
	}

	public int getValeurDes2() {
		return valDes2;
	}

    public void setValDes(int valDes1) {
        this.valDes1 = valDes1;
        this.valDes2 = 0;
    }

    public static void dispose(){
        instance = null;
    }

    public void activer()
    {
        actif = true;
    }

    public Boolean isActif()
    {
        return actif;
    }
}
