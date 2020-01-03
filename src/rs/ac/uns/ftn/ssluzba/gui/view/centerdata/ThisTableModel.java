package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.ssluzba.gui.model.ITableModel;

@SuppressWarnings("serial")
public class ThisTableModel<T extends ITableModel> extends DefaultTableModel {
	
	protected T o;
	
	private RowSorter<DefaultTableModel> sorter = null;
	
	public ThisTableModel(T o) {
		//Doing some magic in order for base class to accept derived class field (technically creating a model twice)
		super();
		this.o=o;
		super.fireTableStructureChanged();
		super.fireTableDataChanged();
		sorter = new TableRowSorter<DefaultTableModel>(this);
	}
	
	@Override
	public int getColumnCount() {
		if(o==null) return 0;
		return o.getColumnCount();
	}

	@Override
	public int getRowCount() {
		if(o==null) return 0;
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
	
	public RowSorter<DefaultTableModel> getSorter(){
		return this.sorter;
	}
}
