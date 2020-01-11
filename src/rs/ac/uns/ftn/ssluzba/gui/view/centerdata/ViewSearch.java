package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.DefaultRowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;
import rs.ac.uns.ftn.ssluzba.gui.view.ToolBar;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteStudentFromPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.InvalidAction;

@SuppressWarnings("serial")
public class ViewSearch extends ViewTableCenter {

	private static ViewSearch instance = null;
	private int rootTab = -1;
	private int KEY_COLUMN; //sifra
	public static boolean updateInProgress = false;
	public static int[] DATE_COLUMNS = {};
	public static int[] INDEX_COLUMNS = {};
	
	private static class JTableButtonRenderer implements TableCellRenderer {        
        @Override 
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            return button;  
        }
    }
	
	private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row = e.getY()/table.getRowHeight();

            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if(value instanceof JButton) 
                    ((JButton)value).doClick();
            }
        }
    }
	
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
		if(tab==3) CenterBox.getInstance().setSelectedIndex(rootTab);
		CenterBox.getInstance().remove(instance);
		ViewStudenti.inSearchMode=false;
		ViewProfesori.inSearchMode=false;
		ViewPredmeti.inSearchMode=false;
		instance=null;
		CenterBox.redraw();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ViewSearch(int tab, int key, ThisTableModel<?> model) {
		rootTab=tab;
		KEY_COLUMN=key;
		updateInProgress = false;
		if(rootTab == 0) {
			DATE_COLUMNS = ViewStudenti.DATE_COLUMNS;
			INDEX_COLUMNS = ViewStudenti.INDEX_COLUMNS;
		}
		else if(rootTab == 1)	DATE_COLUMNS = ViewProfesori.DATE_COLUMNS;
		if(rootTab == 2) {
			model = new ThisTableModel<ListaPredmeta>((new ListaPredmeta(Data.getListaPredmeta())).mutableSearch(ToolBar.getSearchQuery())) {
				@Override
				public Class<?> getColumnClass(int columnIndex){
					if(columnIndex!=5) return super.getColumnClass(columnIndex);
					else 
						return JButton.class;
				}
				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					if(columnIndex!=5) return super.getValueAt(rowIndex, columnIndex);
					else {
						JButton button = new JButton("Prika\u017ei vi\u0161e");
						button.setToolTipText("Prika\u017ei studente");
						button.addActionListener(new ActionListener() {
	                        public void actionPerformed(ActionEvent arg0) {
	                        	String id = getSelectedKey();
	                        	if(id != null && Data.getListaPredmeta().getPredmet(id).getStudenti().isEmpty())		DeleteStudentFromPredmet.error(id);
	                			else if(id != null)		DeleteStudentFromPredmet.getInstance(id).setVisible(true);
	                			else if(id==null)	new InvalidAction("Niste izabrali predmet sa kojeg \u017eelite ukloniti studenta!");
	                        }
	                    });
						return button;
					}
				}
			};
			
			TableCellRenderer buttonRenderer = new JTableButtonRenderer();
			table.setModel(model);
			resizeColumnWidth();
			table.getColumn("Studenti").setCellRenderer(buttonRenderer);
			table.addMouseListener(new JTableButtonMouseListener(table));
		}
		else	table.setModel(model);
		resizeColumnWidth();
		if(rootTab == 0) {
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
		}
		else if(rootTab == 1) {
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
		}
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
		ViewSearch.removeInstance();
		ToolBar.getInstance().reSearch();
		updateInProgress = false;
	}
}
