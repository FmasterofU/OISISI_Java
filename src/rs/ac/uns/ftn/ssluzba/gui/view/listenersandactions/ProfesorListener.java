package rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;

public class ProfesorListener implements FocusListener{
	
	Object data[] = new Object[10];

	@Override
	public void focusGained(FocusEvent arg0) {}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		
		if(txt.getName().trim().equals("tfime"))
		{
			data[0] = txt.getText().trim();
			if(((String)data[0]).length() != 0)	data[0] = CheckValidation.firstLetterToCapital((String)data[0]);
		}
		else if(txt.getName().trim().equals("tfprez")) 
		{
			data[1] = txt.getText().trim();	
			if(((String)data[1]).length() != 0)	data[1] = CheckValidation.firstLetterToCapital((String)data[1]);
		}
		else if(txt.getName().trim().equals("tfdatr"))			data[2] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfadrs"))
		{
			data[3] = txt.getText().trim();
			if(((String)data[3]).length() != 0)	data[3] = CheckValidation.firstLetterToCapital((String)data[3]);
		}
		else if(txt.getName().trim().equals("tftel"))				data[4] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfmail"))			data[5] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfadrk"))
		{
			data[6] = txt.getText().trim();
			if(((String)data[6]).length() != 0)	data[6] = CheckValidation.firstLetterToCapital((String)data[6]);
		}
		else if(txt.getName().trim().equals("tflk"))				data[7] = txt.getText().trim();
		else if(txt.getName().trim().equals("tftit"))				data[8] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfzvanje"))		data[9] = txt.getText().trim();
	}
	
	public void setInitialData(Profesor p)
	{
		data[0] = p.getIme();
		data[1] = p.getPrezime();
		data[2] = p.getDatumRodjenja();
		data[3] = p.getAdresaStanovanja();
		data[4] = p.getTelefon();
		data[5] = p.geteMail();
		data[6] = p.getAdresaKancelarije();
		data[7] = p.getBrojLK();
		data[8] = p.getTitula();
		data[9] = p.getZvanje();
	}
	
	public Object[] getData()
	{
		return data;
	}
	
	public void clearData()
	{
		for(int i = 0; i < data.length; i++)		data[i] = "";
	}
}
