package Views;

import Models.Des;
import Models.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PartieView extends JFrame implements ActionListener {

    private PlateauView plat;
    private PanelView panelView;

    public PartieView(Plateau p, Des d) {
        this.setTitle("");                                        //Titre de la fentre
        this.setSize(988, 639);                                    //Taille de la fenetre
        this.setLocationRelativeTo(null);                        //Centrer la fentre sur l'ecran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Pour que Fermer ferme reellement
        this.setResizable(false);                                //La fenetre ne peut pas etre redimendionn�e
        double width = (0.811 * (getWidth())) + 16;        //taille du plateau de jeu

        JPanel content = new JPanel();                            //Panel Principal
        this.plat = new PlateauView(                                //Panel des cases
                (int) width,
                610
                , p
        );
        panelView = new PanelView(                    //Panel Info Joueur et PartieView
                (getWidth()) - (int) width,
                610
                , d
        );
        p.addObserver(panelView);

//	    plat.addMouseListener(panInfo);
//	    (panInfo.getLancerDes()).addActionListener(plat);
//	    (panInfo.getQuitter()).addActionListener(this);
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


//	public void setJoueur(Joueur j)
//	{
//		this.joueur = new Joueur(j.getNom(),j.getPion());
//		this.joueur.setPosition(j.getPosition());
//		this.joueur.setScore(j.getScore());
//	}

    public void actionPerformed(ActionEvent arg0) {
        int option = JOptionPane.showConfirmDialog(null,
                "Voulez-vous enregistrer votre partie avant de quitter ?",
                "Quitter",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if (option == JOptionPane.OK_OPTION) {
//			sauvegarder();
//			this.dispose();
//			FenetreA ac = new FenetreA();
//			ac.setVisible(true);
        } else if (option == JOptionPane.CANCEL_OPTION) {
        } else {
//			this.dispose();
//			FenetreA ac = new FenetreA();
//			ac.setVisible(true);
        }
    }
}