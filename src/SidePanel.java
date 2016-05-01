import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
/*
 * in the side panel
 * is a PanelHelper
 * currently: it's purpose is to be pretty and look nice
 * in the future: add more bells and whistles over here like a calculator for procrastination
 * 
 * @author Courtney Oka
 * 6/10/14
 */
public class SidePanel extends PanelHelper implements ActionListener
{
	//ctor, takes in GUI to send to the super ctor
	public SidePanel(GUI frame)
	{
		super(frame);
	}

	/**
	 * @Override
	 * doesn't do anything yet
	 * takes in an ActionEvent arguement
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
}
