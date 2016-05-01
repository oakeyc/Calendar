import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * is the body of the program
 * generates the days and buttons
 * is a PanelHelper
 * and listens for its buttons
 * @author courtney Oka
 * 6/10/14
 */
public class CalendarPanel extends PanelHelper implements ActionListener
{
	private int month;
	private int year;
	private Calendar cal;

	/**
	 * ctor
	 * takes in a GUI
	 * send to other ctor
	 */
	public CalendarPanel(GUI frame)
	{
		this(frame, 6, 2014);		
	}

	/**
	 * takes in a GUI, a month, and a year
	 * uses a GridLayout
	 * generates the dates for that month and year
	 */
	public CalendarPanel(GUI frame, int m, int y)
	{
		super(frame);
		cal = new Calendar();

		month = m;
		year = y;

		setLayout(new GridLayout(6,7));
		((GridLayout)getLayout()).setHgap(1);
		((GridLayout)getLayout()).setVgap(1);

		generateDates(m , y);

	}

	/**
	 * takes in a month
	 * takes in a year
	 * creates a grid of buttons
	 * if there is an appointment, the button is blue
	 * otherwise it is normal color
	 * returns nothing
	 */
	public void generateDates(int m, int y) 
	{
		int i = 1;
		int numOfDays = daysInMonth(m ,y);
		JButton but;
		int firstDay;
		int counter = 0;

		Set<String> keys = cal.tab.keySet();
		ArrayList<String> eventDays = new ArrayList<String>();
		for(String k: keys)
		{
			String kBeg = k.substring(0, 2);
			String kEnd = k.substring(3);
			String month = "" + m;
			if(m<10)
				month = "" + 0 + m;
			if(kEnd.equals(month +"/"+y))
			{
				eventDays.add(kBeg);
			}
		}

		while(i<numOfDays +1)
		{
			if(i==1)
			{
				firstDay = dayOfMonth(1, m, y);
				if(firstDay == 0)
					firstDay = 7;
				counter += firstDay;
				while(firstDay>i)
				{
					JButton non =new JButton("");
					non.setEnabled(false);
					add(non);
					firstDay--;
				}
			}
			but = new JButton("" + i);
			if(i<10)
				but.setActionCommand(0 + "" + i);
			for(String str: eventDays)
			{
				if(str.equals(but.getActionCommand()))
					but.setBackground(new Color(13,54,239));

			}
			but.addActionListener(this);
			add(but);
			i++;
			counter++;
		}
		while(counter<=42)
		{
			JButton non =new JButton("");
			non.setEnabled(false);
			add(non);
			counter++;
		}
	}

	/**
	 * takes in nothing
	 * generates the dates for the next month
	 * returns nothing
	 */
	public void nextMonth()
	{
		removeAll();
		if(month!=12)
		{
			month++;
		}
		else
		{
			month = 1;
			year++;
		}
		generateDates(month, year);
	}

	/**
	 * takes in nothing
	 * generates the dates for the previous month
	 * returns nothing
	 */
	public void previousMonth()
	{
		removeAll();
		if(month!=1)
		{
			month--;
		}
		else
		{
			month = 12;
			year--;
		}
		generateDates(month, year);
	}

	/**
	 *  @param year
	 * @return whether that year is a leap year or not
	 */
	public boolean leapYear(int y)
	{
		return (y%4==0) && ((y% 100!=0) || (y%400==0));
	}

	/*
	 * receives the month number and year number
	 * returns the number of days in that month and year
	 */
	public int daysInMonth(int m, int y)
	{
		if(m==4 || m==9 || m==6 || m==11)
			return 30;
		else if(m==2)
			if(leapYear(y))
				return 29;
			else
				return 28;
		else
			return 31;
	}

	/*
	 * takes in a month
	 * returns the respective number for a formula
	 * numbers are relatively random
	 */
	private int changeIntoMonthTable(int month)
	{
		if(month ==1)
			return 0;
		else if (month == 2)
			return 3;
		else if (month == 3)
			return 3;
		else if (month == 4)
			return 6;
		else if (month == 5)
			return 1;
		else if (month == 6)
			return 4;
		else if (month == 7)
			return 6;
		else if (month == 8)
			return 2;
		else if (month == 9)
			return 5;
		else if (month == 10)
			return 0;
		else if (month == 11)
			return 3;
		else
			return 5;
	}

	/**
	 * gregorian cal
	 * @param year
	 * @return the corresponding number for the century because of the gregorian calculation
	 */
	private int changeIntoCenturyTable(int year)
	{
		int century = (year/100)%4;
		if(century == 0)
			return 0;
		else if (century == 1)
			return 5;
		else if(century == 2)return 3;
		else if(century == 3) return 1;
		else return -1; // not in the right range
	}

