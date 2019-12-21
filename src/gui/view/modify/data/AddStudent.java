package gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import gui.controller.CheckValidation;
import gui.controller.StudentController;
import gui.model.NacinFinansiranja;
import gui.model.Student;
import gui.view.modify.Dialog;
import gui.view.modify.IHighlight;
import gui.view.modify.MandatoryTextFieldLabel;
import gui.view.modify.TextField;
import listeners_and_actions.StudentListener;

public class AddStudent extends Dialog {
	
	private static final long serialVersionUID = 5160676555418089845L;
	private static AddStudent instance = null;
	JRadioButton budget, samof;
	StudentListener listener = new StudentListener();
	
	public static AddStudent getInstance() {
		if(instance==null) instance = new AddStudent();
		return instance;
	}

	@SuppressWarnings("serial")
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
				String[] s = listener.getData();
				NacinFinansiranja nf;
				boolean check = true;
				boolean[] result = CheckValidation.isStudentValid(s);
				for(boolean b : result)
					if(b==false) {
						check=false;
						break;
					}
				if(check)
				{
					if(budget.isSelected())	nf = NacinFinansiranja.BUDŽET;
					else		nf = NacinFinansiranja.SAMOFINANSIRANJE;
					Student novi = new Student(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], Byte.parseByte(s[8]), nf, Double.parseDouble(s[9]));
					StudentController.getInstance().dodajStudenta(novi);
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
		
		JLabel lime = new MandatoryTextFieldLabel("Ime:");
		JLabel lprez = new MandatoryTextFieldLabel("Prezime:");
		JLabel lindeks = new MandatoryTextFieldLabel("Indeks:");
		JLabel ldatr = new MandatoryTextFieldLabel("Datum rođenja:");
		JLabel ladr = new MandatoryTextFieldLabel("Adresa:");
		JLabel ltel = new MandatoryTextFieldLabel("Broj telefona:");
		JLabel lmail = new MandatoryTextFieldLabel("eMail:");
		JLabel lgod = new MandatoryTextFieldLabel("Godina studija:");
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
		//tfime.setBackground(Color.WHITE);
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
		//tfprez.setBackground(Color.GRAY);
		tfprez.addFocusListener(listener);
		
		GridBagConstraints gbctfprez = generateTextFieldGBC();
		middlePanel.add(tfprez, gbctfprez);
		
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
		//tfindeks.setBackground(Color.GREEN);
		tfindeks.addFocusListener(listener);
		
		GridBagConstraints gbctfindeks = generateTextFieldGBC();
		middlePanel.add(tfindeks, gbctfindeks);
		
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
		//tfdatr.setBackground(Color.GRAY);
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
		//tfadr.setBackground(Color.GRAY);
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
		//tftel.setBackground(Color.GRAY);
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
		//tfmail.setBackground(Color.GRAY);
		tfmail.addFocusListener(listener);
		
		GridBagConstraints gbctfmail = generateTextFieldGBC();
		middlePanel.add(tfmail, gbctfmail);
		
		GridBagConstraints gbclgod = generateLabelGBC();
		middlePanel.add(lgod, gbclgod);
		
		String[] cbItems = {"I(prva)", "II(druga)", "III(treća)", "IV(četvrta)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbgod = new JComboBox(cbItems);
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
		//tfpros.setBackground(Color.GRAY);
		tfpros.addFocusListener(listener);
		
		GridBagConstraints gbctfpros = generateTextFieldGBC();
		middlePanel.add(tfpros, gbctfpros);
		
		budget = new JRadioButton("Budžet");
		budget.setName("Budžet");
		budget.setSelected(true);
		samof = new JRadioButton("Samofinansiranje");
		samof.setName("Samofinansiranje");
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		middlePanel.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		middlePanel.add(samof, gbcsamof);
		
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
		//tfdatu.setBackground(Color.GRAY);
		tfdatu.addFocusListener(listener);
		
		GridBagConstraints gbctfdatu = generateTextFieldGBC();
		middlePanel.add(tfdatu, gbctfdatu);
	}
}
