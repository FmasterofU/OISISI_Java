package gui.view;

import java.awt.Component;

import javax.swing.table.TableColumn;

@SuppressWarnings("serial")
class ViewPredmeti extends ViewTableCenter {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return (Component) instance;
	}
	private ViewPredmeti() {
		TableColumn col= new TableColumn();
		col.setHeaderValue("kolona");
		table.addColumn(col);
		table.addColumn(new TableColumn());
	}
}