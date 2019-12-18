package gui.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
class ViewTableCenter extends JPanel {
	
	protected JTable table;
	
	public ViewTableCenter() {
		setLayout(new GridBagLayout());
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
        table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane tableContainer = new JScrollPane(table);
        add(tableContainer);
	}

}
