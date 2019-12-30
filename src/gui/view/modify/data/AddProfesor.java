package gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.controller.CheckValidation;
import gui.controller.ProfesorController;
import gui.model.Profesor;
import gui.view.modify.Dialog;
import gui.view.modify.IHighlight;
import gui.view.modify.MandatoryTextFieldLabel;
import gui.view.modify.TextField;
import listeners_and_actions.ProfesorListener;

public class AddProfesor extends Dialog{

	private static final long serialVersionUID = 7179064377953039177L;
	private static AddProfesor instance = null;
	private ProfesorListener listener = new ProfesorListener();
	
	public static AddProfesor getInstance()
	{
		if(instance == null)	instance = new AddProfesor();
		return instance;
	}
	
	@SuppressWarnings("serial")
	private AddProfesor()
	{
		super("Dodavanje profesora", "Potvrda", "Odustanak");
		
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
				Object[] s = listener.getData();
				boolean check = true;
				boolean[] result = CheckValidation.isProfesorValid(s,false);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check){
					Profesor novi = new Profesor((String) s[0], (String) s[1], (String) s[2], (String) s[3], (String) s[4], (String) s[5], (String) s[6], (String) s[7], (String) s[8], (String) s[9]);
					ProfesorController.addProfesor(novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				} else
					JOptionPane.showConfirmDialog(instance, "Uneseni su neispravni podaci!", "Grеška", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
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
		
		JLabel lime = new MandatoryTextFieldLabel("Ime:");
		JLabel lprez = new MandatoryTextFieldLabel("Prezime:");
		JLabel ldatr = new MandatoryTextFieldLabel("Datum rođenja:");
		JLabel ladrs = new MandatoryTextFieldLabel("Adresa stanovanja:");
		JLabel ltel = new MandatoryTextFieldLabel("Broj telefona:");
		JLabel lmail = new MandatoryTextFieldLabel("eMail:");
		JLabel ladrk = new MandatoryTextFieldLabel("Adresa kancelarije:");
		JLabel llk = new MandatoryTextFieldLabel("Broj lične karte:");
		JLabel ltit = new MandatoryTextFieldLabel("Titula:");
		JLabel lzvanje = new MandatoryTextFieldLabel("Zvanje:");
		
		GridBagConstraints gbclime = generateLabelGBC();
		middlePanel.add(lime, gbclime);
		
		JTextField tfime = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkName(this.getText(),0)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfime.setName("tfime");
		tfime.addFocusListener(listener);
		
		GridBagConstraints gbctfime = generateTextFieldGBC();
		middlePanel.add(tfime, gbctfime);
		
		GridBagConstraints gbclprez = generateLabelGBC();
		middlePanel.add(lprez, gbclprez);
		
		JTextField tfprez = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkName(this.getText(),0)) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfprez.setName("tfprez");
		tfprez.addFocusListener(listener);
		
		GridBagConstraints gbctfprez = generateTextFieldGBC();
		middlePanel.add(tfprez, gbctfprez);
		
		ldatr.setToolTipText("dd.MM.yyyy.");
		GridBagConstraints gbcldatr = generateLabelGBC();
		middlePanel.add(ldatr, gbcldatr);
		
		JTextField tfdatr = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkDate(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfdatr.setName("tfdatr");
		tfdatr.addFocusListener(listener);
		
		GridBagConstraints gbctfdatr = generateTextFieldGBC();
		middlePanel.add(tfdatr, gbctfdatr);
		
		GridBagConstraints gbcladr = generateLabelGBC();
		middlePanel.add(ladrs, gbcladr);
		
		JTextField tfadrs = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkAdress(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfadrs.setName("tfadrs");
		tfadrs.addFocusListener(listener);
		
		GridBagConstraints gbctfadrs = generateTextFieldGBC();
		middlePanel.add(tfadrs, gbctfadrs);
		
		GridBagConstraints gbcltel = generateLabelGBC();
		middlePanel.add(ltel, gbcltel);
		
		JTextField tftel = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkPhoneNumber(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tftel.setName("tftel");
		tftel.addFocusListener(listener);
		
		GridBagConstraints gbctftel = generateTextFieldGBC();
		middlePanel.add(tftel, gbctftel);
		
		GridBagConstraints gbclmail = generateLabelGBC();
		middlePanel.add(lmail, gbclmail);
		
		JTextField tfmail = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkMail(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfmail.setName("tfmail");
		tfmail.addFocusListener(listener);
		
		GridBagConstraints gbctfmail = generateTextFieldGBC();
		middlePanel.add(tfmail, gbctfmail);
		
		GridBagConstraints gbcladrk = generateLabelGBC();
		middlePanel.add(ladrk, gbcladrk);
		
		JTextField tfadrk = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkAdress(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfadrk.setName("tfadrk");
		tfadrk.addFocusListener(listener);
		
		GridBagConstraints gbcadrk = generateTextFieldGBC();
		middlePanel.add(tfadrk, gbcadrk);
		
		GridBagConstraints gbcllk = generateLabelGBC();
		middlePanel.add(llk, gbcllk);
		
		JTextField tflk = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder((((CheckValidation.checkLK(this.getText())) && CheckValidation.checkUniqueProfesorID(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tflk.setName("tflk");
		tflk.addFocusListener(listener);
		
		GridBagConstraints gbctflk = generateTextFieldGBC();
		middlePanel.add(tflk, gbctflk);
		
		GridBagConstraints gbcltit = generateLabelGBC();
		middlePanel.add(ltit, gbcltit);
		
		JTextField tftit = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkTitula(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tftit.setName("tftit");
		tftit.addFocusListener(listener);
		
		GridBagConstraints gbctftit = generateTextFieldGBC();
		middlePanel.add(tftit, gbctftit);
		
		GridBagConstraints gbclzvanje = generateLabelGBC();
		middlePanel.add(lzvanje, gbclzvanje);
		
		JTextField tfzvanje = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkZvanje(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfzvanje.setName("tfzvanje");
		tfzvanje.addFocusListener(listener);
		
		GridBagConstraints gbctfzvanje = generateTextFieldGBC();
		middlePanel.add(tfzvanje, gbctfzvanje);
	}
}
