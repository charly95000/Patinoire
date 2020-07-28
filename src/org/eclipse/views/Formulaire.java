package org.eclipse.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class Formulaire extends JPanel implements ActionListener {
	private JTextField inputNom = new JTextField();
	private JLabel labelNom = new JLabel("Nom : ");
	private Box nom = Box.createHorizontalBox();
	
	private JTextField inputPrenom = new JTextField();
	private JLabel labelPrenom = new JLabel("Prenom : ");
	private Box prenom = Box.createHorizontalBox();
	
	private JTextField inputPhoto = new JTextField();
	private JLabel labelPhoto = new JLabel("Photo : ");
	private Box photo = Box.createHorizontalBox();
	
	private JTextField inputRole = new JTextField();
	private JLabel labelRole = new JLabel("Role : ");
	private Box role = Box.createHorizontalBox();
	
	private JTextField inputQuality = new JTextField();
	private JLabel labelQuality = new JLabel("Quality : ");
	private Box quality = Box.createHorizontalBox();
	
	private JButton imprimer = new JButton("Imprimer");
	private JButton effacer = new JButton("Effacer");
	private JButton parcourir = new JButton("Parcourir");
	private Box grille= Box.createVerticalBox();
	
	
	public Formulaire(){
		 
		effacer.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reset();
			}
			
		});
		
		parcourir.addActionListener(this);
	    
		
		
		
		
	    
	    this.inputNom.setPreferredSize(new Dimension(300, 20));
	    this.labelNom.setPreferredSize(new Dimension(100, 20));
	    
	    
	    this.inputPrenom.setPreferredSize(new Dimension(300, 20));
	    this.labelPrenom.setPreferredSize(new Dimension(100, 20));
	    
	    
	    this.inputPhoto.setPreferredSize(new Dimension(300, 20));
	    this.labelPhoto.setPreferredSize(new Dimension(100, 20));
	    
	    
	    this.inputRole.setPreferredSize(new Dimension(300, 20));
	    this.labelRole.setPreferredSize(new Dimension(100, 20));
	    
	    
	    this.inputQuality.setPreferredSize(new Dimension(300, 20));
	    this.labelQuality.setPreferredSize(new Dimension(100, 20));
	    
	    this.nom.add(labelNom);
	    this.nom.add(getInputNom());
	    
	    
	    this.prenom.add(labelPrenom);
	    this.prenom.add(getInputPrenom());
	    
	    this.photo.add(labelPhoto);
	    this.photo.add(getInputPhoto());
	    
	    this.role.add(labelRole);
	    this.role.add(getInputRole());
	    
	    this.quality.add(labelQuality);
	    this.quality.add(getInputQuality());
	    
	    this.grille.add(nom);
	    this.grille.add(prenom);
	    this.grille.add(photo);
	    this.grille.add(role);
	    this.grille.add(quality);
	    this.grille.add(imprimer);
	    this.grille.add(effacer);
	    this.grille.add(parcourir);
	    
	    
	    
	    this.add(grille);
	}
	
	public JButton getBouton(){
		return this.imprimer;
	}

	public JTextField getInputNom() {
		return this.inputNom;
	}

	public void setInputNom(JTextField inputNom) {
		this.inputNom = inputNom;
	}

	public JTextField getInputPrenom() {
		return this.inputPrenom;
	}

	public void setInputPrenom(JTextField inputPrenom) {
		this.inputPrenom = inputPrenom;
	}

	public JTextField getInputPhoto() {
		return this.inputPhoto;
	}

	public void setInputPhoto(JTextField inputPhoto) {
		this.inputPhoto = inputPhoto;
	}

	public JTextField getInputRole() {
		return inputRole;
	}

	public void setInputRole(JTextField inputRole) {
		this.inputRole = inputRole;
	}

	public JTextField getInputQuality() {
		return this.inputQuality;
	}

	public void setInputQuality(JTextField inputQuality) {
		this.inputQuality = inputQuality;
	}
	
	public void reset(){
		this.getInputNom().setText("");
		this.getInputPrenom().setText("");
		this.getInputPhoto().setText("");
		this.getInputRole().setText("");
		this.getInputQuality().setText("");
	}
	
	public void actionPerformed(ActionEvent evt){
		JFileChooser chooser = new JFileChooser();//création dun nouveau filechosser
		chooser.setApproveButtonText("Choisir"); //intitulé du bouton
		//affiche la boite de dialogue
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
	    	{	
		inputPhoto.setText(chooser.getSelectedFile().getAbsolutePath());
	    	}
	}
}
