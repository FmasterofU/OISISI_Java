package gui.view;

import java.awt.Component;

import gui.model.ListaStudenata;

class ViewStudenti extends ViewTableCenter {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static Component instance = null;
	public static Component getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return (Component) instance;
	}
	private ViewStudenti() {
			table.setModel(new TableModel<ListaStudenata>(ListaStudenata.getInstance()));
	}
	
	public int getSelectedIndex()
	{
		return table.getSelectedRow();
	}
}