package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;
import rs.ac.uns.ftn.ssluzba.gui.view.ToolBar;

@SuppressWarnings("serial")
public class ViewSearch extends ViewTableCenter {

	private static ViewSearch instance = null;
	private int rootTab = -1;
	private int KEY_COLUMN; //sifra
	public static boolean updateInProgress = false;
	
	public static ViewSearch getInstance(int tab, int key, ThisTableModel<?> model) {
		if(instance==null) instance = new ViewSearch(tab,key,model);
		return instance;
	}
	
	public static ViewSearch instanceIfExists() {
		return instance;
	}
	
	public static int getRootTab() {
		if(instance==null) return -1;
		return instance.rootTab;
	}
	
	public static void removeInstance() {
		int tab = CenterBox.getInstance().getSelectedIndex();
		int rootTab = getRootTab();
		CenterBox.getInstance().remove(instance);
		ViewStudenti.inSearchMode=false;
		ViewProfesori.inSearchMode=false;
		ViewPredmeti.inSearchMode=false;
		instance=null;
		CenterBox.redraw();
		if(tab==3) CenterBox.getInstance().setSelectedIndex(rootTab);
	}
	
	private ViewSearch(int tab, int key, ThisTableModel<?> model) {
		rootTab=tab;
		KEY_COLUMN=key;
		updateInProgress = false;
		table.setModel(model);
		resizeColumnWidth();
		table.setRowSorter(((ThisTableModel<?>)table.getModel()).getSorter());
		CenterBox.getInstance().addTab("Search", this);
		CenterBox.getInstance().setSelectedComponent(this);
		CenterBox.redraw();
	}
	
	public String getSelectedKey() {
		int row = table.getSelectedRow();
		if(row==-1) return null;
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLUMN);
	}
	
	public void updateTable() {
		updateInProgress = true;
		ToolBar.getInstance().reSearch();
	}
}
