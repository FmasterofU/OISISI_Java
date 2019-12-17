package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DodajStudenta extends JDialog{
	
	private static final long serialVersionUID = 5160676555418089845L;
	private static DodajStudenta instance = null;
	private int labGBC = 0;
	private int tfGBC = 0;
	
	public static DodajStudenta getInstance()
	{
		if(instance == null)	instance = new DodajStudenta();
		return instance;
	}

	private DodajStudenta(){
		super(MainWindow.getInstance(), "Dodavanje studenta", true);
		setSize(500, 500);
		setLocationRelativeTo(MainWindow.getInstance());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel doleZaDugmice = new JPanel();
		JButton odustanak = new JButton("Odustanak");
		JButton potvrda = new JButton("Potvrda");
		potvrda.setForeground(Color.BLACK);
		potvrda.setBackground(Color.CYAN);
		potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajStudenta.getInstance().setVisible(false);
			}
		});
		
		odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodajStudenta.getInstance().setVisible(false);
			}
		});
		
		BoxLayout box = new BoxLayout(doleZaDugmice, BoxLayout.X_AXIS);
		doleZaDugmice.setLayout(box);
		
		doleZaDugmice.add(Box.createGlue());
		doleZaDugmice.add(odustanak);
		doleZaDugmice.add(Box.createHorizontalStrut(10));
		doleZaDugmice.add(potvrda);
		doleZaDugmice.add(Box.createHorizontalStrut(10));
		
		this.add(doleZaDugmice, BorderLayout.SOUTH);
		
		JPanel podaciSredina = new JPanel();
		podaciSredina.setLayout(new GridBagLayout());
		this.add(podaciSredina, BorderLayout.CENTER);
		
		JLabel lime = new JLabel("Ime*: ");
		JLabel lprez = new JLabel("Prezime*: ");
		JLabel lindeks = new JLabel("Indeks*: ");
		JLabel ldatr = new JLabel("Datum roðenja*: ");
		JLabel ladr = new JLabel("Adresa*: ");
		JLabel ltel = new JLabel("Broj telefona*: ");
		JLabel lmail = new JLabel("eMail*: ");
		JLabel lgod = new JLabel("Godina studija*: ");
		JLabel lpros = new JLabel("Prosek*: ");
		JLabel ldatu = new JLabel("Datum upisa*: ");
		
		FocusListener focus = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				JTextField txt = (JTextField) arg0.getComponent();
				txt.setBackground(Color.GRAY);
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				JTextField txt = (JTextField) arg0.getComponent();
				txt.setBackground(Color.WHITE);
			}
		};
		
		GridBagConstraints gbclime = generateLabelGBC();
		podaciSredina.add(lime, gbclime);
		
		JTextField tfime = new JTextField(10);
		tfime.setName("tfime");
		tfime.setBackground(Color.GRAY);
		tfime.addFocusListener(focus);
		
		GridBagConstraints gbctfime = generateTextFieldGBC();
		podaciSredina.add(tfime, gbctfime);
		
		GridBagConstraints gbclprez = generateLabelGBC();
		podaciSredina.add(lprez, gbclprez);
		
		JTextField tfprez = new JTextField(10);
		tfprez.setName("tfprez");
		tfprez.setBackground(Color.GRAY);
		tfprez.addFocusListener(focus);
		
		GridBagConstraints gbctfprez = generateTextFieldGBC();
		podaciSredina.add(tfprez, gbctfprez);
		
		GridBagConstraints gbclindeks = generateLabelGBC();
		podaciSredina.add(lindeks, gbclindeks);
		
		JTextField tfindeks = new JTextField(10);
		tfindeks.setName("tfindeks");
		tfindeks.setBackground(Color.GRAY);
		tfindeks.addFocusListener(focus);
		
		GridBagConstraints gbctfindeks = generateTextFieldGBC();
		podaciSredina.add(tfindeks, gbctfindeks);
		
		GridBagConstraints gbcldatr = generateLabelGBC();
		podaciSredina.add(ldatr, gbcldatr);
		
		JTextField tfdatr = new JTextField(10);
		tfdatr.setName("tfdatr");
		tfdatr.setBackground(Color.GRAY);
		tfdatr.addFocusListener(focus);
		
		GridBagConstraints gbctfdatr = generateTextFieldGBC();
		podaciSredina.add(tfdatr, gbctfdatr);
		
		GridBagConstraints gbcladr = generateLabelGBC();
		podaciSredina.add(ladr, gbcladr);
		
		JTextField tfadr = new JTextField(10);
		tfadr.setName("tfadr");
		tfadr.setBackground(Color.GRAY);
		tfadr.addFocusListener(focus);
		
		GridBagConstraints gbctfadr = generateTextFieldGBC();
		podaciSredina.add(tfadr, gbctfadr);
		
		GridBagConstraints gbcltel = generateLabelGBC();
		podaciSredina.add(ltel, gbcltel);
		
		JTextField tftel = new JTextField(10);
		tftel.setName("tftel");
		tftel.setBackground(Color.GRAY);
		tftel.addFocusListener(focus);
		
		GridBagConstraints gbctftel = generateTextFieldGBC();
		podaciSredina.add(tftel, gbctftel);
		
		GridBagConstraints gbclmail = generateLabelGBC();
		podaciSredina.add(lmail, gbclmail);
		
		JTextField tfmail = new JTextField(10);
		tfmail.setName("tfmail");
		tfmail.setBackground(Color.GRAY);
		tfmail.addFocusListener(focus);
		
		GridBagConstraints gbctfmail = generateTextFieldGBC();
		podaciSredina.add(tfmail, gbctfmail);
		
		GridBagConstraints gbclgod = generateLabelGBC();
		podaciSredina.add(lgod, gbclgod);
		
		String[] cbItems = {"I(prva)", "II(druga)", "III(treæa)", "IV(èetvrta)"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox cbgod = new JComboBox(cbItems);
		GridBagConstraints gbccb = generateTextFieldGBC();
		podaciSredina.add(cbgod, gbccb);
		
		GridBagConstraints gbclpros = generateLabelGBC();
		podaciSredina.add(lpros, gbclpros);
		
		JTextField tfpros = new JTextField(10);
		tfpros.setName("tfpros");
		tfpros.setBackground(Color.GRAY);
		tfpros.addFocusListener(focus);
		
		GridBagConstraints gbctfpros = generateTextFieldGBC();
		podaciSredina.add(tfpros, gbctfpros);
		
		JRadioButton budget = new JRadioButton("Budžet");
		budget.setSelected(true);
		JRadioButton samof = new JRadioButton("Samofinansiranje");
		ButtonGroup group = new ButtonGroup();
		group.add(budget);
		group.add(samof);
		
		GridBagConstraints gbcbudget = generateLabelGBC();
		podaciSredina.add(budget, gbcbudget);
		GridBagConstraints gbcsamof = generateTextFieldGBC();
		podaciSredina.add(samof, gbcsamof);
		
		GridBagConstraints gbcldatu = generateLabelGBC();
		podaciSredina.add(ldatu, gbcldatu);
		
		JTextField tfdatu = new JTextField(10);
		tfdatu.setName("tfdatu");
		tfdatu.setBackground(Color.GRAY);
		tfdatu.addFocusListener(focus);
		
		GridBagConstraints gbctfdatu = generateTextFieldGBC();
		podaciSredina.add(tfdatu, gbctfdatu);
	}
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
