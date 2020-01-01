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
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions.PredmetListener;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.ComboBox;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.Dialog;

@SuppressWarnings("serial")
public class AddProfesorToPredmet extends Dialog {
	
	private static AddProfesorToPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	Predmet current;
	
	public static AddProfesorToPredmet getInstance(String code) {
		if(instance == null) instance = new AddProfesorToPredmet(code);
		return instance;
	}
	
	private AddProfesorToPredmet(String code) {
		super("Dodavanje profesora na predmet", "Potvrda", "Odustanak");
		setSize(400,300);
		setLocationRelativeTo(MainWindow.getInstance());
		current = Data.data.listaPredmeta.getPredmet(code);
		listener.setInitialData(current);
		
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
				boolean[] result = CheckValidation.isPredmetValid(o, true);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check)
				{
					String[] splits = ((String)o[4]).trim().split("PK");
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], Data.data.listaProfesora.getProfesor(splits[splits.length-1]), new ArrayList<Student>());
					PredmetController.editPredmet((String)o[0],novi,ModelAction.ADD_P);
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

		

		JLabel lProfesor = new JLabel("Profesor:");
		
		GridBagConstraints gbclProfesor = generateLabelGBC();
		middlePanel.add(lProfesor, gbclProfesor);
		
		ArrayList<String> cbItems3 = Data.data.listaProfesora.getUniqueProfList();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbProfesor = new ComboBox(cbItems3.toArray());
		cbProfesor.setName("cbProfesor");
		cbProfesor.addItemListener(listener);
		GridBagConstraints gbccb3 = generateTextFieldGBC();
		middlePanel.add(cbProfesor, gbccb3);
	}
}
