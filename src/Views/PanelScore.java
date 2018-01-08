package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

@SuppressWarnings("serial")
public class PanelScore extends JPanel
{
	@SuppressWarnings("rawtypes")
	public PanelScore(Joueur j, int width) 
	{
		setPreferredSize(new Dimension(width,100));
		setLayout(new FlowLayout());
		@SuppressWarnings("unchecked")
		TreeSet<Integer> scores = new TreeSet(Partie.getScores());
		FonScorePan pan;
		for(int i=1;i<9;i++)
		{
			pan =new FonScorePan(i);
			try
			{
				if(!scores.isEmpty())
					pan.add(new JLabel(Integer.toString(scores.last())));
				else break;
			}catch(NumberFormatException e)
			{
				break;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			add(pan);
			scores.remove(scores.last());
		}
	}
	
	public void paintComponent(Graphics g)
	{//fonScore.
	    try 
	    {//dessiner le fond	
	    	g.setColor(Color.black);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
	        Image img = ImageIO.read(new File("Media\\fonScore.png"));
	        g.drawImage(img, 0,0, this);
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }  
	}
}