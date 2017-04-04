package tiers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import app.IAfficheur;

@SuppressWarnings("serial")
public class AfficheResultatDes extends JFrame implements IAfficheur, ActionListener {
	ArrayList<Integer> dices;
	int i; 
	Random rand = new Random();
	JButton b1 = new JButton();   
	
	public AfficheResultatDes() {
		dices = new ArrayList<>();
		this.setTitle("Yhatzee !!!");
	    this.setSize(600, 600);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    b1.setSize(200, 100);
	    b1.setPreferredSize(new Dimension(200, 100));
	    b1.setVisible(true);
	    b1.setText("Lancer les dés");
	    this.add(b1,BorderLayout.CENTER);
	    b1.addActionListener(this);
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
