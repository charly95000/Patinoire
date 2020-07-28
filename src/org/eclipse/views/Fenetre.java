package org.eclipse.views;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import javax.swing.table.DefaultTableModel;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class Fenetre extends JFrame {
	
	private Formulaire formulaire;
    private ListView tab;
    private JTabbedPane onglet;
    
	
	public Fenetre(){
		this.setTitle("Ma première fenêtre Java");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    this.formulaire = new Formulaire();
	    this.tab=new ListView();
	    
	    formulaire.getBouton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
	        	String nom = formulaire.getInputNom().getText();
	            String prenom = formulaire.getInputPrenom().getText();
	            String photo = formulaire.getInputPhoto().getText();
	            String role = formulaire.getInputRole().getText();
	            String quality = formulaire.getInputQuality().getText();
	            PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
	            
	            Personne p = new Personne(nom,prenom,"toto",role,quality);
	            int cle=personneDaoImpl.save(p);
	            if (cle != -1){
	            	System.out.println("personne numero " + cle);
	            	try {
	            		
	            		Path fichier = Paths.get(photo);
	            		String ext=photo.split("\\.")[1];
	    	            photo="toto."+ext;
	            		System.out.println(ext);
	            		Path destination=Paths.get("assets/images/toto."+ext);
	                    Files.copy(fichier, destination);
	                    // Il est également possible de spécifier des options de copie. 
	                    // Ici : écrase le fichier destination s'il existe et copie les attributs de la source sur la destination.  
	                   //Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES); 
	                } catch (IOException e) { 
	                    e.printStackTrace();
	                } 
	            	Object[] donnee = new Object[]{cle,nom, prenom, photo, role, quality,"supprimer"};
	            	formulaire.reset();
	                ((PersonnesModele) tab.getTableau().getModel()).addRow(donnee);
	            }else
	            	System.out.println("probleme d’insertion");
	        }
	      });
	    
	    this.onglet= new JTabbedPane();
	    onglet.add("Ajouter",this.formulaire);
	    onglet.add("Liste",this.tab);
	    this.getContentPane().add(onglet);
	    this.setVisible(true);
		
	}
}
