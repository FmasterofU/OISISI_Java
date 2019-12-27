package gui.view.modify.data;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import gui.controller.CheckValidation;
import gui.controller.StudentController;
import gui.model.Data;
import gui.model.NacinFinansiranja;
import gui.model.Student;
import gui.view.modify.ComboBox;
import gui.view.modify.Dialog;
import gui.view.modify.IHighlight;
import gui.view.modify.MandatoryTextFieldLabel;
import gui.view.modify.TextField;
import listeners_and_actions.StudentListener;

public class EditStudent extends Dialog{

	private static final long serialVersionUID = -4788486876873441092L;
	private static EditStudent instance = null;
	private  JRadioButton budget, samof;
	private StudentListener listener = new StudentListener();
	Student old = null;
	private String ime, prez, indeks, datr, adr, tel, mail, datu;
	private byte god;
	private NacinFinansiranja n;
	private Double pros;
	
	public static EditStudent getInstance(int idx)
	{
		if(instance == null)		instance = new EditStudent(idx);
		return instance;
	}

	@SuppressWarnings("serial")
	private  EditStudent(int idx)
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
					StudentController.getInstance().izmeniStudenta(old.getBrIndeksa(), novi);
					instance.setVisible(false);
					instance = null;
					listener.clearData();
					System.gc();
				}
				else
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
		JLabel lindeks = new MandatoryTextFieldLabel("Indeks:");
		JLabel ldatr = new MandatoryTextFieldLabel("Datum rođenja:");
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
		String[] cbItems = {"I(prva)", "II(druga)", "III(treća)", "IV(četvrta)"};
		//String first = getGodina(god);
		//String[] others = getOthersGod(god);
		//String[] cbItems = {first, others[0], others[1], others[2]};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ComboBox cbgod = new ComboBox(cbItems);
		cbgod.setSelectedIndex(god-1);
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
		budget = new JRadioButton("Budžet");
		budget.setName("Budžet");
		samof = new JRadioButton("Samofinansiranje");
		samof.setName("Samofinansiranje");
		if(n == NacinFinansiranja.BUDŽET)		budget.setSelected(true);
		else		samof.setSelected(true);
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		middlePanel.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		middlePanel.add(samof, gbcsamof);
		
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
	
	private Student getStudent(int i)
	{
		int temp = 0;
		for(Student s: Data.data.listaStudenata.getStudenti())
		{
			if(i == temp)
				return s;
			temp++;
		}
		return null;
	}
	
	private String getGodina(byte g)
	{
		if(g == 1)		return "I(prva)";
		else if(g == 2)		return "II(druga)";
		else if(g == 3)		return "III(treća)";
		else return "IV(četvrta)";
	}
	
	private String[] getOthersGod(byte g)
	{
		String[] ret = {"", "", ""};
		if(g == 1)	
		{
			ret[0] = "II(druga)";
			ret[1] = "III(treća)";
			ret[2] =  "IV(četvrta)";
		}
		else if(g == 2)
		{
			ret[0] = "I(prva)";
			ret[1] = "III(treća)";
			ret[2] =  "IV(četvrta)";
		}
		else if(g == 3)
		{
			ret[0] = "I(prva)";
			ret[1] = "II(druga)";
			ret[2] =  "IV(četvrta)";
		}
		else
		{
			ret[0] = "I(prva)";
			ret[1] = "II(druga)";
			ret[2] =  "III(treća)";
		}
		return ret;
	}
}
