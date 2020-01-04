package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 * @author fmaster rammba
 * @implNote Concrete Table class in our use case, extending {@link JPanel} with {@link GridLayout} containing {@link JTable}.
 */
@SuppressWarnings("serial")
class ViewTableCenter extends JPanel {
	
	//protected JPanel panel;
	protected JTable table;
	
	/**
	 * Sets up everything written in Implementation Node of this class
	 * @see ViewTableCenter
	 */
	public ViewTableCenter() {
		super();
		this.setLayout(new GridLayout());
		this.setMaximumSize(this.getSize());
        table = new JTable() {
        	@Override
        	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        		Component c = super.prepareRenderer(renderer, row, column);
        		if (isRowSelected(row)) {
        			c.setBackground(Color.LIGHT_GRAY);
        		} else {
        			c.setBackground(Color.WHITE);
        		}
        		return c;
        	}
        };
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
                JComponent c = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
                c.setToolTipText(value.toString());
                return c;
                }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setFont(new Font("Dialog", Font.PLAIN, 13));
		//table.getTableHeader().setPreferredSize(new Dimension(CenterBox.getInstance().getWidth(), table.getTableHeader().getSize().height+table.getTableHeader().getFont().getSize()-12)); //12 default font size
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
		table.setRowHeight(table.getRowHeight()+table.getFont().getSize()-12); //12 default font size
        JScrollPane tableContainer = new JScrollPane(table);
        this.add(tableContainer);
	}
	
	/**
	 * @implNote still testing this feature, supposed to replace setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS)
	 */
	public void resizeColumnWidth() {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column=0; column<table.getColumnCount(); column++) {
	        int width=20; // Min width 30 back then
	        for (int row=0; row<table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width+1 , width);
	        }
	        if(width>300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	}
}
