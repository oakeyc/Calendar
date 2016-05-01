/*
 * for the calendar
 * has a name
 * date
 * and duration: to be worked on in the future, currently everything defaults to 24 hours
 * 
 * @author Courtney Oka
 * 6/10/14
 */
public class Appointment 
{
	private String name;
	private String date;
	private int duration;
	
	private String timeStart;
	private String timeEnd;
	
	/**
	 * takes in the name
	 * the date it is in form "DD/MM/YYYY"
	 * then the number of hours something persists
	 */
	public Appointment(String name, String date, int duration)
	{
		this.name = name;
		this.date = date;
		this.duration = duration;
	}
	
	/**
	 * 
	 * @param name
	 * @param date
	 * calls other ctor
	 */
	public Appointment(String name, String date)
	{
		this(name, date, 24);
	}
	
	/**
	 * testing,
	 * not necessarily needed
	 * returns the string with the information
	 */
	public String toString()
	{
		return name +" on "+ date + " for "+ duration + " hours";
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the timeStart
	 */
	public String getTimeStart()
	{
		return timeStart;
	}

	/**
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(String timeStart) 
	{
		this.timeStart = timeStart;
	}

	/**
	 * @return the timeEnd
	 */
	public String getTimeEnd() 
	{
		return timeEnd;
	}

	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(String timeEnd) 
	{
		this.timeEnd = timeEnd;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
