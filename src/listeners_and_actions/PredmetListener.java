package listeners_and_actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class PredmetListener implements FocusListener, ItemListener {

	private static Object[] data = new Object[6];
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		
		
	}

	@Override
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent fe) {
		JTextField text = (JTextField) fe.getComponent();
		
		
	}

	public void clearData() {
		for(int i=0; i < data.length; i++) data[i] = null;		
	}

	public Object[] getData() {
		return data;
	}

}
