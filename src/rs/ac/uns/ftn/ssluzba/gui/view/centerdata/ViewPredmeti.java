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
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteStudentFromPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.InvalidAction;

/**
 * @author fmaster rammba
 * @implNote Predmeti tab in {@link CenterBox}, singleton, extends {@link ViewTableCenter}
 */
@SuppressWarnings("serial")
public class ViewPredmeti extends ViewTableCenter {

	private static ViewPredmeti instance = null;
	private ThisTableModel<ListaPredmeta> model = null;
	private static final int KEY_COLUMN = 0; //sifra predmeta
	static final int STUDENTI_BUTTON_COLUMN = 5; // kolona studenti
	public static boolean inSearchMode = false;
	public static final int[] SEARCH_COLUMNS = {0, 1, 2, 3};
	
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
	
	public static ViewPredmeti getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return instance;
	}
	private ViewPredmeti() {
		model = new ThisTableModel<ListaPredmeta>(Data.getListaPredmeta()) {
			@Override
			public Class<?> getColumnClass(int columnIndex){
				if(columnIndex!=STUDENTI_BUTTON_COLUMN) return super.getColumnClass(columnIndex);
				else {
					return JButton.class;
				}
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				if(columnIndex!=STUDENTI_BUTTON_COLUMN) return super.getValueAt(rowIndex, columnIndex);
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
		table.getColumn("Studenti").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		resizeColumnWidth();
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