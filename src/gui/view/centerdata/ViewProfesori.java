package gui.view.centerdata;

import gui.model.Data;
import gui.model.ListaProfesora;

@SuppressWarnings("serial")
public class ViewProfesori extends ViewTableCenter {
	private static ViewProfesori instance = null;
	private ThisTableModel<ListaProfesora> model = null;
	public static ViewProfesori getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return instance;
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