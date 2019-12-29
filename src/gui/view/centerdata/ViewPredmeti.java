package gui.view.centerdata;

import gui.model.Data;
import gui.model.ListaPredmeta;

@SuppressWarnings("serial")
public class ViewPredmeti extends ViewTableCenter {

	private static ViewPredmeti instance = null;
	private ThisTableModel<ListaPredmeta> model = null;
	static final int KEY_COLLUMN = 0; //sifrapredmeta
	
	public static ViewPredmeti getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return instance;
	}
	private ViewPredmeti() {
		model = new ThisTableModel<ListaPredmeta>(Data.data.listaPredmeta);
		table.setModel(model);
		resizeColumnWidth();
		}

	public void updateTable(){
		if(model != null) 
			model.fireTableDataChanged();
		}
	
	public String getSelectedKey() {
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLLUMN);
	}
}