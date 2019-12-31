package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.CenterBox;

@SuppressWarnings("serial")
class StatusBar extends JPanel implements ActionListener{
	private static StatusBar instance = null;
	public static StatusBar getInstance() {
		if(instance==null) instance = new StatusBar();
		return instance;
	}
	private JLabel date = new JLabel();
	SimpleDateFormat dateFormat = new SimpleDateFormat( "E  HH:mm:ss  dd.MM.yyyy." );
	private StatusBar() 
	{
		JLabel name = new JLabel("Studentska Služba");
	    date = new JLabel(dateFormat.format(new GregorianCalendar().getTime()));
	    Timer timer = new Timer(1000, this);
	    timer.start();
	    BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(box);
		this.add(Box.createHorizontalStrut(10));
		this.add(name);
		this.add(Box.createGlue());
		this.add(date);
		this.add(Box.createHorizontalStrut(10));
		this.setBackground(CenterBox.getInstance().getBackground()); //light blue, same as inactive tab color in centerbox
	    this.setSize(100, 100);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		date.setText(dateFormat.format(new GregorianCalendar().getTime()));
	}
}
