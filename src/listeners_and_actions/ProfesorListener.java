package listeners_and_actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ProfesorListener implements FocusListener{
	
	String data[] = {"", "", "", "", "", "", "", "", "", ""};

	@Override
	public void focusGained(FocusEvent arg0) {
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		
		if(txt.getName().trim().equals("tfime"))					data[0] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tfprez"))			data[1] = (txt.getText().trim());	
		else if(txt.getName().trim().equals("tfdatr"))			data[2] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tfadrs"))			data[3] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tftel"))				data[4] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tfmail"))			data[5] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tfadrk"))			data[6] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tflk"))				data[7] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tftit"))				data[8] = (txt.getText().trim());
		else if(txt.getName().trim().equals("tfzvanje"))		data[9] = (txt.getText().trim());
	}
	
	public String[] getData()
	{
		return data;
	}
	
	public void clearData()
	{
		for(int i = 0; i < data.length; i++)		data[i] = "";
	}

}
