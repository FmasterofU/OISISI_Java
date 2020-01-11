package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.util.Comparator;

import javax.swing.DefaultRowSorter;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;

/**
 * @author fmaster
 * @implNote tab Profesori for {@link CenterBox}, singleton, extends {@link ViewTableCenter}
 */
@SuppressWarnings("serial")
public class ViewProfesori extends ViewTableCenter {
	
	private static ViewProfesori instance = null;
	private ThisTableModel<ListaProfesora> model = null;
	private static final int KEY_COLUMN = 7; //kolona licne karte
	public static boolean inSearchMode = false;
	public static final int[] SEARCH_COLUMNS = {0, 1, 5, 7};
	public static final int[] DATE_COLUMNS = {2};
	
	public static ViewProfesori getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return instance;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ViewProfesori() {
		model = new ThisTableModel<ListaProfesora>(Data.getListaProfesora());
		table.setModel(model);
		resizeColumnWidth();
		for(int i : DATE_COLUMNS)
			((DefaultRowSorter) model.getSorter()).setComparator(i, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					String[] first = o1.split("\\.");
					String[] second = o2.split("\\.");
					int[] check = {2, 1, 0};
					for(int i : check)
						if(first[i].compareTo(second[i])!=0)
							return first[i].compareTo(second[i]);
					return 0;
				}
			});
		table.setRowSorter(model.getSorter());
	}

	public void updateTable(){
		if(model != null) 
			model.fireTableDataChanged();
	}
	
	public String getSelectedKey() {
		int row = table.getSelectedRow();
		if(row==-1) return null;
		return (String) table.getValueAt(table.getSelectedRow(), KEY_COLUMN);
	}
	
	public static int getKeyColumn(){
		return KEY_COLUMN;
	}
}