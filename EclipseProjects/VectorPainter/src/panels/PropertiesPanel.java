package panels;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import api.XCommand;
import property_listeners.PropertyFocus;
import property_listeners.PropertyType;

public class PropertiesPanel extends JPanel {
	
	private XCommand cmd = null;
	private JLabel labelLocationX, labelLocationY;
	private JLabel labelWidth, labelHeight;
	private JTextField textLocationX, textLocationY;
	private JTextField textWidth, textHeight;
	
	private JButton buttonColor, buttonWidth, buttonType;
	
	public void setListeners(XCommand cmd){
		
		this.cmd = cmd;
		textLocationX.addFocusListener(new PropertyFocus(cmd, PropertyType.X));
		textLocationY.addFocusListener(new PropertyFocus(cmd, PropertyType.Y));
		textWidth.addFocusListener(new PropertyFocus(cmd, PropertyType.WIDTH));
		textHeight.addFocusListener(new PropertyFocus(cmd, PropertyType.HEIGHT));
		
		buttonColor.addActionListener(cmd.getColor());
		buttonWidth.addActionListener(cmd.getWidth());
		buttonType.addActionListener(cmd.getType());
		this.setVisible(false);
	}
	
	public PropertiesPanel(Rectangle r){
		initializeComponents(r);
		this.setBorder(new LineBorder(Color.BLACK));
		this.setLayout(null);
		this.setBounds(r);
	}
	
	private void initializeComponents(Rectangle r){
		
		int y_offset = r.height / 7;
		
		labelLocationX = new JLabel("X : ");
		labelLocationX.setBounds(0, 0, r.width / 2, y_offset);
		
		labelLocationY = new JLabel("Y : ");
		labelLocationY.setBounds(0, y_offset, r.width / 2, y_offset);
		
		labelWidth = new JLabel("Width : ");
		labelWidth.setBounds(0, y_offset * 2, r.width / 2, y_offset);
		
		labelHeight = new JLabel("Height : ");
		labelHeight.setBounds(0, y_offset * 3, r.width / 2, y_offset);
		
		textLocationX = new JTextField();
		textLocationX.setBounds(r.width / 2, 0, r.width / 2, y_offset);
		
		textLocationY = new JTextField();
		textLocationY.setBounds(r.width / 2, y_offset, r.width / 2, y_offset);
		
		textWidth = new JTextField();
		textWidth.setBounds(r.width / 2, y_offset * 2, r.width / 2, y_offset);
		
		textHeight = new JTextField();
		textHeight.setBounds(r.width / 2, y_offset * 3, r.width / 2, y_offset);
		
		buttonColor = new JButton("Color");
		buttonColor.setBounds(0, y_offset * 4, r.width, y_offset);
		buttonWidth = new JButton("Width");
		buttonWidth.setBounds(0, y_offset * 5, r.width, y_offset);
		buttonType = new JButton("Figure type");
		buttonType.setBounds(0, y_offset * 6, r.width, r.height - (y_offset * 6));
		
		add(labelLocationX);
		add(labelLocationY);
		add(labelWidth);
		add(labelHeight);
		
		add(textLocationX);
		add(textLocationY);
		add(textWidth);
		add(textHeight);
		
		add(buttonColor);
		add(buttonWidth);
		add(buttonType);
	}
	
	
	public void showProperty(Rectangle r){
		setVisible(true);
		this.textLocationX.setText(String.valueOf(r.x));
		this.textLocationY.setText(String.valueOf(r.y));
		this.textWidth.setText(String.valueOf(r.width));
		this.textHeight.setText(String.valueOf(r.height));
	}
	
	public void hideProperty(){
		this.setVisible(false);
	}
}
