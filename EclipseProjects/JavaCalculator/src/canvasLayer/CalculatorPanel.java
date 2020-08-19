package canvasLayer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import arithmetics.*;

public class CalculatorPanel extends JPanel {

	private final static int X_START = 20;
	private final static int Y_START = 20;
	private int index = 0;
	
	private String inputValue = "";
    private String sign = "";
    private int firstOperand = 0;
    private int secondOperand = 0;
	
	private JTextField textField = null;
	private JButton button0 = null;
	private JButton button1 = null;
	private JButton button2 = null;
	private JButton button3 = null;
	private JButton button4 = null;
	private JButton button5 = null;
	private JButton button6 = null;
	private JButton button7 = null;
	private JButton button8 = null;
	private JButton button9 = null;
	private JButton buttonAdd = null;
	private JButton buttonSub = null;
	private JButton buttonMul = null;
	private JButton buttonDiv = null;
	private JButton buttonEqual = null;
	
	public CalculatorPanel(){
		this.setLayout(null);
		
		initComponents();
		addActionListeners();
		
		this.add(textField);
		this.add(button0);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(button4);
		this.add(button5);
		this.add(button6);
		this.add(button7);
		this.add(button8);
		this.add(button9);
		this.add(buttonDiv);
		this.add(buttonMul);
		this.add(buttonSub);
		this.add(buttonAdd);
		this.add(buttonEqual);	
	}
	private int parseString(String inputValue) {
		
		return Integer.parseInt(inputValue);
	}
	
	private void addActionListeners() {
		
		ActionListener buttonActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton sender = (JButton)e.getSource();
				switch (sender.getText()) 
				{
					case "0": {
						inputValue += "0";
			            textField.setText(inputValue);
						break;
					}
					case "1": {
						inputValue += "1";
			            textField.setText(inputValue);
						break;
					}
					case "2": {
						inputValue += "2";
			            textField.setText(inputValue);
						break;
					}
					case "3": {
						inputValue += "3";
			            textField.setText(inputValue);
						break;
					}
					case "4": {
						inputValue += "4";
			            textField.setText(inputValue);
						break;
					}
					case "5": {
						inputValue += "5";
			            textField.setText(inputValue);
						break;
					}
					case "6": {
						inputValue += "6";
			            textField.setText(inputValue);
						break;
					}
					case "7": {
						inputValue += "7";
			            textField.setText(inputValue);
						break;
					}
					case "8": {
						inputValue += "8";
			            textField.setText(inputValue);
						break;
					}
					case "9": {
						inputValue += "9";
			            textField.setText(inputValue);
						break;
					}
					case "/": {
						sign = "/";
			            firstOperand = parseString(inputValue);
			            inputValue = "";
						break;
					}
					case "X": {
						sign = "*";
			            firstOperand = parseString(inputValue);
			            inputValue = "";
						break;
					}
					case "+": {
						sign = "+";
			            firstOperand = parseString(inputValue);
			            inputValue = "";
						break;
					}
					case "-": {
						sign = "-";
			            firstOperand = parseString(inputValue);
			            inputValue = "";
						break;
					}
					case "=": {
						secondOperand = parseString(inputValue);
			            int result = 0;
						try {
							result = ArithmeticOperations.calculate(firstOperand, secondOperand, sign);
						} catch (ArithmeticException e1) {
							
							textField.setText(e1.getMessage());
						}
			            textField.setText(Integer.toString(result));
			            inputValue = "";
						break;
					}
				}
			}
		};
		
		button0.addActionListener(buttonActionListener);
		button1.addActionListener(buttonActionListener);
		button2.addActionListener(buttonActionListener);
		button3.addActionListener(buttonActionListener);
		button4.addActionListener(buttonActionListener);
		button5.addActionListener(buttonActionListener);
		button6.addActionListener(buttonActionListener);
		button7.addActionListener(buttonActionListener);
		button8.addActionListener(buttonActionListener);
		button9.addActionListener(buttonActionListener);
		buttonDiv.addActionListener(buttonActionListener);
		buttonMul.addActionListener(buttonActionListener);
		buttonAdd.addActionListener(buttonActionListener);
		buttonSub.addActionListener(buttonActionListener);
		buttonEqual.addActionListener(buttonActionListener);
	}

	private void initComponents(){
		
		textField = new JTextField();
		textField.setBounds(X_START, Y_START + (index++ * 50), 260, 40);
		
		button7 = new JButton("7");
		button7.setBounds(X_START, Y_START + (index * 50), 50, 30);
		
		button8 = new JButton("8");
		button8.setBounds(X_START + 60, Y_START + (index * 50), 50, 30);
		
		button9 = new JButton("9");
		button9.setBounds(X_START + 120, Y_START + (index * 50), 50, 30);
		
		buttonDiv = new JButton("/");
		buttonDiv.setBounds(X_START + 210, Y_START + (index++ * 50), 50, 30);
		
		button4 = new JButton("4");
		button4.setBounds(X_START, Y_START + (index * 50), 50, 30);
		
		button5 = new JButton("5");
		button5.setBounds(X_START + 60, Y_START + (index * 50), 50, 30);
		
		button6 = new JButton("6");
		button6.setBounds(X_START + 120, Y_START + (index * 50), 50, 30);
		
		buttonMul = new JButton("X");
		buttonMul.setBounds(X_START + 210, Y_START + (index++ * 45), 50, 30);
		
		button1 = new JButton("1");
		button1.setBounds(X_START, Y_START + (index * 50), 50, 30);
		
		button2 = new JButton("2");
		button2.setBounds(X_START + 60, Y_START + (index * 50), 50, 30);
		
		button3 = new JButton("3");
		button3.setBounds(X_START + 120, Y_START + (index * 50), 50, 30);
		
		buttonSub = new JButton("-");
		buttonSub.setBounds(X_START + 210, Y_START + (index++ * 45), 50, 30);
		
		button0 = new JButton("0");
		button0.setBounds(X_START, Y_START + (index * 60), 80, 50);
		
		buttonAdd = new JButton("+");
		buttonAdd.setBounds(X_START + 210, Y_START + (index++ * 45), 50, 30);
		
		buttonEqual = new JButton("=");
		buttonEqual.setBounds(X_START + 210, Y_START + (index * 45), 50, 63);
	}
}
