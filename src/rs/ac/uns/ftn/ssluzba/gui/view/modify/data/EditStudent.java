package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import resources.Resource;
import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.StudentController;
import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.StudentListener;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.NacinFinansiranja;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.ComboBox;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.Dialog;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.IHighlight;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.MandatoryTextFieldLabel;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.TextField;

public class EditStudent extends Dialog{

	private static final long serialVersionUID = -4788486876873441092L;
	private static EditStudent instance = null;
	private  JRadioButton budget, samof;
	private StudentListener listener = new StudentListener();
	Student old = null;
	private String ime, prez, indeks, datr, adr, tel, mail, datu;
	private GodinaStudija god;
	private NacinFinansiranja n;
	private Double pros;
	
	public static EditStudent getInstance(String idx)
	{
		if(instance == null)		instance = new EditStudent(idx);
		return instance;
	}

	@SuppressWarnings("serial")
	private  EditStudent(String idx)
	{
		super("Izmeni studenta", "Potvrda", "Odustanak");
		
		old = getStudent(idx);
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
				Object[] s = listener.getData();
				NacinFinansiranja nf;
				boolean check = true;
				boolean[] result = CheckValidation.isStudentValid(s, true);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check)
				{
					if(budget.isSelected())	nf = NacinFinansiranja.BUD\u017dET;
					else		nf = NacinFinansiranja.SAMOFINANSIRANJE;
					//GodinaStudija gs = getGodina(s[8]);
					Student novi = new Student((String) s[0], (String) s[1], (String) s[2], (String) s[3], (String) s[4], (String) s[5], (String) s[6], (String) s[7], (GodinaStudija) s[8], nf, Double.parseDouble((String) s[9]), old.getSlusaPredmete());
					StudentController.editStudent(old.getBrIndeksa(), novi);
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
		
		JLabel lime = new MandatoryTextFieldLabel("Ime:");
		JLabel lprez = new MandatoryTextFieldLabel("Prezime:");
		JLabel lindeks = new MandatoryTextFieldLabel("Indeks:");
		JLabel ldatr = new MandatoryTextFieldLabel("Datum ro\u0111enja:");
		JLabel ladr = new MandatoryTextFieldLabel("Adresa:");
		JLabel ltel = new MandatoryTextFieldLabel("Broj telefona:");
		JLabel lmail = new MandatoryTextFieldLabel("eMail:");
		JLabel lgod = new JLabel("Godina studija:");
		JLabel lpros = new MandatoryTextFieldLabel("Prosek:");
		JLabel ldatu = new MandatoryTextFieldLabel("Datum upisa:");
		
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
		
		GridBagConstraints gbclindeks = generateLabelGBC();
		middlePanel.add(lindeks, gbclindeks);
		
		indeks = old.getBrIndeksa();
		JTextField tfindeks = new JTextField(indeks);
		tfindeks.setName("tfindeks");
		tfindeks.setEditable(false);
		tfindeks.addFocusListener(listener);
		
		GridBagConstraints gbctfindeks = generateTextFieldGBC();
		middlePanel.add(tfindeks, gbctfindeks);
		
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
		middlePanel.add(ladr, gbcladr);
		
		adr = old.getAdresa();
		JTextField tfadr = new TextField(adr)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkAdress(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfadr.setName("tfadr");
		tfadr.addFocusListener(listener);
		
		GridBagConstraints gbctfadr = generateTextFieldGBC();
		middlePanel.add(tfadr, gbctfadr);
		
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
		
		GridBagConstraints gbclgod = generateLabelGBC();
		middlePanel.add(lgod, gbclgod);
		
		god = old.getGodStudija();
		String[] cbItems = {GodinaStudija.I.name(), GodinaStudija.II.name(), GodinaStudija.III.name(), GodinaStudija.IV.name()};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbgod = new ComboBox(cbItems);
		cbgod.setSelectedIndex(god.ordinal());
		cbgod.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		middlePanel.add(cbgod, gbccb);
		
		GridBagConstraints gbclpros = generateLabelGBC();
		middlePanel.add(lpros, gbclpros);
		
		pros = old.getProsecnaOcena();
		JTextField tfpros = new TextField(pros.toString())
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkProsek(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfpros.setName("tfpros");
		tfpros.addFocusListener(listener);
		
		GridBagConstraints gbctfpros = generateTextFieldGBC();
		middlePanel.add(tfpros, gbctfpros);
		
		n = old.getFinansiranje();
		budget = new JRadioButton("Bud\u017eet");
		budget.setName("Bud\u017eet");
		samof = new JRadioButton("Samofinansiranje");
		samof.setName("Samofinansiranje");
		if(n == NacinFinansiranja.BUD\u017dET)		budget.setSelected(true);
		else		samof.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		middlePanel.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		middlePanel.add(samof, gbcsamof);
		
		ldatu.setToolTipText("dd.MM.yyyy.");
		GridBagConstraints gbcldatu = generateLabelGBC();
		middlePanel.add(ldatu, gbcldatu);
		
		datu = old.getDatumUpisa();
		JTextField tfdatu = new TextField(datu)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkDate(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfdatu.setName("tfdatu");
		tfdatu.addFocusListener(listener);
		
		GridBagConstraints gbctfdatu = generateTextFieldGBC();
		middlePanel.add(tfdatu, gbctfdatu);
	}
	
	private Student getStudent(String i)
	{
		for(Student s: Data.getListaStudenata().getStudenti())
		{
			if(i.equals(s.getBrIndeksa()))
				return s;
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private GodinaStudija getGodina(String s)
	{
		if(s.contains("IV"))		return GodinaStudija.IV;
		else if(s.contains("III"))		return GodinaStudija.III;
		else if(s.contains("II"))		return GodinaStudija.II;
		else if(s.contains("I"))	return GodinaStudija.I;
		else return null;
	}
}
