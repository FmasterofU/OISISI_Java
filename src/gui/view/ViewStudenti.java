package gui.view;

import java.awt.Component;

import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import gui.model.ListaStudenata;

class ViewStudenti extends ViewTableCenter {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static Component instance = null;
	public static Component getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return (Component) instance;
	}
	@SuppressWarnings("serial")
	private ViewStudenti() {
			table.setRowSelectionAllowed(true);
			table.setColumnSelectionAllowed(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(new AbstractTableModel() {
				
			@Override
			public int getColumnCount() {
				return ListaStudenata.getInstance().getColumnCount();
			}

			@Override
			public int getRowCount() {
				return ListaStudenata.getInstance().getRowCount();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return ListaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return false;
			}
			
			@Override
			public String getColumnName(int col) {
				return ListaStudenata.getInstance().getColumnName(col);
			}
		});
	}
	
	public int getSelectedIndex()
	{
		return table.getSelectedRow();
	}
}