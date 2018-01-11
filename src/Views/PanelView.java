package Views;

import Controllers.PanelControler;
import Models.Des;
import Models.Joueur;
import Models.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class PanelView extends JPanel implements ActionListener,Observer {

    private PanelControler panelControler;
    private DesView desView;
    private BoutonView nouvelle, quitter;
    JLabel scoreLabel;

    public PanelView(int x, int y, Des d) {
        super();

        panelControler = new PanelControler();

        desView = new DesView(d);

        Joueur.getInstance().addObserver(this);

        JLabel nomJoueurLabel;

        setPreferredSize(new Dimension(x, y));

        //meilleur Score
        JLabel tmp = new JLabel("Meilleur Score   ");
        add(tmp);
        Font font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
        tmp.setFont(font);
        tmp.setForeground(Color.WHITE);
        JPanel best = new JPanel();
        font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 15);

        //Extraire le best score
        nomJoueurLabel = new JLabel("Selma");
        nomJoueurLabel.setFont(font);
        nomJoueurLabel.setForeground(Color.WHITE);
        scoreLabel = new JLabel("60");
        scoreLabel.setFont(font);
        scoreLabel.setForeground(Color.YELLOW);
        best.setLayout(new FlowLayout());
        best.add(nomJoueurLabel);
        best.add(scoreLabel);
        best.setBackground(new Color(0, 0, 0, 0));
        add(best);

        //Joueur
        add(new ImageUserView(1));
        tmp = new JLabel("Nom Du Joueur");
        add(tmp);
        font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
        tmp.setFont(font);
        tmp.setForeground(Color.WHITE);
        tmp = new JLabel("Demo");
        add(tmp);
        font = new Font("Bernard MT Condensed", Font.CENTER_BASELINE, 20);
        tmp.setFont(font);
        tmp.setForeground(new Color(0, 0, 0));
        JPanel player = new JPanel();
        nomJoueurLabel = new JLabel("Score ");
        nomJoueurLabel.setFont(font);
        nomJoueurLabel.setForeground(Color.white);
        scoreLabel = new JLabel("0");
        scoreLabel.setFont(font);
        scoreLabel.setForeground(new Color(0, 0, 0));
        player.setLayout(new FlowLayout());
        player.add(nomJoueurLabel);
        player.add(scoreLabel);
        player.setBackground(new Color(0, 0, 0, 0));
        add(player);
        add(desView);
        nouvelle = new BoutonView("         Nouvelle Partie    ");
        nouvelle.addActionListener(this);
        add(nouvelle);

        quitter = new BoutonView("                Quitter");
        quitter.addActionListener(this);
        add(quitter);

    }

    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(new File("assets\\Media\\fondInfo.png"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            Color c = g.getColor();
            g.setColor(new Color(123, 217, 108));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(c);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitter) {
            panelControler.quitterPartie();
        } else if (e.getSource() == nouvelle) {
            panelControler.nouvellePartie();
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Plateau && arg.equals("caseJouer")){
            desView.setImages(0,0);
            scoreLabel.setText(Joueur.getInstance().getScore()+"");
        }else if (o instanceof Joueur && arg.equals("scoreChange")){
            scoreLabel.setText(Joueur.getInstance().getScore()+"");
        }
    }
}