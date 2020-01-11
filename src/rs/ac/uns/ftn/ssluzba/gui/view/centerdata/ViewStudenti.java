package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.util.Comparator;

import javax.swing.DefaultRowSorter;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;

/**
 * @author rammba fmaster-commented(backup plan for sorting at some point)
 * @implNote tab Studenti for {@link CenterBox}, singleton, extends {@link ViewTableCenter}
 */
@SuppressWarnings("serial")
public class ViewStudenti extends ViewTableCenter {
	
	private static ViewStudenti instance = null;
	private ThisTableModel<ListaStudenata> model = null;
	private static final int KEY_COLUMN = 0;
	public static boolean inSearchMode = false;
	public static final int[] SEARCH_COLUMNS = {1, 2, 0, 9};
	public static final int[] DATE_COLUMNS = {3, 10};
	public static final int[] INDEX_COLUMNS = {0};
	
	public static ViewStudenti getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return instance;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ViewStudenti() {
		model = new ThisTableModel<ListaStudenata>(Data.getListaStudenata());
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
		for(int i : INDEX_COLUMNS)
			((DefaultRowSorter) model.getSorter()).setComparator(i, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					String s1 = o1.substring(0, 2), s2 = o2.substring(0, 2);
					String[] first = o1.substring(2, o1.length()).split("/");
					String[] second = o2.substring(2, o2.length()).split("/");
					String[] f1 = {s1, "", ""}, f2 = {s2, "", ""};
					for(int i = 0; i < first.length;i++) {
						f1[i+1] = first[i];
						f2[i+1] = second[i];
					}
					String temp = "";
					if(f1[1].length() == 1)	temp = "00";
					else if(f1[1].length() == 2)	temp = "0";
					f1[1] = temp + f1[1];
					temp = "";
					if(f2[1].length() == 1)	temp = "00";
					else if(f2[1].length() == 2)	temp = "0";
					f2[1] = temp + f2[1];
					int[] check = {0, 2, 1};
					for(int i : check)
						if(f1[i].compareTo(f2[i])!=0) 
							return f1[i].compareTo(f2[i]);
					return 0;
				}
			});
		table.setRowSorter(model.getSorter());
		/*
		table.getTableHeader().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = table.columnAtPoint(e.getPoint());
				System.out.println(col);
				
			}
		});
		*/
	}
	
	public void updateTable()
	{
		if(model != null)		model.fireTableDataChanged();
	}
	
	public String getSelectedKey()
	{ 
		int row = table.getSelectedRow(); 
		if(row == -1)	return null;
		return (String) table.getValueAt(row, KEY_COLUMN);
	}
	
	public static int getKeyColumn(){
		return KEY_COLUMN;
	}
}