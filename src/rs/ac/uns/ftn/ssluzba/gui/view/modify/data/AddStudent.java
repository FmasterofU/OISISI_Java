package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
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
import rs.ac.uns.ftn.ssluzba.resources.Resource;

/**
 * @author rammba
 * @implNote extends {@link Dialog}, singleton, in essence {@link JDialog} for Adding Students
 */
@SuppressWarnings("serial")
public class AddStudent extends Dialog {
	
	private static AddStudent instance = null;
	private JRadioButton budget, samof;
	private StudentListener listener = new StudentListener();
	
	public static AddStudent getInstance() {
		if(instance==null) instance = new AddStudent();
		return instance;
	}

	private AddStudent(){
		super("Dodavanje studenta", "Potvrda", "Odustanak");
		
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
				boolean[] result = CheckValidation.isStudentValid(s, false);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check){
					if(budget.isSelected())	nf = NacinFinansiranja.BUD\u017dET;
					else		nf = NacinFinansiranja.SAMOFINANSIRANJE;
					Student novi = new Student((String) s[0], (String) s[1], (String) s[2], (String) s[3], (String) s[4], (String) s[5], (String) s[6], (String) s[7], (GodinaStudija) s[8], nf, Double.parseDouble((String) s[9]));
					StudentController.addStudent(novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				} else
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
		
		lindeks.setToolTipText("ssN[NN]/YYYY");
		GridBagConstraints gbclindeks = generateLabelGBC();
		middlePanel.add(lindeks, gbclindeks);
		
		JTextField tfindeks = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkIndex(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfindeks.setName("tfindeks");
		tfindeks.addFocusListener(listener);
		
		GridBagConstraints gbctfindeks = generateTextFieldGBC();
		middlePanel.add(tfindeks, gbctfindeks);
		
		ldatr.setToolTipText("DD.MM.YYYY.");
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
		middlePanel.add(ladr, gbcladr);
		
		JTextField tfadr = new TextField(10)
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
		
		GridBagConstraints gbclgod = generateLabelGBC();
		middlePanel.add(lgod, gbclgod);
		
		String[] cbItems = {GodinaStudija.I.name(), GodinaStudija.II.name(), GodinaStudija.III.name(), GodinaStudija.IV.name()};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbgod = new ComboBox(cbItems);
		cbgod.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		middlePanel.add(cbgod, gbccb);
		
		GridBagConstraints gbclpros = generateLabelGBC();
		middlePanel.add(lpros, gbclpros);
		
		JTextField tfpros = new TextField(10)
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
		
		budget = new JRadioButton("Bud\u017eet");
		budget.setName("Bud\u017eet");
		budget.setBackground(Color.WHITE);
		budget.setSelected(true);
		samof = new JRadioButton("Samofinansiranje");
		samof.setName("Samofinansiranje");
		samof.setBackground(Color.WHITE);
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		middlePanel.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		middlePanel.add(samof, gbcsamof);
		
		ldatu.setToolTipText("DD.MM.YYYY.");
		GridBagConstraints gbcldatu = generateLabelGBC();
		middlePanel.add(ldatu, gbcldatu);
		
		JTextField tfdatu = new TextField(10)
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
