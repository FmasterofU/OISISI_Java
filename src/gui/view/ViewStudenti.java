package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import gui.model.ListaStudenata;

class ViewStudenti extends JPanel {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static Component instance = null;
	private JTable tabela;
	public static Component getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return (Component) instance;
	}
	private ViewStudenti() 
	{
		this.setLayout(new BorderLayout());
		tabela = new TabelaStudenata();
		JScrollPane scroll = new JScrollPane(tabela);
		this.add(scroll, BorderLayout.CENTER);
	}
	
	private class TabelaStudenata extends JTable {

		private static final long serialVersionUID = 8900651367165240112L;

		@SuppressWarnings("serial")
		private TabelaStudenata() {
			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setModel(new AbstractTableModel() {
				
				@Override
				public int getColumnCount() {
					return ListaStudenata.getInstance().getColumnCount();
				}

				@Override
				public int getRowCount() {
					return ListaStudenata.getInstance().getRowCount();
				}

				@Override
				public Object getValueAt(int rowIndex, int columnIndex) {
					return ListaStudenata.getInstance().getValueAt(rowIndex, columnIndex);
				}
				
				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex)
				{
					return false;
				}
				
				@Override
				public String getColumnName(int col) {
					return ListaStudenata.getInstance().getColumnName(col);
				}
			});
		}
		
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
	}
	public int getSelectedIndex()
	{
		return tabela.getSelectedRow();
	}
}