package property_listeners;

import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.function.Function;

import javax.swing.JTextField;

import api.XCommand;
import panels.FigurePanel;

public class PropertyFocus implements FocusListener{

	private XCommand cmd = null;
	private PropertyType type;
	
	public PropertyFocus(XCommand cmd, PropertyType type){
		
		this.cmd = cmd;
		this.type = type;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		changeFigureProperty(e);
	}
	
	private void changeFigureProperty(FocusEvent e){
		
		JTextField txt = (JTextField) e.getSource();
		int value = 0;
		Rectangle rec = null;
		FigurePanel figure = null;
		try{
		rec =  cmd.getTabbedPanel().getActiveCanvas().getInFocusFigure().getBounds();	
		value = Integer.parseInt(txt.getText());
		figure = cmd.getTabbedPanel().getActiveCanvas().getInFocusFigure();
		}catch(NullPointerException ex){
			return;
		}
		switch (type){
		case X:  figure.setBounds(value, rec.y, rec.width, rec.height); break;
		case Y:  figure.setBounds(rec.x, value, rec.width, rec.height); break;
		case WIDTH:  figure.setBounds(rec.x, rec.y, value, rec.height); break;
		case HEIGHT:  figure.setBounds(rec.x, rec.y, rec.width, value); break;
		}
	}

}
