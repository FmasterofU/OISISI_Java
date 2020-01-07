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
import javax.swing.JTextField;

import resources.Resource;
import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.PredmetListener;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.ComboBox;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.Dialog;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.IHighlight;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.MandatoryTextFieldLabel;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.TextField;

/**
 * @author fmaster
 * @implNote extends {@link Dialog}, singleton, in essence JDialog for adding Subjects
 */
@SuppressWarnings("serial")
public class AddPredmet extends Dialog {

	private static AddPredmet instance = null;
	private PredmetListener listener = new PredmetListener();
	
	public static AddPredmet getInstance() {
		if(instance == null) instance = new AddPredmet();
		return instance;
	}
	
	private AddPredmet() {
		super("Dodavanje predmeta", "Potvrda", "Odustanak");
		setSize(400,300);
		setLocationRelativeTo(MainWindow.getInstance());
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
				boolean[] result = CheckValidation.isPredmetValid(o, false);
				for(int i=0;i<4;i++) // samo su o[0..3] obavezni za add
					if(result[i]==false) {
						check=false;
						break;
					}
				if(check){
					Predmet novi = new Predmet((String)o[0], (String)o[1], (Semestar)o[2], (GodinaStudija)o[3], null, new ArrayList<Student>());
					PredmetController.addPredmet(novi);
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
		
		JLabel lSifra = new MandatoryTextFieldLabel("\u0160ifra:");
		JLabel lNaziv = new MandatoryTextFieldLabel("Naziv:");
		JLabel lSemestar = new JLabel("Semestar:");
		JLabel lGodina = new JLabel("Godina:");
		

		GridBagConstraints gbclSifra = generateLabelGBC();
		middlePanel.add(lSifra, gbclSifra);
		
		JTextField tfSifra = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder((((CheckValidation.checkUniquePredmetCode(this.getText())) && CheckValidation.checkName(this.getText(), 1)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfSifra.setName("tfSifra");
		tfSifra.addFocusListener(listener);
		
		GridBagConstraints gbctfSifra = generateTextFieldGBC();
		middlePanel.add(tfSifra, gbctfSifra);
		

		GridBagConstraints gbclNaziv = generateLabelGBC();
		middlePanel.add(lNaziv, gbclNaziv);
		
		JTextField tfNaziv = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder((((CheckValidation.checkUniquePredmetCode(this.getText())) && CheckValidation.checkName(this.getText(), 2)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfNaziv.setName("tfNaziv");
		tfNaziv.addFocusListener(listener);
		
		GridBagConstraints gbctfNaziv = generateTextFieldGBC();
		middlePanel.add(tfNaziv, gbctfNaziv);
		
		
		GridBagConstraints gbclSemestar = generateLabelGBC();
		middlePanel.add(lSemestar, gbclSemestar);
		
		String[] cbItems1 = {Semestar.ZIMSKI.name(), Semestar.LJETNJI.name()};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbSemestar = new ComboBox(cbItems1);
		cbSemestar.setName("cbSemestar");
		cbSemestar.addItemListener(listener);
		GridBagConstraints gbccb1 = generateTextFieldGBC();
		middlePanel.add(cbSemestar, gbccb1);
		
		
		GridBagConstraints gbclGodina = generateLabelGBC();
		middlePanel.add(lGodina, gbclGodina);
		
		String[] cbItems2 = {GodinaStudija.I.name(), GodinaStudija.II.name(), GodinaStudija.III.name(), GodinaStudija.IV.name()};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbGodina = new ComboBox(cbItems2);
		cbGodina.setName("cbGodina");
		cbGodina.addItemListener(listener);
		GridBagConstraints gbccb2 = generateTextFieldGBC();
		middlePanel.add(cbGodina, gbccb2);
		
	}

}
