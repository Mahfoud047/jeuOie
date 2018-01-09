package Views;

import Controllers.DesControler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class DeView extends JPanel implements ActionListener {
    private BoutonView lancer;
    private Image img1;
    private Image img2;
    private int de1;
    private int de2;
    private DesControler desControler;

    public DeView() {
        super();

        desControler = new DesControler();

        JPanel separerPnl = new JPanel();
        separerPnl.setPreferredSize(new Dimension(0, 160));
        add(separerPnl);
        this.setDe(0, 0);
        this.setDe(1, 0);
        setPreferredSize(new Dimension(150, 220));
        try {
            img1 = ImageIO.read(new File("assets\\Media\\" + de1 + ".png"));
            img2 = ImageIO.read(new File("assets\\Media\\" + de2 + ".png"));
            repaint();
        } catch (IOException e) {

        }

        lancer = new BoutonView("           Lancer les des    ");
        lancer.addActionListener(this);
        add(lancer);
    }

    public void setImages(int de1, int de2) {
        this.setDe(0, de1);
        this.setDe(1, de2);
        try {
            img1 = ImageIO.read(new File("assets\\Media\\" + de1 + ".png"));
            img2 = ImageIO.read(new File("assets\\Media\\" + de2 + ".png"));
            repaint();
        } catch (IOException e) {
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        try {
            g.setColor(new Color(123, 217, 108));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(img1, 20, 15, this);
            g.drawImage(img2, 80, 15, this);
        } catch (Exception e) {
        }
    }

    public int getDe(int numDe) {
        switch (numDe) {
            case 0:
                return de1;
            case 1:
                return de2;
            default:
                return de1;
        }
    }

    public void setDe(int numDe, int de) {
        switch (numDe) {
            case 0: {
                this.de1 = de;
                try {
                    img1 = ImageIO.read(new File("assets\\Media\\" + de1 + ".png"));
                    repaint();
                } catch (IOException e) {
                }
            }
            break;
            case 1: {
                this.de2 = de;
                try {
                    img2 = ImageIO.read(new File("assets\\Media\\" + de2 + ".png"));
                    repaint();
                } catch (IOException e) {
                }

            }
            break;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==lancer) {
            int res[];
            res = desControler.lancerDes();
            setImages(res[0],res[1]);
        }
    }
}
