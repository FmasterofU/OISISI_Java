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
import gui.model.Data;
import gui.model.Profesor;
import gui.view.modify.Dialog;
import gui.view.modify.IHighlight;
import gui.view.modify.MandatoryTextFieldLabel;
import gui.view.modify.TextField;
import listeners_and_actions.ProfesorListener;

public class EditProfesor extends Dialog{
	
	private static final long serialVersionUID = 4972687805465509544L;
	private static EditProfesor instance = null;
	private ProfesorListener listener = new ProfesorListener();
	Profesor old = null;
	private String ime, prez, datr, adrs, tel, mail, adrk, lkk, tit, zvanje;
	
	public static EditProfesor getInstance(String lk)
	{
		if(instance == null)	instance = new EditProfesor(lk);
		return instance;
	}
	
	@SuppressWarnings("serial")
	private EditProfesor(String lk)
	{
		super("Izmena profesora", "Potvrda", "Odustanak");
		
		old = getProfesor(lk);
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
				String[] s = listener.getData();
				boolean check = true;
				boolean[] result = CheckValidation.isProfesorValid(s, true);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check){
					Profesor novi = new Profesor(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
					ProfesorController.editProfesor(old.getBrojLK(), novi);
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
		
		ime = old.getIme();
		JTextField tfime = new TextField(ime) {
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
		
		prez = old.getPrezime();
		JTextField tfprez = new TextField(prez)
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
		
		datr = old.getDatumRodjenja();
		JTextField tfdatr = new TextField(datr)
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
		
		adrs = old.getAdresaStanovanja();
		JTextField tfadrs = new TextField(adrs)
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
		
		tel = old.getTelefon();
		JTextField tftel = new TextField(tel)
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
		
		mail = old.geteMail();
		JTextField tfmail = new TextField(mail)
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
		
		adrk = old.getAdresaKancelarije();
		JTextField tfadrk = new TextField(adrk)
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
		
		lkk = old.getBrojLK();
		JTextField tflk = new JTextField(lkk);
		tflk.setEditable(false);
		tflk.setName("tflk");
		tflk.addFocusListener(listener);
		
		GridBagConstraints gbctflk = generateTextFieldGBC();
		middlePanel.add(tflk, gbctflk);
		
		GridBagConstraints gbcltit = generateLabelGBC();
		middlePanel.add(ltit, gbcltit);
		
		tit = old.getTitula();
		JTextField tftit = new TextField(tit)
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
		
		zvanje = old.getZvanje();
		JTextField tfzvanje = new TextField(zvanje)
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
	
	private Profesor getProfesor(String lk)
	{
		for(Profesor p: Data.data.listaProfesora.getProfesori())
		{
			if(lk.equals(p.getBrojLK()))
				return p;
		}
		return null;
	}
}
