package gui.view;

import javax.swing.table.AbstractTableModel;

import gui.model.IAbstractTableModel;

@SuppressWarnings("serial")
class TableModel<T extends IAbstractTableModel> extends AbstractTableModel {
	T o;
	
	@SuppressWarnings("unchecked")
	public TableModel(Object o) {
		this.o=(T)o;
	}
	
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
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}
	
	@Override
	public String getColumnName(int col) {
		return o.getColumnName(col);
	}
}
