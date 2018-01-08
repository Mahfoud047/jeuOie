package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class FonScorePan extends JPanel
{
	Image img ;
	public FonScorePan(int i)
	{
		setPreferredSize(new Dimension(460,26));
		if(i==1)
		{
			try
			{
		        img = ImageIO.read(new File("Media\\Or.png"));
			}catch(IOException e) 
			{
				e.printStackTrace();
			}
		}else if(i==2)
		{
			try
			{
		        img = ImageIO.read(new File("Media\\Bronze.png"));
			}catch(IOException e) 
			{
				e.printStackTrace();
			}
		}else if (i==3)
		{
			try
			{
		        img = ImageIO.read(new File("Media\\argent.png"));
			}catch(IOException e) 
			{
				e.printStackTrace();
			}
		}else
		{
			try
			{
		        img = ImageIO.read(new File("Media\\standard.png"));
			}catch(IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public void paintComponent(Graphics g)
	{//fonScore.
		g.drawImage(img, 0,0, this);
	}
}