	/**
	 * 
	 * @param year
	 * @return the corresponding number for the year because of the gregorian calculation
	 */
	private int changeIntoYearTable(int y)
	{
		String year =""+ y%100;
		int yr = y%100;
		if(year.compareTo("" + 00)==0
				|| yr == 6 || yr== 17 || yr==23 || yr==34
				|| yr == 45 || yr == 56 | yr == 62 || yr==73 
				|| yr == 79 || yr==84 || yr ==90)
			return 0;
		else if(yr == 1	|| yr == 7	|| yr == 12|| yr == 18|| yr == 29|| yr == 35|| 
				yr == 40|| yr == 46|| yr == 57|| yr == 63
				|| yr == 68|| yr == 74|| yr == 85|| yr == 91|| yr == 96	)
			return 1;
		else if(yr == 2	|| yr == 13|| yr == 19|| yr == 24||
				yr == 30|| yr == 41|| yr == 47|| yr == 52||
				yr == 58|| yr == 69|| yr == 75|| yr == 80|| yr == 86|| yr == 97	)
			return 2;
		else if( yr == 3|| yr == 8|| yr == 14|| yr == 25|| 
				yr == 31|| yr == 36|| yr == 42|| yr == 53|| yr == 59||
				yr == 64|| yr == 70|| yr == 81|| yr == 87|| yr == 92|| yr == 98)
			return 3;
		else if(yr ==9|| yr ==15|| yr ==20|| yr ==26|| yr ==37|| yr ==43||
				yr ==48|| yr ==54|| yr ==65|| yr ==71|| yr ==76|| yr ==82|| yr ==93|| yr ==	99) 
			return 4;

		else if(yr ==4|| yr ==10|| yr ==21|| yr ==27||
				yr ==32|| yr ==38|| yr ==49|| yr ==55|| yr ==60||
				yr ==66|| yr ==77|| yr ==83|| yr ==88|| yr == 94	)
			return 5;
		else 
			return 6;
	}

	/*
	 * takes in the numerical day month and year, logical numbers
	 * uses kraitchik's algorithm to return which day of the week that day is
	 * sunday is 1 saturday is 0
	 */
	public int dayOfMonth(int day, int month, int year)
	{
		return (day + changeIntoMonthTable(month) + changeIntoCenturyTable(year) +  changeIntoYearTable(year) ) %7; 
	}

	//@Override
	/**
	 * gets an ActionEvent, we are going to make appointments
	 * it opens dialogs with the user
	 * maybe some null pointer exceptions somewhere
	 * returns nothing
	 */
	public void actionPerformed(ActionEvent e) 
	{
		String m = "" + month ;
		if(month<10)
			m = "" + 0+ month;
		String date =e.getActionCommand()+ "/" + m + "/" + year;

		String[] choices = {"View Schedule", "Add Appointment", "Cancel Appointment"};
		String picked = (String)JOptionPane.showInputDialog(this, "For " + m + "/"+e.getActionCommand() + "/" + year + " What Do You Want To Do? "
				, "You're Options", JOptionPane.QUESTION_MESSAGE
				, null, choices, choices[0]);

		if(picked == null)return;
		if(picked.equals("View Schedule"))
		{
			String[] apps =new String[cal.numOfAppsOnDay(date)];//fix lal lalal la

			if(apps.length==0)
				JOptionPane.showMessageDialog(this,"There are no appointments today");
			else
			{
				int counter = 0;
				for( Appointment a: cal.getDaysAppointments(date))
				{
					apps[counter] = a.getName();
					counter++;
				}
				JOptionPane.showMessageDialog(this, apps);
			}

		}
		else if(picked.equals("Add Appointment"))
		{
			String input =  JOptionPane.showInputDialog(this,"What is your appointment?");
			if(input==null || input.equals(""))return;
			Appointment ap = new Appointment(input,date);
			cal.addAppointment(date, ap);
			((JButton)e.getSource()).setBackground(new Color(13,54,239));
		}
		else if(picked.equals("Cancel Appointment"))
		{
			if(cal.getDaysAppointments(date)!=null)
			{
				String[] apps =new String[cal.numOfAppsOnDay(date)];//fix lal lalal la

				int counter = 0;
				for( Appointment a: cal.getDaysAppointments(date))
				{
					apps[counter] = a.getName();
					counter++;
				}

				String cancel = (String)JOptionPane.showInputDialog(this, "For " + m + "/"+e.getActionCommand() + "/" + year + 
						" Which Would You Like to Cancel? "
						, "You're Options", JOptionPane.QUESTION_MESSAGE
						, null, apps, apps[0]);
				cal.cancelAppointment(date, cancel);

				if(cal.numOfAppsOnDay(date)==0)
				{
					((JButton)e.getSource()).setBackground(new JButton().getBackground());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"There are no appointments today");
			}
		}
	}

	/**
	 * @return the cal
	 */
	public Calendar getCal() {
		return cal;
	}

	/**
	 * @param cal the cal to set
	 */
	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
}
