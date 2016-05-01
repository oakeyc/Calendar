import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * is a JPanel
 *	literally helps makes more JPanels that take in GUI
 *	helps interconnect other panel-like classes
 * 
 * @author Courtney Oka
 * 2/5/14
 */
public class PanelHelper extends JPanel 
{
	private GUI f;
	//ctor, goes to super ctor
	public PanelHelper()
	{
		super();
	}
	//ctor, takes in GUI, sets it to data
	public PanelHelper(GUI frame)
	{
		f = frame;
	}
	//is a getter for the GUI object
	public GUI getF() {
		return f;
	}
}