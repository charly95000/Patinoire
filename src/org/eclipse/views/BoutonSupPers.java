package org.eclipse.views;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class BoutonSupPers extends DefaultCellEditor {
	protected JButton button;
	private boolean isPushed;
	private ButtonListener bListener = new ButtonListener();
	PersonneDaoImpl p;
	
	public BoutonSupPers(JCheckBox checkBox){
		super(checkBox);
		button = new JButton("Supprimer");
		button.addActionListener(bListener);
		this.p= new PersonneDaoImpl();
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	      //On définit le numéro de ligne à notre listener
	      bListener.setRow(row);
	      //On passe aussi en paramètre le tableau pour des actions potentielles
	      bListener.setTable(table);
	      //On réaffecte le libellé au bouton
	      button.setText( (value ==null) ? "" : value.toString() );
	      //On renvoie le bouton
	       return button;
	   }
	
	class ButtonListener implements ActionListener{
		private int column, row;
	    private JTable table;
	    
	    public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id=table.getModel().getValueAt(this.row,0).toString();
			int num=Integer.parseInt(id);
			p.removeById(num);
			((PersonnesModele)table.getModel()).removeRow(this.row);
		}
		
	}
	//public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
		//personneDaoImpl.remove(p);
		
	//}

}
