package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;

@SuppressWarnings("serial")
public class ViewPredmeti extends ViewTableCenter {

	private static ViewPredmeti instance = null;
	private ThisTableModel<ListaPredmeta> model = null;
	static final int KEY_COLUMN = 0; //sifra predmeta
	static final int STUDENTI_BUTTON_COLUMN = 5; // kolona studenti
	
	public static ViewPredmeti getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return instance;
	}
	private ViewPredmeti() {
		model = new ThisTableModel<ListaPredmeta>(Data.data.listaPredmeta) {
			@Override
			public Class<?> getColumnClass(int columnIndex){
				if(columnIndex!=STUDENTI_BUTTON_COLUMN) return super.getColumnClass(columnIndex);
				else {
					//TODO -> just return JButton.class;
					return super.getColumnClass(columnIndex);
				}
			}
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				if(columnIndex!=STUDENTI_BUTTON_COLUMN) return super.getValueAt(rowIndex, columnIndex);
				else {
					//TODO -> return appropriate JButton
					return super.getValueAt(rowIndex, columnIndex);
				}
			}
		};
		table.setModel(model);
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
}