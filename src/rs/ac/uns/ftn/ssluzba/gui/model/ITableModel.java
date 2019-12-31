package rs.ac.uns.ftn.ssluzba.gui.model;

public interface ITableModel {
	public int getColumnCount();
	public int getRowCount();
	public Object getValueAt(int rowIndex, int columnIndex);
	public String getColumnName(int col);
	public boolean isEmpty();
}
