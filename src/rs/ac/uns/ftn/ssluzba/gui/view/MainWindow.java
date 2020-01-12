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

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.resources.Resource;

/**
 * @author rammba fmaster
 * @implNote Main Window extends {@link JFrame}, singleton implementation, exit method for whole program
 */
@SuppressWarnings("serial")
public class MainWindow  extends JFrame {
	private static MainWindow instance = null;

	/**
	 * @implNote Constructor sets up Main Window with all its parts
	 */
	private MainWindow() {
		setTitle("Studentska Slu\u017eba");
		this.setJMenuBar(MenuBar.getInstance());
		ImageIcon img = new ImageIcon(Resource.get("student_32x32.jpg"));
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
		defaultPanel.setLayout(new BorderLayout());
		defaultPanel.add(ToolBar.getInstance(), BorderLayout.NORTH);
		defaultPanel.add(CenterBox.getInstance(),BorderLayout.CENTER);
		defaultPanel.add(StatusBar.getInstance(), BorderLayout.SOUTH);
		add(defaultPanel);
		//pack();
	}

	/**
	 * @return singleton instance
	 */
	public static MainWindow getInstance() {
		if(MainWindow.instance==null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}

	/**
	 * Proper full exit with data persistence optional
	 */
	public static void exit() {
		if(instance==null) return;
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Samo ga\u0161enje");
		UIManager.put("OptionPane.cancelButtonText", "Odustani");
		UIManager.put("OptionPane.yesButtonMnemonic", "68");
		UIManager.put("OptionPane.noButtonMnemonic", "83");
		UIManager.put("OptionPane.cancelButtonMnemonic", "79");
		int option = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Da li \u017eelite ugasiti aplikaciju i sa\u010duvati izmjene u bazu?", "Ga\u0161enje", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon(Resource.get("save-32.png")));
		if(option == JOptionPane.YES_OPTION ||  option == JOptionPane.NO_OPTION) {
			if(option == JOptionPane.YES_OPTION) Data.close();
			instance.setVisible(false);
			instance.dispose();
			instance = null;
			System.exit(0);
		}
	}
}