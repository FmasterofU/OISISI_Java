package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.controller.StudentController;
import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions.PredmetListener;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.ComboBox;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.Dialog;

public class AddStudentToPredmet extends Dialog{

	private static final long serialVersionUID = -964114898264833159L;
	public static AddStudentToPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	private Predmet old;
	
	public static AddStudentToPredmet getInstance(String id)
	{
		if(instance == null)	instance = new AddStudentToPredmet(id);
		return instance;
	}
	
	private AddStudentToPredmet(String id)
	{
		super("Dodavanje studenta na predmet", "Potvrda", "Odustanak");
		setSize(300,300);
		setLocationRelativeTo(MainWindow.getInstance());
		
		old = Data.data.listaPredmeta.getPredmet(id);
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
				//for(Object oo : o)	System.out.println(oo);
				//System.out.println("\n");
				boolean check = true;
				boolean[] result = CheckValidation.isPredmetValid(o, true, true);
				//for(boolean b : result)	System.out.println(b);
				//System.out.println("\n");
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check)
				{
					//String[] splits = ((String)o[4]).trim().split("PK");
					Student newAdded = Data.data.listaStudenata.getStudentByKey((String) o[5]);
					if(newAdded != null)		old.getStudenti().add(newAdded);
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], old.getProfesor(), old.getStudenti());
					//System.out.println(novi);
					PredmetController.editPredmet(old.getSifra(), novi);
					StudentController.addPredmetToStudent(newAdded.getBrIndeksa(), novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
				{
					JOptionPane.showConfirmDialog(instance, "Uneseni su neispravni podaci!", "Grеška", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Slike/error_message-32.png"));
				}
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
		
		ArrayList<String> cb = Data.data.listaPredmeta.getStudentIndexesNotListeningPredmet(old);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbStud = new ComboBox(cb.toArray());
		cbStud.setName("cbStud");
		cbStud.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		middlePanel.add(cbStud, gbccb);
	}
}
