package Utils;

import ActionListener.StatusBarListener.EventListenerStatus;
import ActionListener.TabListener.EventListenerGen;
import ActionListener.XDataListener.EventListenerData;
import FigureControls.PaintPanel;
import GUI.TabPanel;
import io.FileImpl;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XCommand {

	public xData data;
	public ActionOpen actionOpen;
	public ActionSave actionSave;
	public ActionColor actionColor;
	public ActionWidth actionWidth;
	public ActionType actionType;
	public EventListenerData dataChanged;
	public EventListenerStatus eventListenerStatus;
	public ActionAddTab actionNewTab;
	public ActionCloseTab actionCloseTab;
	public ActionSelectTab actionSelectTab;
	public TabPanel actionPanel;
	public EventListenerGen tAddListener;

	public XCommand() {

		actionOpen 	  	= new ActionOpen();
		actionSave 		= new ActionSave();
		actionColor		= new ActionColor();
		actionType 		= new ActionType();
		actionWidth 	= new ActionWidth();

		actionNewTab 	= new ActionAddTab();
		actionCloseTab  = new ActionCloseTab();
		actionSelectTab = new ActionSelectTab();
		tAddListener 	= new EventListenerGen();

		eventListenerStatus = new EventListenerStatus();
		dataChanged 	= new EventListenerData();

		data = new xData();
	}

	public void setPanel(TabPanel tp){
		actionPanel = tp;
	}

	class ActionColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			XCommand.this.data.setColor(JColorChooser.showDialog(null, "Color", XCommand.this.data.getColor()));
			XCommand.this.dataChanged.Invoke();
			eventListenerStatus.getListenerDataChange(XCommand.this.data);
		}
	}

	class ActionWidth implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand().toLowerCase();
			switch (name) {
				case "small":
					XCommand.this.data.setWidth(2);
					break;
				case "medium":
					XCommand.this.data.setWidth(5);
					break;
				case "large":
					XCommand.this.data.setWidth(7);
					break;
				default:
					break;
			}
			XCommand.this.dataChanged.Invoke();
			eventListenerStatus.getListenerDataChange(XCommand.this.data);
		}
	}

	class ActionType implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			XCommand.this.data.setType(EnumFigureType.valueOf(e.getActionCommand()));
			XCommand.this.dataChanged.Invoke();
			eventListenerStatus.getListenerDataChange(XCommand.this.data);
		}
	}

	public class ActionAddTab implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			actionPanel.addPanel();
			tAddListener.ListenerTabAdd(((PaintPanel)actionPanel.getSelectedComponent()).title);
		}
	}
	class ActionCloseTab implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			tAddListener.ListenerTabDel(((PaintPanel) actionPanel.getSelectedComponent()).title);
			actionPanel.deleteTab();
		}
	}
	class ActionSelectTab implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem item = (JMenuItem) e.getSource();
			String tabTitle = item.getText();

			for(int i = 0; i < actionPanel.getTabCount(); i++)
			{
				String s = actionPanel.getTitleAt(i);
				if(s.equals(tabTitle))
				{
					JPanel panel = (JPanel) actionPanel.getComponentAt(i);
					PaintPanel tab = (PaintPanel) panel;
					tab.requestFocusInWindow();
					actionPanel.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	class ActionSave implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.showSaveDialog(new JFrame());
			FileImpl.GetInstance(chooser.getSelectedFile().getName(),chooser.getSelectedFile().getPath());
		}
	}
	class ActionOpen implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpeg & gif img", "jpg", "gif");

			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, chooser.getSelectedFile().getName());
			}
		}
	}
}