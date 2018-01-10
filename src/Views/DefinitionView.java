package Views;

import Models.Definition;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.StringTokenizer;

@SuppressWarnings("serial")
public class DefinitionView extends JFrame implements ActionListener
{
	private JTextField rpse[];
	private String pass;
	private Definition Case;

	public DefinitionView(String t1, String t2)
	{
		/*----------------	GRAPHIQUE -------------*/
		this.setTitle("");										//Titre de la fentre
	    this.setSize(480, 220);									//Taille de la fenetre
	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionn�e
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 	//Pour que Fermer ferme reellement
	    //Case = cas;						//La case de definition (case correspondante dans le tableau des case du Plateau)
	    pass = t2;								// La bonne reponse
	    rpse =new JTextField[pass.length()];	// La reponse introduite par l'utilisateur
	    JButton bt = new JButton("     ok     ");				//bouton de validation	    
	    JPanel rps = new JPanel();
	    for(int i=0;i<rpse.length;i++)
	    {	
	    	try
	    	{
	    		MaskFormatter tel = new MaskFormatter("?   ");
		    	rpse[i]=new JFormattedTextField(tel);
	    	}catch(ParseException e){e.printStackTrace();}
	    	rps.add(rpse[i]);
	    }
	    this.getContentPane().setLayout(new FlowLayout());
	    this.getContentPane().add(new JLabel("Definition:"));	    
	    JPanel def = new JPanel();
	    def.setPreferredSize(new Dimension(350,30));
	    this.getContentPane().add(def);
	    def = new JPanel();
	    def.setBackground(Color.GREEN);
	    def.setPreferredSize(new Dimension(450,100));
	    def.add(new JLabel("                                                                                                                                                                                "));
	    StringTokenizer tok = new StringTokenizer(t1, ", ");
		while(tok.hasMoreTokens())
		{
			def.add(new JLabel((String)tok.nextElement()));
		}
	    this.getContentPane().add(def);
	    this.getContentPane().add(def);
	    this.getContentPane().add(rps);
	    this.getContentPane().add(bt);
	    bt.addActionListener(this);
	    //LeMain.getPartie().setAlwaysOnTop(true);
	    setAlwaysOnTop(true);
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{		
//		Joueur j=LeMain.getPartie().getJoueur();
//		PanneauInfo info = LeMain.getPartie().getInfo();
//		Plateau plat = LeMain.getPartie().getPlat();
//		LeMain.getPartie().setAlwaysOnTop(false);
//	    setAlwaysOnTop(false);
//	    Boolean aRpdu = true;
//	    String rp="";
//	    String token;
//	    for(int i=0;i<pass.length();i++)
//	    {
//	    	StringTokenizer tok = new StringTokenizer(rpse[i].getText(), " ");
//			while(tok.hasMoreTokens())
//			{
//				token = (String)tok.nextElement();
//				if(token.length()!=1)
//				{
//					aRpdu=false;
//					break;
//				}
//				rp = rp +token;
//			}
//	    }
//	    if (rp.length()!=pass.length()) aRpdu = false;
//		if(aRpdu){
//			if(rp.equalsIgnoreCase(pass))
//			{
//				j.incrementer( Definition.POINTGAGNE);
//				info.setScores();
//				Case.add();
//				info.setSomme(4);
//			    info.getLancerDes().setEnabled(false);
//			    plat.activer();
//			    JOptionPane.showMessageDialog(new Frame(),
//			    		"Bonne r�ponse! \nVous venez de ganger 20 points!\nAvancez de quatres cases",
//			    		"Definition",
//			    		JOptionPane.INFORMATION_MESSAGE);
//			} else
//			{
//				j.incrementer( Definition.POINTPERDU );
//				info.setScores();
//				JOptionPane.showMessageDialog(new Frame(),
//						"Mauvaise r�ponse! \nVous venez de perdre 10 points!\nEssayer de r�pondre juste la prochaine fois",
//						"Definition",
//						JOptionPane.WARNING_MESSAGE);
//			}
//			LeMain.getPartie().setEnabled(true);
//			this.dispose();
//		}else
//		{
//			Frame frame = new Frame();
//			frame.setAlwaysOnTop(true);
//			JOptionPane.showMessageDialog(frame,
//					"Veuillez a ce que chaque champ contienne un seul caractere !\n(les blancs sont permis)",
//					"Erreur",
//					JOptionPane.ERROR_MESSAGE);
//		}
	}	
}