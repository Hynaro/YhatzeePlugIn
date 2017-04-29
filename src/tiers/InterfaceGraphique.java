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

@SuppressWarnings("serial")
public class InterfaceGraphique extends JFrame implements IAfficheur, ActionListener {
	private JFrame frame;
	ArrayList<Integer> dices;
	private String titre;
	int i; 
	Random rand = new Random();
	JButton b1 = new JButton();   
	
	public InterfaceGraphique() {
//		dices = new ArrayList<>();
//		this.setTitle("Yhatzee !!!");
//	    this.setSize(600, 600);
//	    this.setLocationRelativeTo(null);               
//	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    this.setVisible(true);
//	    b1.setSize(200, 100);
//	    b1.setPreferredSize(new Dimension(200, 100));
//	    b1.setVisible(true);
//	    b1.setText("Lancer les d�s");
//	    this.add(b1,BorderLayout.CENTER);
//	    b1.addActionListener(this);
		
		this.frame = new JFrame();
		this.frame.setSize(600, 600);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setLayout(new BorderLayout());
		
		// create the elements
		JTextArea resultDicesTextArea = new JTextArea("result");
		JTextArea linesTextArea = new JTextArea("lines");
		JButton throwDicesButton = new JButton("Lancer");
		
		// edit the result text area
		resultDicesTextArea.setEditable(false);
		
		// edit the lines text area
		linesTextArea.setEditable(false);
		
		// add the elements to the frame
		this.frame.getContentPane().add(resultDicesTextArea, BorderLayout.CENTER);
		this.frame.getContentPane().add(linesTextArea, BorderLayout.EAST);
		this.frame.getContentPane().add(throwDicesButton, BorderLayout.SOUTH);
		
		this.frame.setVisible(true);	
	}
	
	public void setTitre(String titre){
		System.out.println("titre : " + titre);
		this.titre = titre;
		this.frame.setTitle(titre);
	}


	@Override
	public void affiche(String s) {
	
		for (i = 0 ; i < 5 ; i++){
			dices.add(roll());
		}
		System.out.println(dices);
	}

	
	public int roll(){
		
		return rand.nextInt(6) + 1;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		this.affiche("test");		
	}
}
