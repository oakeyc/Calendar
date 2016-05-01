import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;

/*
 * makes a calendar with days
 * is a Hashtable
 * 
 * @author Courtney Oka
 * 6/10/14
 */
public class Calendar
{
	protected Hashtable<String, LinkedList<Appointment>> tab; // the key will be a String hold LinkedList of Appoints
	/**
	 * ctor
	 * makes a new Hashtable
	 */
	public Calendar()
	{
		tab = new Hashtable<String, LinkedList<Appointment>>(); // hold strings to the appointments
	}

	/**
	 * @param time which is a date in DD/MM/YY
	 * @param an appointment to add
	 * adds that appointment
	 * returns nothing
	 */
	public void addAppointment(String time, Appointment a)
	{
		if(tab.get(time)== null)//if there is one, get it
		{
			LinkedList<Appointment> app = new LinkedList<Appointment>();
			app.add(a);
			tab.put(time, app);
		}
		else
		{
			tab.get(time).add(a);
		}
	}

	/**
	 * @param time which is a date in DD/MM/YY
	 * @param an appointment to cancel
	 * removes that appointment
	 */
	public void cancelAppointment(String key, Appointment a)
	{
		tab.get(key).remove(a);
	}

	/*
	 * @param time which is a date in DD/MM/YY
	 * @param the name of an appointment to cancel
	 * removes that appointment
	 */
	public void cancelAppointment(String key, String app)
	{
		LinkedList<Appointment> a = tab.get(key);

		for(Appointment ap: a)
		{
			if(ap.getName().equals(app))
			{
				a.remove(ap);
			}
		}
	}

	/**
	 * 	 * @param time which is a date in DD/MM/YY
	 * returns the linkedlists of appointments for that day
	 */
	public LinkedList<Appointment> getDaysAppointments(String str)
	{
		return tab.get(str);//return all at that day?
	}

	/**
	 * 	 * @param time which is a date in DD/MM/YY
	 *returns the number of appointments on that day
	 */
	public int numOfAppsOnDay(String key)
	{
		if(tab.get(key)==null)
			return 0;
		else
			return tab.get(key).size();
	}

	//	public double efffCalc(Appointment a)
	//	{
	//		return 0;
	//	}
}
