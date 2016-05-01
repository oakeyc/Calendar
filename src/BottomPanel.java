
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * is the bottom panel
 * has buttons on it to move from month to month
 * 
 * @author courtney Oka
 * 6/10/14
 *
 */
public class BottomPanel extends PanelHelper implements ActionListener
{
	private JButton next;
	private JButton prev;
	
	/**
	 * ctor
	 * @param frame
	 * makes buttons and adds them
	 */
	public BottomPanel(GUI frame)
	{
		super(frame);
				
		next = new JButton("next");
		prev = new JButton("previous");
		next.addActionListener(this);
		prev.addActionListener(this);
		add(prev, BorderLayout.EAST);
		add(next, BorderLayout.WEST);
	}

	/**
	 * @Override
	 * takes in an ActionEvent
	 * if it's the next button, goes to the next month
	 * if previous, goes to the previous month
	 */
	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getActionCommand().equals("next"))
		{
			super.getF().getCal().nextMonth();
			super.getF().getWord().setMonth(super.getF().getCal().getMonth() );
			super.getF().getWord().setYear(super.getF().getCal().getYear()+ "");

			super.getF().getCal().repaint();
			
		}
		else if(e.getActionCommand().equals("previous"))
		{
			super.getF().getCal().previousMonth();
			super.getF().getWord().setMonth(super.getF().getCal().getMonth() );
			super.getF().getWord().setYear(super.getF().getCal().getYear() + "");

			super.getF().getCal().repaint();
		}
	}	
}
