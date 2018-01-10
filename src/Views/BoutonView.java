package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BoutonView extends JButton
{
	private String nom;
	private Image img;

	public BoutonView(String arg)
	{
		super(arg);
		setPreferredSize(new Dimension(149,34));
		this.setBorderPainted(false);
		nom=arg;
		try 
		{
			img = ImageIO.read(new File("assets\\Media\\Bouton.png"));
		} catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	
	public void paintComponent(Graphics g)
	{
		try 
		{
	        g.drawImage(img, 0, 0, this);
		} catch (Exception e) 
		{
	        e.printStackTrace();
		} 
		g.setColor(Color.white);
		g.drawString(nom, (this.getWidth() - nom.length())/16 , (this.getHeight() / 2) +3 );
	}
}