import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * This is a the top panel
 * it hold displays the month year, and days of week
 * 
 * @author Courtney Oka
 * 6/10/14
 */
public class WordsPanel extends PanelHelper
{
	private JLabel month;
	private JLabel year;

	/**
	 * @param frame
	 * makes the days appear above their day
	 * makes the month and year appear correctly
	 * ctor
	 */
	public WordsPanel(GUI frame)
	{
		super(frame);
		JPanel contentPane = new JPanel(new GridLayout(1,7));

		setLayout(new BorderLayout());
		JLabel sun = new JLabel("Sunday");
		sun.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel mon = new JLabel("Monday");
		mon.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel tus = new JLabel("Tuesday");
		tus.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel wed = new JLabel("Wednesday");
		wed.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel thu = new JLabel("Thursday");
		thu.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel fr = new JLabel("Friday");
		fr.setFont(new Font("TimesNewRoman", Font.BOLD, 24));
		JLabel sa = new JLabel("Saturday");
		sa.setFont(new Font("TimesNewRoman", Font.BOLD, 24));

		JPanel contentPane2 = new JPanel();

		month = new JLabel(numMonthToWords(super.getF().getCal().getMonth()) + "");
		month.setFont(new Font("TimesNewRoman", Font.BOLD, 24));

		year = new JLabel(super.getF().getCal().getYear() + "");
		year.setFont(new Font("TimesNewRoman", Font.BOLD, 24));

		contentPane.add(sun);
		contentPane.add(mon);
		contentPane.add(tus);
		contentPane.add(wed);
		contentPane.add(thu);
		contentPane.add(fr);
		contentPane.add(sa);

		contentPane2.add(month);
		contentPane2.add(year);

		add(contentPane, BorderLayout.SOUTH);
		add(contentPane2, BorderLayout.NORTH);

		contentPane.setBackground(new Color(139,18,238));
		contentPane2.setBackground(new Color(139,18,238));
	}

	/*
	 * takes in a month
	 * returns the name of that month
	 */
	public String numMonthToWords(int m)
	{
		if(m==1)
			return "January";
		else if(m==2)
			return "February";
		else if(m==3)
			return "March";
		else if(m==4)
			return "April";
		else if(m==5)
			return "May";
		else if(m==6)
			return "June";
		else if(m==7)
			return "July";
		else if(m==8)
			return "August";
		else if(m==9)
			return "September";
		else if(m==10)
			return "October";
		else if(m==11)
			return "November";
		else if( m==12)
			return "December";
		else
			return "error";
	}

	/**
	 * @return the month
	 */
	public String getMonth() 
	{
		return month.getText();
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) 
	{
		this.month.setText(numMonthToWords(month));
	}

	/**
	 * @return the year
	 */
	public String getYear()
	{
		return year.getText();
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year.setText(year);
	}
}
