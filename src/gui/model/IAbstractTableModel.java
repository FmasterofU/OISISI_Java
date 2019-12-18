package gui.model;

public interface IAbstractTableModel {
	public int getColumnCount();
	public int getRowCount();
	public Object getValueAt(int rowIndex, int columnIndex);
	public String getColumnName(int col);
}
