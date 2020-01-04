package rs.ac.uns.ftn.ssluzba.gui.model;

import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ThisTableModel;

/**
 * @author fmaster
 * @implNote any model data structure needs to follow this interface (implement these methods) in order to be acceptable for {@link ThisTableModel}
 */
public interface ITableModel {
	public int getColumnCount();
	public int getRowCount();
	public Object getValueAt(int rowIndex, int columnIndex);
	public String getColumnName(int col);
	public boolean isEmpty();
}
