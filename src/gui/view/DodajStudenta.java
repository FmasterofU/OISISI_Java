package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import gui.controller.CheckValidation;
import gui.controller.StudentController;
import gui.model.NacinFinansiranja;
import gui.model.Student;
import listeners_and_actions.StudentListener;

public class DodajStudenta extends JDialog{
	
	private static final long serialVersionUID = 5160676555418089845L;
	private static DodajStudenta instance = null;
	private int labGBC = 0;
	private int tfGBC = 0;
	JRadioButton budget, samof;
	StudentListener listener = new StudentListener();
	
	public static DodajStudenta getInstance()
	{
		if(instance==null) instance = new DodajStudenta();
		return instance;
	}

	@SuppressWarnings("serial")
	private DodajStudenta(){
		super(MainWindow.getInstance(), "Dodavanje studenta", true);
		setSize(550, 550);
		setLocationRelativeTo(MainWindow.getInstance());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				instance.setVisible(false);
				instance = null;
				listener.clearData();
				System.gc();
			}
		});
		
		JPanel doleZaDugmice = new JPanel();
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		potvrda.setForeground(Color.BLACK);
		potvrda.setBackground(Color.CYAN);
		potvrda.addActionListener(new ActionListener() {
			
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
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				instance.setVisible(false);
				instance = null;
				listener.clearData();
				System.gc();
			}
		});
		JPanel dugmici = new JPanel();
		BoxLayout box1 = new BoxLayout(dugmici, BoxLayout.Y_AXIS);
		dugmici.setLayout(box1);
		
		BoxLayout box2 = new BoxLayout(doleZaDugmice, BoxLayout.X_AXIS);
		doleZaDugmice.setLayout(box2);
		doleZaDugmice.add(Box.createGlue());
		doleZaDugmice.add(odustanak);
		doleZaDugmice.add(Box.createHorizontalStrut(10));
		doleZaDugmice.add(potvrda);
		doleZaDugmice.add(Box.createHorizontalStrut(10));
		dugmici.add(doleZaDugmice);
		dugmici.add(new JLabel(" "));
		
		this.add(dugmici, BorderLayout.SOUTH);
		
		JPanel podaciSredina = new JPanel();
		podaciSredina.setLayout(new GridBagLayout());
		this.add(podaciSredina, BorderLayout.CENTER);
		
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
		podaciSredina.add(lime, gbclime);
		
		JTextField tfime = new TextField(10) {
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkName(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfime.setName("tfime");
		//tfime.setBackground(Color.WHITE);
		tfime.addFocusListener(listener);
		
		GridBagConstraints gbctfime = generateTextFieldGBC();
		podaciSredina.add(tfime, gbctfime);
		
		GridBagConstraints gbclprez = generateLabelGBC();
		podaciSredina.add(lprez, gbclprez);
		
		JTextField tfprez = new TextField(10)
		{
			@Override
			public void maybeHighlight() {
				setBorder(((CheckValidation.checkName(this.getText())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
		};
		tfprez.setName("tfprez");
		//tfprez.setBackground(Color.GRAY);
		tfprez.addFocusListener(listener);
		
		GridBagConstraints gbctfprez = generateTextFieldGBC();
		podaciSredina.add(tfprez, gbctfprez);
		
		GridBagConstraints gbclindeks = generateLabelGBC();
		podaciSredina.add(lindeks, gbclindeks);
		
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
		podaciSredina.add(tfindeks, gbctfindeks);
		
		GridBagConstraints gbcldatr = generateLabelGBC();
		podaciSredina.add(ldatr, gbcldatr);
		
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
		podaciSredina.add(tfdatr, gbctfdatr);
		
		GridBagConstraints gbcladr = generateLabelGBC();
		podaciSredina.add(ladr, gbcladr);
		
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
		podaciSredina.add(tfadr, gbctfadr);
		
		GridBagConstraints gbcltel = generateLabelGBC();
		podaciSredina.add(ltel, gbcltel);
		
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
		podaciSredina.add(tftel, gbctftel);
		
		GridBagConstraints gbclmail = generateLabelGBC();
		podaciSredina.add(lmail, gbclmail);
		
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
		podaciSredina.add(tfmail, gbctfmail);
		
		GridBagConstraints gbclgod = generateLabelGBC();
		podaciSredina.add(lgod, gbclgod);
		
		String[] cbItems = {"I(prva)", "II(druga)", "III(treća)", "IV(četvrta)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbgod = new JComboBox(cbItems);
		cbgod.addItemListener(listener);
		GridBagConstraints gbccb = generateTextFieldGBC();
		podaciSredina.add(cbgod, gbccb);
		
		GridBagConstraints gbclpros = generateLabelGBC();
		podaciSredina.add(lpros, gbclpros);
		
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
		podaciSredina.add(tfpros, gbctfpros);
		
		budget = new JRadioButton("Budžet");
		budget.setName("Budžet");
		budget.setSelected(true);
		samof = new JRadioButton("Samofinansiranje");
		samof.setName("Samofinansiranje");
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		podaciSredina.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		podaciSredina.add(samof, gbcsamof);
		
		GridBagConstraints gbcldatu = generateLabelGBC();
		podaciSredina.add(ldatu, gbcldatu);
		
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
		podaciSredina.add(tfdatu, gbctfdatu);
	}
	/*
	protected void setFieldHighlightColors(boolean[] result) {
		
	}
*/
	private GridBagConstraints generateLabelGBC()
	{
		GridBagConstraints ret = new GridBagConstraints();
		ret.gridx = 0;
		ret.gridy = labGBC++;
		ret.insets = new Insets(10, 10, 10, 10);
		return ret;
	}
	
	private GridBagConstraints generateTextFieldGBC()
	{
		GridBagConstraints ret = new GridBagConstraints();
		ret.gridx = 1;
		ret.gridy = tfGBC++;
		ret.weightx = 100;
		ret.fill = GridBagConstraints.HORIZONTAL;
		ret.insets = new Insets(10, 10, 10, 10);
		return ret;
	}
}
