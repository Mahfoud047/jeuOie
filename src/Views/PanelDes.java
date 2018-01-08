package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class PanelDes extends JPanel 
{	
	private Image img1;
	private Image img2;	
	private int de1;
	private int de2;
	private int somme=0;
	
	public PanelDes(int de1, int de2)
	{
		super();	
		this.setDe1(de1);
		this.setDe2(de2);
		setPreferredSize(new Dimension(150,70));
		try
		{
			img1 = ImageIO.read(new File( "Media\\"+de1+".png"));
		    img2 = ImageIO.read(new File("Media\\"+de2+".png"));
		    repaint();
		}catch (IOException e) {    }
	}

	public void setImages(int de1, int de2)
	{  
		this.setDe1(de1);
		this.setDe2(de2);	  	
		try
		{
			img1 = ImageIO.read(new File( "Media\\"+de1+".png"));
			img2 = ImageIO.read(new File("Media\\"+de2+".png"));
			repaint();
		}catch (IOException e) {    }
		  	repaint();
	}
	
	public void paintComponent(Graphics g)
	{
		try
		{
			g.setColor(new Color(123,217,108));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());        
		    g.drawImage(img1,20, 15, this);
		    g.drawImage(img2, 80, 15, this);
		}
		catch (Exception e){}
	}
	  
	public int getDe1() 
	{
		return de1;
	}
	
	public void setDe1(int de1) 
	{
		this.de1 = de1;
		  try
		  {
			  img1 = ImageIO.read(new File( "Media\\"+de1+".png"));
			  repaint();
		  }catch (IOException e) {    }
	}
	
	public int getDe2() 
	{
		return de2;
	}
	
	public void setDe2(int de2) 
	{
		this.de2 = de2;
	    try 
	    {
			img2 = ImageIO.read(new File("Media\\"+de2+".png"));
		    repaint();
		} catch (IOException e) {	}
	}
	
	public int getSomme()
	{
		return somme;
	}
	
	public void setSomme( int somme)
	{
		this.somme = somme;
	}
}