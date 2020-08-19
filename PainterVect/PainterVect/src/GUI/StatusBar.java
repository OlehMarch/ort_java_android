package GUI;

import Utils.XCommand;
import Utils.xData;
import ActionListener.StatusBarListener.IActionListener;

import javax.swing.*;
import java.awt.event.MouseEvent;


public class StatusBar extends JPanel implements IActionListener

{
    private static JLabel xLabel;
    private static JLabel yLabel;
    private static JLabel colorLabel;
    private static JLabel widthLabel;
    private static JLabel typeLabel;

    public  StatusBar(XCommand cmd)
    {
        setLayout(null);

        xLabel = new JLabel("X: ");
        yLabel = new JLabel("Y: ");
        colorLabel = new JLabel("RGB: ");
        widthLabel = new JLabel("Width: ");
        typeLabel = new JLabel("Type: ");
        xLabel.setBounds(0, 0, 60, 20);
        yLabel.setBounds(60, 0, 60, 20);
        colorLabel.setBounds(120, 0, 200, 20);
        widthLabel.setBounds(320, 0, 120, 20);
        typeLabel.setBounds(440, 0, 120, 20);

        add(xLabel);
        add(yLabel);
        add(colorLabel);
        add(widthLabel);
        add(typeLabel);

        cmd.eventListenerStatus.addListener(this);
        this.addMouseMotionListener(cmd.eventListenerStatus);
    }
    
	@Override
	public void actionPoint(MouseEvent p) {

        xLabel.setText("X: " + p.getPoint().getX());
        yLabel.setText("Y: " + p.getPoint().getY());
	}

    @Override
    public void actionDataChange(xData data) {
        colorLabel.setText("RGB: ("+ data.getColor().getRed()+","+data.getColor().getGreen()+","+data.getColor().getBlue()+")");
        typeLabel.setText("Type: "+ data.getType().toString());
        widthLabel.setText("Width: "+ data.getWidth());
    }


}
