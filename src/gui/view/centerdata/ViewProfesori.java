package gui.view.centerdata;

import java.awt.Component;

import gui.model.Data;
import gui.model.ListaProfesora;

@SuppressWarnings("serial")
class ViewProfesori extends ViewTableCenter {
	private static Component instance = null;
	private ThisTableModel<ListaProfesora> model = null;
	public static Component getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return (Component) instance;
	}
	private ViewProfesori() {
		model = new ThisTableModel<ListaProfesora>(Data.data.listaProfesora);
		table.setModel(model);
		resizeColumnWidth();
	}

	public void updateTable(){
		if(model != null) 
			model.fireTableDataChanged();
	}
}