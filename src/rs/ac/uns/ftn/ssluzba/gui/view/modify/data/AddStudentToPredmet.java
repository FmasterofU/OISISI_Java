package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.PredmetListener;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.ComboBox;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.Dialog;
import rs.ac.uns.ftn.ssluzba.resources.Resource;

/**
 * @author rammba
 * @implNote extends {@link Dialog}, singleton, in essence {@link JDialog} for adding Students to Subject
 */
@SuppressWarnings("serial")
public class AddStudentToPredmet extends Dialog{

	public static AddStudentToPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	private Predmet old;
	
	public static AddStudentToPredmet getInstance(String id)
	{
		if(instance == null)	instance = new AddStudentToPredmet(id);
		return instance;
	}
	
	public static void error(String id)
	{
		Predmet p = Data.getListaPredmeta().getPredmet(id);
		String message = "Ne postoje studenti sa " + p.getGodinaStudija().name() + " godine koji ne slu\u0161aju ovaj predmet!";
		JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(Resource.get("error_message-32.png")));
	}
	
	private AddStudentToPredmet(String id)
	{
		super("Dodavanje studenta na predmet", "Potvrda", "Odustanak");
		super.setSize(300,200);
		super.setLocationRelativeTo(MainWindow.getInstance());
		
		old = Data.getListaPredmeta().getPredmet(id);
		listener.setInitialData(old);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				instance.setVisible(false);
				instance = null;
				listener.clearData();
				System.gc();
			}
		});
		
		acceptButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				Object[] o = listener.getData();
				boolean check = true;
				if(o[6] == null)	check = false;
				boolean[] result = CheckValidation.isPredmetValid(o, true);
				for(int i=0;i<6;i++) {
					if(i == 4)	continue;	//not checking Profesor here
					if(result[i]==false) {
						check=false;
						break;
					}
				}
				if(check)
				{
					String temp = (String) o[5];
					temp += (String) o[6];
					ArrayList<Student> studenti = Data.getListaPredmeta().getStudents(temp);
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], old.getProfesor(), studenti);
					PredmetController.editPredmet(old.getSifra(), novi, ModelAction.ADD_S);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
					JOptionPane.showConfirmDialog(instance, "Uneseni su neispravni podaci!", "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(Resource.get("error_message-32.png")));
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				instance = null;
				listener.clearData();
				System.gc();
			}
		});
		
		JLabel lStud = new JLabel("Student:");
		
		GridBagConstraints gbclStud = generateLabelGBC();
		middlePanel.add(lStud, gbclStud);
		
		ArrayList<String> cb = Data.getListaPredmeta().getStudentIndexesNotListeningPredmet(old);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbStud = new ComboBox(cb.toArray());
		cbStud.setName("cbStud");
		cbStud.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		middlePanel.add(cbStud, gbccb);
	}
}
