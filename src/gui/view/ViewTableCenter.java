package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
class ViewTableCenter extends JPanel {
	
	protected JPanel panel;
	protected JTable table;
	
	public ViewTableCenter() {
		super();
		setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new GridLayout());
		panel.setMaximumSize(this.getSize());
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
        table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane tableContainer = new JScrollPane(table);
        panel.add(tableContainer);
        add(new JScrollPane(this.panel), BorderLayout.CENTER);
	}
	
	public void resizeColumnWidth() {
	    final TableColumnModel columnModel = table.getColumnModel();
	    for (int column=0; column<table.getColumnCount(); column++) {
	        int width=30; // Min width
	        for (int row=0; row<table.getRowCount(); row++) {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width+1 , width);
	        }
	        if(width>300)
	            width=300;
	        columnModel.getColumn(column).setPreferredWidth(width);
	        
	    }
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
}
