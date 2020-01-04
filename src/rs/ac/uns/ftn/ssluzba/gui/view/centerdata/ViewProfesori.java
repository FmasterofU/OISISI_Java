package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;

@SuppressWarnings("serial")
public class ViewProfesori extends ViewTableCenter {
	
	private static ViewProfesori instance = null;
	private ThisTableModel<ListaProfesora> model = null;
	private static final int KEY_COLUMN = 7; //kolona licne karte
	public static boolean inSearchMode = false;
	public static final int[] SEARCH_COLUMNS = {0, 1, 5, 7};
	
	public static ViewProfesori getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return instance;
	}
	private ViewProfesori() {
		model = new ThisTableModel<ListaProfesora>(Data.getListaProfesora());
		table.setModel(model);
		//resizeColumnWidth();
		table.setRowSorter(model.getSorter());
	}

	public void updateTable(){
		if(model != null) 
			model.fireTableDataChanged();
	}
	
	public String getSelectedKey() {
		int row = table.getSelectedRow();
		if(row==-1) return null;
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLUMN);
	}
	
	public static int getKeyColumn(){
		return KEY_COLUMN;
	}
}