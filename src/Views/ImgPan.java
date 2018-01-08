package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class ImgPan extends JPanel
{	
	private Image img;	
	public ImgPan(String im)
	{
		try
		{
			img = ImageIO.read(new File( "Image\\"+im+".png"));
		    repaint();
		}catch (IOException e) {    }
		setPreferredSize(new Dimension(171,179));
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(123,217,108));
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		g.drawImage(img, 0,0, this);  
	}

	public void setIcon(String string) 
	{
		try
		{
			img = ImageIO.read(new File( "Image\\"+string+".png"));
		    repaint();
		}catch (IOException e) {    }
	}
}