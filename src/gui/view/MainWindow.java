package gui.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import gui.model.Data;
import gui.view.centerdata.CenterBox;

@SuppressWarnings("serial")
public class MainWindow  extends JFrame {
	private static MainWindow instance = null;
	
	private MainWindow() {
		setTitle("Studentska Služba");
		this.setJMenuBar(MenuBar.getInstance());
		ImageIcon img = new ImageIcon("Slike/student_32x32.jpg");
		setIconImage(img.getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4, Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				MainWindow.exit();
				}
			});
		JPanel defaultPanel = new JPanel();
		//BoxLayout vBox = new BoxLayout(defaultPanel, BoxLayout.Y_AXIS);
		defaultPanel.setLayout(new BorderLayout());
		defaultPanel.add(ToolBar.getInstance(), BorderLayout.NORTH);
		defaultPanel.add(CenterBox.getInstance(),BorderLayout.CENTER);
		defaultPanel.add(StatusBar.getInstance(), BorderLayout.SOUTH);
		add(defaultPanel);
		//pack();
	}
	
	public static MainWindow getInstance() {
		if(MainWindow.instance==null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}
	
	public static void exit() {
		if(instance==null) return;
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Samo gašenje");
		UIManager.put("OptionPane.cancelButtonText", "Odustani");
		int option = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Da li želite ugasiti aplikaciju i sačuvati izmjene u bazu?", "Gašenje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(option == JOptionPane.YES_OPTION ||  option == JOptionPane.NO_OPTION) {
			if(option == JOptionPane.YES_OPTION) Data.close();
			instance.setVisible(false);
			instance.dispose();
			System.exit(0);
		}
	}
}