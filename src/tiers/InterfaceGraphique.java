package tiers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.IAfficheur;
import app.Jeu;

@SuppressWarnings("serial")
public class InterfaceGraphique extends JFrame implements IAfficheur, ActionListener {
	
	private ArrayList<Integer> dices;
	private String titre;
	private JTextArea resultDicesTextArea;
	private JTextArea linesTextArea;
	private JButton throwDicesButton;
	
	public InterfaceGraphique() {

		// editing the frame
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// create the elements
		this.resultDicesTextArea = new JTextArea("result");
		this.linesTextArea = new JTextArea("lines");
		this.throwDicesButton = new JButton("Lancer");
		
		// edit the result text area
		resultDicesTextArea.setEditable(false);
		
		// edit the lines text area
		linesTextArea.setEditable(false);
		
		//edit the throw dices button
		throwDicesButton.addActionListener(this);
		
		// add the elements to the frame
		this.getContentPane().add(this.resultDicesTextArea, BorderLayout.CENTER);
		this.getContentPane().add(this.linesTextArea, BorderLayout.EAST);
		this.getContentPane().add(this.throwDicesButton, BorderLayout.SOUTH);
		
		this.setVisible(true);	
	}
	
	public void setTitre(String titre){
		this.titre = titre;
		this.setTitle(titre);
	}

	public void setAffichageResultatDes(int[] resultats){
		String affichage = "";
		for(int i : resultats){
			affichage += i + "  ";
		}
		this.resultDicesTextArea.setText(affichage);
	}

	@Override
	public void actionPerformed(ActionEvent e){
//		this.affiche("test");	
		Jeu.getInstance().throwDicesButtonPressed();
	}
}
