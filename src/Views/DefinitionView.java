package Views;

import Controllers.DefinitionControler;
import Models.Definition;
import Models.Joueur;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.StringTokenizer;

public class DefinitionView extends JFrame implements ActionListener
{
	private JTextField []reponseField;
	private DefinitionControler definitionControler;
	int lengthReponse;

	public DefinitionView(Definition definition)
	{
		/*----------------	GRAPHIQUE -------------*/
		this.setTitle("Question");										//Titre de la fentre
	    this.setSize(480, 220);									//Taille de la fenetre
	    this.setLocationRelativeTo(null);						//Centrer la fentre sur l'ecran
	    this.setResizable(false);								//La fenetre ne peut pas etre redimendionn�e
	    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 	//Pour que Fermer ferme reellement
		//Creation du controleur de la vue
		definitionControler=new DefinitionControler(definition);
		String question=definitionControler.getQuestion();
		lengthReponse=definitionControler.getLengthReponse();							// La bonne reponse
		reponseField =new JTextField[lengthReponse];	// La reponse introduite par l'utilisateur
	    JButton bt = new JButton("     ok     ");				//bouton de validation
	    JPanel rps = new JPanel();
	    for(int i=0;i<reponseField.length;i++)
	    {	
	    	try
	    	{
	    		MaskFormatter tel = new MaskFormatter("?   ");
				reponseField[i]=new JFormattedTextField(tel);
	    	}catch(ParseException e){e.printStackTrace();}
	    	rps.add(reponseField[i]);
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
	    StringTokenizer tok = new StringTokenizer(question, ", ");
		while(tok.hasMoreTokens())
		{
			def.add(new JLabel((String)tok.nextElement()));
		}
	    this.getContentPane().add(def);
	    this.getContentPane().add(def);
	    this.getContentPane().add(rps);
	    this.getContentPane().add(bt);
	    bt.addActionListener(this);
	    setAlwaysOnTop(true);
	    this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
	    setAlwaysOnTop(false);
	    Boolean aRpdu = true;
	    String rp="";
	    String token;
	    for(int i=0;i<lengthReponse;i++)
	    {
	    	StringTokenizer tok = new StringTokenizer(reponseField[i].getText(), " ");
			while(tok.hasMoreTokens())
			{
				token = (String)tok.nextElement();
				if(token.length()!=1)
				{
					aRpdu=false;
					break;
				}
				rp = rp +token;
			}
	    }
	    if (rp.length()!=lengthReponse) aRpdu = false;
		if(aRpdu){
			boolean reponseJuste=definitionControler.reponseIsCorrect(rp);
			if(reponseJuste)
			{
				definitionControler.changerScoreJoueur(true);
			    JOptionPane.showMessageDialog(new Frame(),
			    		"Bonne réponse! \nVous venez de ganger 20 points!\nAvancez de quatres cases",
			    		"Definition",
			    		JOptionPane.INFORMATION_MESSAGE);
			} else
			{
				definitionControler.changerScoreJoueur(false);
				JOptionPane.showMessageDialog(new Frame(),
						"Mauvaise réponse! \nVous venez de perdre 10 points!\nEssayer de répondre juste la prochaine fois",
						"Definition",
						JOptionPane.WARNING_MESSAGE);
			}
			this.dispose();
		}else
		{
			Frame frame = new Frame();
			frame.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(frame,
					"Veuillez a ce que chaque champ contienne un seul caractere !\n(les blancs sont permis)",
					"Erreur",
					JOptionPane.ERROR_MESSAGE);
		}
	}	
}