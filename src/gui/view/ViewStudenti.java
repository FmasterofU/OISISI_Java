package gui.view;

import gui.model.ListaStudenata;

public class ViewStudenti extends ViewTableCenter {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static ViewStudenti instance = null;
	private ThisTableModel<ListaStudenata> model = null;
	public static ViewStudenti getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return instance;
	}
	private ViewStudenti() {
			model = new ThisTableModel<ListaStudenata>(ListaStudenata.getInstance());
			table.setModel(model);
	}
	
	public void updateTable()
	{
		if(model != null)		model.fireTableDataChanged();
	}
}