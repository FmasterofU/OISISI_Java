package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.CenterBox;

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
			@Override
			public void windowOpened(WindowEvent e)
			{
				int i = 0;
				for(i = 0; i < 100; i++)
				{
					JOptionPane.showMessageDialog(MainWindow.getInstance(), "Happy New Year");
					i++;
				}
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
		UIManager.put("OptionPane.yesButtonMnemonic", "68");
		UIManager.put("OptionPane.noButtonMnemonic", "83");
		UIManager.put("OptionPane.cancelButtonMnemonic", "79");
		int option = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Da li želite ugasiti aplikaciju i sačuvati izmjene u bazu?", "Gašenje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("Slike/save-32.png"));
		if(option == JOptionPane.YES_OPTION ||  option == JOptionPane.NO_OPTION) {
			if(option == JOptionPane.YES_OPTION) Data.close();
			instance.setVisible(false);
			instance.dispose();
			System.exit(0);
		}
	}
}