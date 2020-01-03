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

public class DeleteStudentFromPredmet extends Dialog{

	private static final long serialVersionUID = -4858530922189597657L;
	private PredmetListener listener = new PredmetListener();
	private Predmet old;
	public static DeleteStudentFromPredmet instance = null;
	
	public static DeleteStudentFromPredmet getInstance(String id)
	{
		if(instance == null)	instance = new DeleteStudentFromPredmet(id);
		return instance;
	}
	
	public static void error(String id)
	{
		//Predmet p = Data.getListaPredmeta().getPredmet(id);
		String message = "Ne postoje studenti koji slu\u0161aju ovaj predmet!";
		JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Slike/error_message-32.png"));
	}
	
	private DeleteStudentFromPredmet(String id)
	{
		super("Brisanje studenta sa predmeta", "Potvrda", "Odustanak");
		
		old = Data.getListaPredmeta().getPredmet(id);
		setSize(300,300);
		setLocationRelativeTo(MainWindow.getInstance());
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
//					Student deleting = Data.data.listaStudenata.getStudentByKey((String) o[5]);
//					if(deleting != null)		old.getStudenti().remove(deleting);
					String temp = (String) o[5], ret = "";
					String[] splits = temp.split(" ");
					for(String spl : splits) {
						if(!spl.equals((String) o[6]))
								ret += spl + " ";
					}
					ArrayList<Student> studenti = Data.getListaPredmeta().getStudents(ret);
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], old.getProfesor(), studenti);
					PredmetController.editPredmet(old.getSifra(), novi, ModelAction.DELETE_S);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
					JOptionPane.showConfirmDialog(instance, "Uneseni su neispravni podaci!", "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Slike/error_message-32.png"));
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
		
		ArrayList<String> cb = Data.getListaPredmeta().getStudentIndexesListeningPredmet(old);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbStud = new ComboBox(cb.toArray());
		cbStud.setName("cbStud");
		cbStud.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		middlePanel.add(cbStud, gbccb);
	}

}
