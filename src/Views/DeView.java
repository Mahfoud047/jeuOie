package Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class DeView extends JPanel implements MouseListener, ActionListener {
    private Bouton lancer;
    private Image img1;
    private Image img2;
    private int de1;
    private int de2;
    private int somme=0;

    public DeView(){
            super();
            this.setDe(0,0);
            this.setDe(1,0);
            setPreferredSize(new Dimension(150,70));
            try
            {
                img1 = ImageIO.read(new File( "assets\\Media\\"+de1+".png"));
                img2 = ImageIO.read(new File("assets\\Media\\"+de2+".png"));
                repaint();
            }catch (IOException e) {

            }

        lancer = new Bouton("           Lancer les des    ");
        lancer.addActionListener(this);
        add(lancer);
    }

    public void setImages(int de1, int de2)
    {
        this.setDe(0,de1);
        this.setDe(1,de2);
        try
        {
            img1 = ImageIO.read(new File( "assets\\Media\\"+de1+".png"));
            img2 = ImageIO.read(new File("assets\\Media\\"+de2+".png"));
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

    public int getDe(int numDe)
    {
        switch (numDe){
            case 0:return de1;
            case 1:return de2;
            default:return de1;
        }
    }

    public void setDe(int numDe, int de)
    {
        switch (numDe){
            case 0:{
                this.de1 = de;
                try
                {
                    img1 = ImageIO.read(new File( "assets\\Media\\"+de1+".png"));
                    repaint();
                }catch (IOException e) {}
            }break;
            case 1:{
                this.de2 = de;
                try
                {
                    img2 = ImageIO.read(new File( "assets\\Media\\"+de2+".png"));
                    repaint();
                }catch (IOException e) {}

            }break;
            }
        }

    public int getSomme()
    {
        return somme;
    }

    public void setSomme( int somme)
    {
        this.somme = somme;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
