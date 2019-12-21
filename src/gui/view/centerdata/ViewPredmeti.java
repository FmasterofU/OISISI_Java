package gui.view.centerdata;

import java.awt.Component;

import gui.model.ListaPredmeta;
import persistence.Data;

@SuppressWarnings("serial")
public class ViewPredmeti extends ViewTableCenter {

	private static ViewPredmeti instance = null;
	private ThisTableModel<ListaPredmeta> model = null;
	public static Component getInstance() {
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
}