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
	
	private String titre;
	
	private JPanel linesPanel;
	private JPanel displayPanel;
	private JTextArea resultDicesTextArea;
	private JTextArea scoreTextArea;
	private JTextArea messageTextArea;
	private JButton throwDicesButton;
	
	public InterfaceGraphiqueDefault() {

		// editing the frame
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		// create the elements
		this.linesPanel = new JPanel();
		this.displayPanel = new JPanel();
		this.resultDicesTextArea = new JTextArea("[]");
		this.scoreTextArea = new JTextArea("Score : " + Jeu.getInstance().getScore());
		this.messageTextArea = new JTextArea("Lancez les des.");
		this.resultDicesTextArea = new JTextArea();
		this.throwDicesButton = new JButton("Lancer");
		
		// edit the dislplay panel
		this.linesPanel.setLayout(new BoxLayout(this.linesPanel, BoxLayout.PAGE_AXIS));
		
		// edit the lines panel
		this.linesPanel.setLayout(new BoxLayout(this.linesPanel, BoxLayout.PAGE_AXIS));
		
		//edit the throw dices button
		ActionListener rollDicesButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().rollDicesButtonPressed();
			}
		};
		throwDicesButton.addActionListener(rollDicesButtonListener);
		
		// add the  elements to the display panel
		this.displayPanel.add(this.resultDicesTextArea);
		this.displayPanel.add(this.scoreTextArea);
		this.displayPanel.add(this.messageTextArea);
		// add the elements to the frame
		this.getContentPane().add(this.displayPanel, BorderLayout.CENTER);
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
		this.scoreTextArea.setText("Votre score : " + score);
	}
	
	public void setAffichageMessage(String message){
		this.messageTextArea.setText(message);
	}
	
	// add a line to the lines panel
	public void addLine(ILigne ligne){
		JButton button = new JButton(ligne.getNom());
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jeu.getInstance().lineButtonPressed(ligne);
			}
		});
		this.linesPanel.add(button);
		
	}

}
