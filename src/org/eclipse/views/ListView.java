package org.eclipse.views;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListView extends JPanel {
	private JTable tableau;
	private PersonnesModele data;
	public ListView(){
		this.data=new PersonnesModele();
		this.tableau= new JTable(data);
	    this.tableau.getColumn("Bouton").setCellRenderer(new ButtonRenderer());
	    this.tableau.getColumn("Bouton").setCellEditor(new BoutonSupPers(new JCheckBox()));
	    this.add(new JScrollPane(this.tableau));
	  //On indique que l'en-tête doit être au nord, donc au-dessus
	    this.add(this.tableau.getTableHeader(), BorderLayout.NORTH);
	    
	    //Et le corps au centre !
	    this.add(tableau, BorderLayout.CENTER);
	}
	
	public JTable getTableau(){
		return tableau;
	}
	

}
