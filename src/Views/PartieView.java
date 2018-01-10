package Views;

import Models.Des;
import Models.Plateau;
import javax.swing.*;
import java.awt.*;

public class PartieView extends JFrame {

    private PlateauView plat;
    private PanelView panelView;

    public PartieView(Plateau p, Des d) {
        this.setTitle("");                                         //Titre de la fentre
        this.setSize(988, 639);                                    //Taille de la fenetre
        this.setLocationRelativeTo(null);                          //Centrer la fentre sur l'ecran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Pour que Fermer ferme reellement
        this.setResizable(false);                                  //La fenetre ne peut pas etre redimendionn�e
        double width = (0.811 * (getWidth())) + 16;                //taille du plateau de jeu

        JPanel content = new JPanel();                             //Panel Principal
        this.plat = new PlateauView(                               //Panel des cases
                (int) width,
                610
                , p
        );
        panelView = new PanelView(                                //Panel Info Joueur et PartieView
                (getWidth()) - (int) width,
                610
                , d
        );
        p.addObserver(panelView);

        JPanel menu = new JPanel();                        //menu
        menu.setPreferredSize(
                new Dimension(getWidth() - 16, 20)
        );
        menu.setBackground(Color.BLACK);
        content.setLayout(new BorderLayout());
        content.add(menu, BorderLayout.NORTH);
        content.add(panelView, BorderLayout.WEST);
        content.add(plat, BorderLayout.CENTER);
        this.setContentPane(content);
        this.setVisible(true);            //Fenetre Visible
    }

}