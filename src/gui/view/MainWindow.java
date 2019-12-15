package gui.view;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import persistence.Data;

@SuppressWarnings("serial")
public class MainWindow  extends JFrame {
	public MainWindow() {
		setTitle("Studentska Služba");
		ImageIcon img = new ImageIcon("Slike/student_32x32.jpg");
		setIconImage(img.getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4, Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//hide on close with data.close
		MainWindow mw = this;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				Data.close();
				mw.setVisible(false);
				mw.dispose();
			}
		});
	}
}
