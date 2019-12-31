package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;

@SuppressWarnings("serial")
public class ViewProfesori extends ViewTableCenter {
	
	private static ViewProfesori instance = null;
	private ThisTableModel<ListaProfesora> genModel = null;
	static final int KEY_COLUMN = 7; //kolona licne karte
	
	public static ViewProfesori getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return instance;
	}
	private ViewProfesori() {
		genModel = new ThisTableModel<ListaProfesora>(Data.data.listaProfesora);
		table.setModel(genModel.getModel());
		resizeColumnWidth();
		table.setRowSorter(genModel.getSorter());
	}

	public void updateTable(){
		if(genModel.getModel() != null) 
			genModel.getModel().fireTableDataChanged();
	}
	
	public String getSelectedKey() {
		int row = table.getSelectedRow();
		if(row==-1) return null;
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLUMN);
	}
}