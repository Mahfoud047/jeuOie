package Models;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

import static sun.audio.AudioPlayer.player;

@SuppressWarnings("serial")
public class Saut extends Case {
    static private String FILE_PATH = "assets\\Media\\caseSaut.png";

//	private Joueur player;

//	public void jouerCase(Joueur j)
//	{
//		player = j;
//	}

    @Override
    public String jouerCase() {
        Random rand = new Random();
        int dep = rand.nextInt(100) + 1;

        Des d = Des.getInstance();
        d.setValDes(rand.nextInt(100) + 1);
        return "Case Saut! \nAvancer vers la case N�"+(dep+1);
    }

    public Boolean isDeplacing() {
        return true;
    }

    public int getDeplacement() {
//		Random rand = new Random();
//		int dep = rand.nextInt(100) + 1;
//		JOptionPane.showMessageDialog(new Frame(),
//				"Case Saut! \nAvancer vers la case N�"+(dep+1),
//				"Saut",
//				JOptionPane.INFORMATION_MESSAGE);
//		return (dep - player.getPosition());
        return 0;
    }

    @Override
    public File getFile() {
        return new File(this.FILE_PATH);
    }

    @Override
    public Boolean bloquerPlateau() {
        return false;
    }
}