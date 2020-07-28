package org.eclipse.views;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

//CTRL + SHIFT + O pour générer les imports
public class TableComponent extends DefaultTableCellRenderer {

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (value instanceof JButton)
      return (JButton) value;
    //Lignes ajoutées
    else if(value instanceof JCheckBox)
      return (JCheckBox) value;
    else
      return this;
  }
}