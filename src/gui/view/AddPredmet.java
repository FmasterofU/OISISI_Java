package gui.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import gui.controller.CheckValidation;
import gui.controller.PredmetController;
import gui.model.Predmet;
import gui.model.Profesor;
import gui.model.Student;
import listeners_and_actions.PredmetListener;
import persistence.Data;

@SuppressWarnings("serial")
public class AddPredmet extends Dialog {

	private static AddPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	
	public static AddPredmet getInstance() {
		if(instance == null) instance = new AddPredmet();
		return instance;
	}
	
	public AddPredmet() {
		super("Dodavanje predmeta", "Potvrda", "Odustanak");
		setSize(400,350);
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
				boolean[] result = CheckValidation.isPredmetValid(o);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check)
				{
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Byte)o[2], (Byte)o[3], (Profesor)o[4], new ArrayList<Student>());
					PredmetController.getInstance().dodajPredmet(novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
				{
					UIManager.put("OptionPane.cancelButtonText", "Dobro");
					JOptionPane.showConfirmDialog(instance, "Pogrešni podaci!", "Grеška", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
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
		
		JLabel lSifra = new MandatoryTextFieldLabel("Šifra:");
		JLabel lNaziv = new MandatoryTextFieldLabel("Naziv:");
		JLabel lSemestar = new MandatoryTextFieldLabel("Semestar:");
		JLabel lGodina = new MandatoryTextFieldLabel("Godina:");
		JLabel lProfesor = new MandatoryTextFieldLabel("Profesor:");
		JLabel lStudenti = new MandatoryTextFieldLabel("Studenti:");
		

		GridBagConstraints gbclSifra = generateLabelGBC();
		middlePanel.add(lSifra, gbclSifra);
		
		JTextField tfSifra = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkUniquePredmetCode(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfSifra.setName("tfSifra");
		//tfime.setBackground(Color.WHITE);
		tfSifra.addFocusListener(listener);
		
		GridBagConstraints gbctfSifra = generateTextFieldGBC();
		middlePanel.add(tfSifra, gbctfSifra);
		

		GridBagConstraints gbclNaziv = generateLabelGBC();
		middlePanel.add(lNaziv, gbclNaziv);
		
		JTextField tfNaziv = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkName(this.getText(),2)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfNaziv.setName("tfNaziv");
		//tfime.setBackground(Color.WHITE);
		tfNaziv.addFocusListener(listener);
		
		GridBagConstraints gbctfNaziv = generateTextFieldGBC();
		middlePanel.add(tfNaziv, gbctfNaziv);
		
		
		GridBagConstraints gbclSemestar = generateLabelGBC();
		middlePanel.add(lSemestar, gbclSemestar);
		
		String[] cbItems1 = {"I (prvi)", "II (drugi)", "III (treći)", "IV (četvrti)", "V (peti)", "VI (šesti)", "VII (sedmi)", "VIII (osmi)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbSemestar = new JComboBox(cbItems1);
		cbSemestar.addItemListener(listener);
		GridBagConstraints gbccb1 = generateTextFieldGBC();
		middlePanel.add(cbSemestar, gbccb1);
		
		
		GridBagConstraints gbclGodina = generateLabelGBC();
		middlePanel.add(lGodina, gbclGodina);
		
		String[] cbItems2 = {"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbGodina = new JComboBox(cbItems2);
		cbGodina.addItemListener(listener);
		GridBagConstraints gbccb2 = generateTextFieldGBC();
		middlePanel.add(cbGodina, gbccb2);
		
		GridBagConstraints gbclProfesor = generateLabelGBC();
		middlePanel.add(lProfesor, gbclProfesor);
		
		ArrayList<String> cbItems3 = Data.data.listaProfesora.getUniqueProfList();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbProfesor = new JComboBox(cbItems3.toArray());
		cbProfesor.addItemListener(listener);
		GridBagConstraints gbccb3 = generateTextFieldGBC();
		middlePanel.add(cbProfesor, gbccb3);
		
		GridBagConstraints gbclStudenti = generateLabelGBC();
		middlePanel.add(lStudenti, gbclStudenti);
	}

}
