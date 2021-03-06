package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageUserView extends JPanel
{
    Image img ;
	public ImageUserView(int i)
	{
		super();
		setPreferredSize(new Dimension(180,135));
		String tmp= "assets\\Media\\Im"+i+".png";
        try
        {
        	img = ImageIO.read(new File(tmp));
        } catch (IOException e) 
        {
        	img = null;
	    }  
	}
	
	public void paintComponent(Graphics g)
	{
		if(img!=null)
		{
			g.setColor(new Color(123,217,108));
	        g.drawImage(img, 7, 0, this);
	    }
	}
}