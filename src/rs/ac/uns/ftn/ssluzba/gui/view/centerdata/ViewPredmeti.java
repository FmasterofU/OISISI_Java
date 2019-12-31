package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;

@SuppressWarnings("serial")
public class ViewPredmeti extends ViewTableCenter {

	private static ViewPredmeti instance = null;
	private ThisTableModel<ListaPredmeta> genModel = null;
	static final int KEY_COLUMN = 0; //sifrapredmeta
	
	public static ViewPredmeti getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return instance;
	}
	private ViewPredmeti() {
		genModel = new ThisTableModel<ListaPredmeta>(Data.data.listaPredmeta);
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