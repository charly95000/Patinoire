package org.eclipse.views;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

import org.eclipse.dao.PersonneDaoImpl;
import org.eclipse.model.Personne;

public class PersonnesModele extends AbstractTableModel {
	private String entetes[];
	private Object[][] data;
	
	public PersonnesModele(){
		super();
		PersonneDaoImpl pDao=new PersonneDaoImpl();
		List <Personne> personnes = pDao.getAll() ;
		this.entetes=new String []{"ID","Nom","Prenom","Photo","Role","Qualit�","Bouton"};
		this.data= new Object[personnes.size()][this.entetes.length];
		
		
		for(int i=0;i<personnes.size();i++){
			for(int j=0;j<this.entetes.length;j++){
				switch(j){
				case 0:
					this.data[i][j]=personnes.get(i).getId();
					break;
				case 1:
					this.data[i][j]=personnes.get(i).getNom();
					break;
				case 2:
					this.data[i][j]=personnes.get(i).getPrenom();
					break;
				case 3:
					this.data[i][j]=personnes.get(i).getPhoto();
					break;
				case 4:
					this.data[i][j]=personnes.get(i).getRole();
					break;
				case 5:
					this.data[i][j]=personnes.get(i).getQuality();
					break;
				case 6:
					this.data[i][j]="supprimer";
					break;
				}
			}
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.entetes.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.data.length;
	}

	@Override
	public Object getValueAt(int i, int j) {
		// TODO Auto-generated method stub
		return this.data[i][j];
	}
	
	public String[] getEntetes(){
		return this.entetes;
	}
	public Object[][] getData(){
		return this.data;
	}
	
	/**
	* Retourne le titre de la colonne � l'indice sp�cifi�
	*/
	public String getColumnName(int col) {
	  return this.entetes[col];
	}
	
	//Retourne la classe de la donn�e de la colonne
	public Class getColumnClass(int col){
	  //On retourne le type de la cellule � la colonne demand�e
	  //On se moque de la ligne puisque les types de donn�es sont les m�mes quelle que soit la ligne
	  //On choisit donc la premi�re ligne
	  return this.data[0][col].getClass();
	}
	
	public void removeRow(int position){
        
        int indice = 0, indice2 = 0, nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
        Object temp[][] = new Object[nbRow][nbCol];
         
        for(Object[] value : this.data){
            if(indice != position){
                temp[indice2++] = value;
            }
            indice++;
        }
        this.data = temp;
        temp = null;
        //Cette m�thode permet d'avertir le tableau que les donn�es ont �t� modifi�es
        //Ce qui permet une mise � jours compl�te du tableau
        this.fireTableDataChanged();
    }
	
	public void addRow(Object[] data){
	      int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
	       
	      Object temp[][] = this.data;
	      this.data = new Object[nbRow+1][nbCol];
	       
	      for(Object[] value : temp)
	         this.data[indice++] = value;
	       
	          
	      this.data[indice] = data;
	      temp = null;
	      //Cette m�thode permet d'avertir le tableau que les donn�es
	      //ont �t� modifi�es, ce qui permet une mise � jour compl�te du tableau
	      this.fireTableDataChanged();
	   }
	
	//Retourne vrai si la cellule est �ditable : celle-ci sera donc �ditable
	public boolean isCellEditable(int row, int col){
	  //On appelle la m�thode getValueAt qui retourne la valeur d'une cellule
		if(col==6)
		    return true;
	  //Et on effectue un traitement sp�cifique si c'est un JButton
	  
	  return false; 
	}
	
	
}
