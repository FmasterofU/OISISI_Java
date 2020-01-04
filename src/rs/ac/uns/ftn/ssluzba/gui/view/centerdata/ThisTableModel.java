package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.util.Vector;

import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.ssluzba.gui.model.ITableModel;

/**
 * @author fmaster
 * @param <T> - model type (list type)
 * @implNote Generalized {@link DefaultTableModel} for models implementing {@link ITableModel}
 * <h1>KNOWN ISSUE</h1>
 * <p>Since the overridden methods getColumnCount() and getRowCount() return 0 the first time they are called in super constructor, it seems that the size of internal {@link Vector} in {@link DefaultTableModel} never resets to values !=0 which causes problems with any functions that try to directly modify Table Model, such as removeRow(int row) method from {@link DefaultTableModel}. The tried fix in constructor of this class doesn't work. Good Luck!</p>
 */
@SuppressWarnings("serial")
public class ThisTableModel<T extends ITableModel> extends DefaultTableModel {
	
	protected T o;
	
	private RowSorter<DefaultTableModel> sorter = null;
	
	/**
	 * Construct Table model {@link DefaultTableModel} and setup recommended {@link RowSorter} - {@link TableRowSorter}
	 * @param o - data/list
	 */
	public ThisTableModel(T o) {
		//Doing some magic in order for base class to accept derived class field (technically creating a model twice)
		super();
		this.o=o;
		super.fireTableStructureChanged();
		super.fireTableDataChanged();
		//Turned out it doesn't work after all, further investigation to be done, possible error in java.swing.table.DefaultTableModel or in internal Vector implementation 
		sorter = new TableRowSorter<DefaultTableModel>(this);
	}
	
	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 * <h1>CAUSES PROBLEM - see ThisTableModel<h1>
	 * @see ThisTableModel
	 */
	@Override
	public int getColumnCount() {
		if(o==null) return 0;
		return o.getColumnCount();
	}

	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 * <h1>CAUSES PROBLEM - see ThisTableModel<h1>
	 * @see ThisTableModel
	 */
	@Override
	public int getRowCount() {
		if(o==null) return 0;
		return o.getRowCount();
	}

	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return o.getValueAt(rowIndex, columnIndex);
	}
	
	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}

	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 */
	@Override
	public String getColumnName(int col) {
		return o.getColumnName(col);
	}

	/**
	 * Overridden method from {@link DefaultTableModel} to work with {@link ThisTableModel} field <T> o
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (o.isEmpty()) {
			return Object.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}
	
	
	/**
	 * Get the default recommended sorter {@link TableRowSorter}
	 * @return field sorter
	 */
	public RowSorter<DefaultTableModel> getSorter(){
		return this.sorter;
	}
}
