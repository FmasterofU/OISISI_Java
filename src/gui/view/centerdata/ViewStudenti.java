package gui.view.centerdata;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui.model.Data;
import gui.model.ListaStudenata;

public class ViewStudenti extends ViewTableCenter {
	
	private static final long serialVersionUID = -4008708277153917046L;
	private static ViewStudenti instance = null;
	private ThisTableModel<ListaStudenata> model = null;
	public static ViewStudenti getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return instance;
	}
	private ViewStudenti() {
		model = new ThisTableModel<ListaStudenata>(Data.data.listaStudenata);
		table.setModel(model);
		resizeColumnWidth();
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
				int col = table.columnAtPoint(e.getPoint());
				System.out.println(col);
				
			}
		});
	}
	
	public void updateTable()
	{
		if(model != null)		model.fireTableDataChanged();
	}
	
	public int getSelectedIndex()		{ return table.getSelectedRow(); }
}