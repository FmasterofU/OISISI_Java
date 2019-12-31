package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;

public class ViewStudenti extends ViewTableCenter {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static ViewStudenti instance = null;
	private ThisTableModel<ListaStudenata> genModel = null;
	static final int KEY_COLUMN = 0;
	
	public static ViewStudenti getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return instance;
	}
	private ViewStudenti() {
		genModel = new ThisTableModel<ListaStudenata>(Data.data.listaStudenata);
		table.setModel(genModel.getModel());
		resizeColumnWidth();
		table.setRowSorter(genModel.getSorter());
		/*
		table.getTableHeader().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				/*int col = table.columnAtPoint(e.getPoint());
				System.out.println(col);*/
				
			//}
		//});*/
	}
	
	public void updateTable()
	{
		if(genModel.getModel() != null)		genModel.getModel().fireTableDataChanged();
	}
	
	public String getSelectedKey()
	{ 
		int row = table.getSelectedRow(); 
		if(row == -1)	return null;
		return (String) table.getValueAt(row, KEY_COLUMN);
	}
}