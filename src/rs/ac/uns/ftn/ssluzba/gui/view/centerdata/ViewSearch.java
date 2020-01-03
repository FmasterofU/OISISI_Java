package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
			table.getColumn("Studenti").setCellRenderer(buttonRenderer);
			table.addMouseListener(new JTableButtonMouseListener(table));
		}
		else	table.setModel(model);
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
