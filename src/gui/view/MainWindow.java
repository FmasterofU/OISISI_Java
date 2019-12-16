package gui.view;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import persistence.Data;

@SuppressWarnings("serial")
public class MainWindow  extends JFrame {
	private static MainWindow instance = null;
	
	private MainWindow() {
		setTitle("Studentska Služba");
		this.setJMenuBar(MyMenuBar.getInstance());
		ImageIcon img = new ImageIcon("Slike/student_32x32.jpg");
		setIconImage(img.getImage());
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4, Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				if(!MainWindow.exit()) System.exit(0);
			}
		});
		JPanel defaultPanel = new JPanel();
		BoxLayout vBox = new BoxLayout(defaultPanel, BoxLayout.Y_AXIS);
		defaultPanel.setLayout(vBox);
		//defaultPanel.add(MenuBar.getInstance());
		//defaultPanel.add(ToolBar.getInstance());
		//defaultPanel.add(CenterBox.getInstance());
		//defaultPanel.add(StatusBar.getInstance());
		add(defaultPanel);
		//pack();
	}
	
	public static MainWindow getInstance() {
		if(MainWindow.instance==null) MainWindow.instance = new MainWindow();
		return MainWindow.instance;
	}
	
	public static boolean exit() {
		if(instance==null) return false;
		else {
			UIManager.put("OptionPane.yesButtonText", "Da");
			UIManager.put("OptionPane.noButtonText", "Ne");
			int option = JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Da li želite ugasiti aplikaciju?", "Gašenje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(option == JOptionPane.YES_OPTION)
			{
				Data.close();
				instance.setVisible(false);
				instance.dispose();
			}
			return true;
		}
	}
}
