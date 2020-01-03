package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;

@SuppressWarnings("serial")
public class ViewSearch extends ViewTableCenter {

	private static ViewSearch instance = null;
	private static int rootTab = -1;
	private int KEY_COLUMN; //sifra
	
	public static ViewSearch getInstance(int tab, int key) {
		if(instance==null) instance = new ViewSearch(tab,key);
		return instance;
	}
	
	public static ViewSearch instanceExists() {
		return instance;
	}
	
	public static int getRootTab() {
		return rootTab;
	}
	
	public static void removeInstance() {
		CenterBox.getInstance().remove(instance);
		instance=null;
		rootTab=-1;
		CenterBox.redraw();
	}
	
	private ViewSearch(int tab, int key) {
		rootTab=tab;
		KEY_COLUMN=key;
		switch(tab) {
			case 0:
			table.setModel(new ThisTableModel<ListaStudenata>(new ListaStudenata(Data.getListaStudenata())));
				break;
			case 1:
			table.setModel(new ThisTableModel<ListaProfesora>(new ListaProfesora(Data.getListaProfesora())));
				break;
			case 2:
			table.setModel(new ThisTableModel<ListaPredmeta>(new ListaPredmeta(Data.getListaPredmeta())));
				break;
		}
		resizeColumnWidth();
		table.setRowSorter(((ThisTableModel<?>)table.getModel()).getSorter());
		CenterBox.getInstance().addTab("Search", this);
		CenterBox.getInstance().setSelectedComponent(this);
		CenterBox.redraw();
	}
	
	public void updateTable(){
		if(table.getModel() != null) 
			((ThisTableModel<?>)table.getModel()).fireTableDataChanged();
		}
	
	public String getSelectedKey() {
		int row = table.getSelectedRow();
		if(row==-1) return null;
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLUMN);
	}
}
