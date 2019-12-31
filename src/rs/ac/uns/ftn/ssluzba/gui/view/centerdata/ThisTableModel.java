package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.ssluzba.gui.model.ITableModel;

@SuppressWarnings("serial")
class ThisTableModel<T extends ITableModel> {
	
	protected T o;
	private DefaultTableModel dtm = null;
	private RowSorter<DefaultTableModel> sorter = null;
	
	public ThisTableModel(T o) {
		this.o=o;
		dtm = new DefaultTableModel(){

			@Override
			public int getColumnCount() {
				return o.getColumnCount();
			}

			@Override
			public int getRowCount() {
				return o.getRowCount();
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return o.getValueAt(rowIndex, columnIndex);
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex){
				return false;
			}
	
			@Override
			public String getColumnName(int col) {
				return o.getColumnName(col);
			}
	
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (o.isEmpty()) {
					return Object.class;
				}
				return getValueAt(0, columnIndex).getClass();
			}
		};
		sorter = new TableRowSorter<DefaultTableModel>(dtm);
	}
	
	public DefaultTableModel getModel() {
		return this.dtm;
	}
	
	public RowSorter<DefaultTableModel> getSorter(){
		return this.sorter;
	}
}
