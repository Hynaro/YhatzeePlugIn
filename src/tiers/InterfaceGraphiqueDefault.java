package tiers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.IAfficheur;
import app.IEvaluateur;
import app.ILigne;
import app.Jeu;

@SuppressWarnings("serial")
public class InterfaceGraphiqueDefault extends JFrame implements IAfficheur {
	
	private ArrayList<Integer> dices;
	private String titre;
	private JTextArea resultDicesTextArea;
	private JTextArea scoreTextArea;
	private JPanel linesPanel;
	private JButton throwDicesButton;
	
	public InterfaceGraphiqueDefault() {

		// editing the frame
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// create the elements
		this.resultDicesTextArea = new JTextArea("[]");
		this.scoreTextArea = new JTextArea("Score : " + Jeu.getInstance().getScore());
		this.linesPanel = new JPanel();
		this.throwDicesButton = new JButton("Lancer");
		
		// edit the result text area
		resultDicesTextArea.setEditable(false);
		
		// edit the lines panel
		this.linesPanel.setLayout(new BoxLayout(this.linesPanel, BoxLayout.PAGE_AXIS));
		
		//edit the throw dices button
		ActionListener rollDicesButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().rollDicesButtonPressed();
			}
		};
		throwDicesButton.addActionListener(rollDicesButtonListener);
		
		
		// add the elements to the frame
		this.getContentPane().add(this.resultDicesTextArea, BorderLayout.CENTER);
		this.getContentPane().add(this.scoreTextArea, BorderLayout.NORTH);
		this.getContentPane().add(this.linesPanel, BorderLayout.EAST);
		this.getContentPane().add(this.throwDicesButton, BorderLayout.SOUTH);
		
		this.setVisible(true);	
	}
	
	public void setTitre(String titre){
		this.titre = titre;
		this.setTitle(titre);
	}

	// display the new result of the roll of dice
	public void setAffichageResultatDes(int[] resultats){
		String affichage = "";
		for(int i : resultats){
			affichage += i + "  ";
		}
		this.resultDicesTextArea.setText(affichage);
	}
	
	public void setAffichageScore(int score){
		this.scoreTextArea.setText("Score : " + score);
	}
	
	// add a line to the lines panel
	public void addLine(ILigne ligne){
		System.out.println("ligne " + ligne.toString());
		JButton button = new JButton(ligne.getNom());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().lineButtonPressed(ligne.getType());
			}
		});
		this.linesPanel.add(button);
		
	}

}
