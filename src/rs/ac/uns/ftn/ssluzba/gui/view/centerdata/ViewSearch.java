package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;
import rs.ac.uns.ftn.ssluzba.gui.view.ToolBar;

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
				table.setModel(new ThisTableModel<ListaStudenata>(getNewModelStudent()));
				break;
			case 1:
			//table.setModel(new ThisTableModel<ListaProfesora>(new ListaProfesora(Data.getListaProfesora())));
				table.setModel(new ThisTableModel<ListaProfesora>(getNewModelProfesor()));
				break;
			case 2:
			//table.setModel(new ThisTableModel<ListaPredmeta>(new ListaPredmeta(Data.getListaPredmeta())));
				table.setModel(new ThisTableModel<ListaPredmeta>(getNewModelPredmet()));
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
	
	private ListaStudenata getNewModelStudent()
	{
		ListaStudenata ret = new ListaStudenata(Data.getListaStudenata());
		boolean check[] = new boolean[ret.getStudenti().size()];
		String name = "", surname = "", index = "", mail = "";
		String input = ToolBar.getSearchQuery();
		for(String splits : input.split(";"))
		{
			String parts[] = splits.split(":");
			if(parts.length != 2)	continue;
			if(parts[0].equals("ime"))
				name = parts[1];
			else if(parts[0].equals("prezime"))
				surname = parts[1];
			else if(parts[0].equals("indeks"))
				index = parts[1];
			else if(parts[0].equals("email"))
				mail = parts[1];
		}
		int i = 0;
		for(Student s : ret.getStudenti())
		{
			if(s.getIme().equals((name != "") ? name : s.getIme()) && s.getPrezime().equals((surname != "") ? surname : s.getPrezime()) &&
				s.getBrIndeksa().equals((index != "") ? index : s.getBrIndeksa()) && s.geteMail().equals((mail != "") ? mail : s.geteMail()))
				check[i] = true;
			i++;
		}
		
		for(i = check.length - 1; i >= 0; i--)
			if(!check[i])
				ret.getStudenti().remove(i);
		return ret;
	}
	
	private ListaProfesora getNewModelProfesor() {
		//TODO : implementation
		return new ListaProfesora(Data.getListaProfesora());
	}
	
	private ListaPredmeta getNewModelPredmet(){
		//TODO : implementation
		return new ListaPredmeta(Data.getListaPredmeta());
	}
}
