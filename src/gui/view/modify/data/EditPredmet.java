package gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import gui.controller.CheckValidation;
import gui.controller.PredmetController;
import gui.model.Data;
import gui.model.GodinaStudija;
import gui.model.Predmet;
import gui.model.Profesor;
import gui.model.Semestar;
import gui.model.Student;
import gui.view.MainWindow;
import gui.view.modify.ComboBox;
import gui.view.modify.Dialog;
import gui.view.modify.IHighlight;
import gui.view.modify.MandatoryTextFieldLabel;
import gui.view.modify.TextField;
import listeners_and_actions.PredmetListener;

@SuppressWarnings("serial")
public class EditPredmet extends Dialog {
	
	private static EditPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	Predmet current;
	
	public static EditPredmet getInstance(String idx)
	{
		if(instance == null) instance = new EditPredmet(idx);
		return instance;
	}
	
	private EditPredmet(String sifra) {
		super("Izmeni predmet", "Potvrda", "Odustanak");
		setSize(400,300);
		setLocationRelativeTo(MainWindow.getInstance());
		current = Data.data.listaPredmeta.getPredmet(sifra);
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
					@SuppressWarnings("unchecked")
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], (Profesor)o[4], (ArrayList<Student>) o[5]);
					PredmetController.editPredmet((String) o[0], novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
				{
					UIManager.put("OptionPane.cancelButtonText", "Dobro");
					JOptionPane.showConfirmDialog(instance, "Uneseni su neispravni podaci!", "Grеška", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Slike/error_message-32.png"));
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
		JLabel lSemestar = new JLabel("Semestar:");
		JLabel lGodina = new JLabel("Godina:");
		

		GridBagConstraints gbclSifra = generateLabelGBC();
		middlePanel.add(lSifra, gbclSifra);
		
		JTextField tfSifra = new TextField(current.getSifra()) {
			@Override
			public void maybeHighlight() {
				setBorder((((CheckValidation.checkUniquePredmetCode(this.getText())) && CheckValidation.checkName(this.getText(), 1)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfSifra.setName("tfSifra");
		tfSifra.setEditable(false);
		//tfime.setBackground(Color.WHITE);
		tfSifra.addFocusListener(listener);
		
		GridBagConstraints gbctfSifra = generateTextFieldGBC();
		middlePanel.add(tfSifra, gbctfSifra);
		

		GridBagConstraints gbclNaziv = generateLabelGBC();
		middlePanel.add(lNaziv, gbclNaziv);
		
		JTextField tfNaziv = new TextField(current.getNaziv()) {
			@Override
			public void maybeHighlight() {
				setBorder((((CheckValidation.checkUniquePredmetCode(this.getText())) && CheckValidation.checkName(this.getText(), 2)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfNaziv.setName("tfNaziv");
		//tfime.setBackground(Color.WHITE);
		tfNaziv.addFocusListener(listener);
		
		GridBagConstraints gbctfNaziv = generateTextFieldGBC();
		middlePanel.add(tfNaziv, gbctfNaziv);
		
		
		GridBagConstraints gbclSemestar = generateLabelGBC();
		middlePanel.add(lSemestar, gbclSemestar);
		
		String[] cbItems1 = {Semestar.ZIMSKI.name(), Semestar.LJETNJI.name()};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbSemestar = new ComboBox(cbItems1);
		cbSemestar.setName("cbSemestar");
		cbSemestar.setSelectedIndex(current.getSemestar().ordinal());
		cbSemestar.addItemListener(listener);
		GridBagConstraints gbccb1 = generateTextFieldGBC();
		middlePanel.add(cbSemestar, gbccb1);
		
		
		GridBagConstraints gbclGodina = generateLabelGBC();
		middlePanel.add(lGodina, gbclGodina);
		
		String[] cbItems2 = {GodinaStudija.I.name(), GodinaStudija.II.name(), GodinaStudija.III.name(), GodinaStudija.IV.name()}; //{"I (prva)", "II (druga)", "III (treća)", "IV (četvrta)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbGodina = new ComboBox(cbItems2);
		cbGodina.setName("cbGodina");
		cbGodina.setSelectedIndex(current.getGodinaStudija().ordinal());
		cbGodina.addItemListener(listener);
		GridBagConstraints gbccb2 = generateTextFieldGBC();
		middlePanel.add(cbGodina, gbccb2);
	}
}
