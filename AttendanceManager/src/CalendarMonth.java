import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * Creates a month of year that contains absences organized by date. Each date
 * in the calendar contains the absence, along with the name of the person with
 * the absence, and the reason for the absence.
 * 
 * @author Divya
 * 
 */
public class CalendarMonth {
	private ArrayList<PersonalizedCalendarDate>[] calendar;

	private int year;
	private int month;

	/**
	 * Creates an calendar of all the absences for all employees of a given
	 * month. The absences contain the date, the name of the person with teh
	 * absence, and the reaosn for their absence.
	 * 
	 * @param month The month to be created. Where 1 = January, and 12 = December
	 * @param year The year of the date to be created
	 * @param data The date of the month of the year to be created.
	 */
	public CalendarMonth(int month, int year, EmployeeDatabase data) {
		this.year = year;
		this.month = month;
		calendar = (ArrayList<PersonalizedCalendarDate>[]) new ArrayList[32];
		for (int i =0; i < 32; i++)
			calendar[i] = new ArrayList<PersonalizedCalendarDate>();
		loadAbsences(data);
	}

	private void loadAbsences(EmployeeDatabase data) {

		Collection<Person> holder = data.getEmployees().values();

		for (Person e : holder) {
			ArrayList<AbsenceDate> absences = e.getDaysAbsentOfMonth(month);
			for (AbsenceDate a : absences) {
				int date = a.getDate();
				if (a.getYear() == year) {
					PersonalizedCalendarDate d1 = new PersonalizedCalendarDate(e.getName(), a);
					calendar[date].add(d1);
				}
			}

		}
	}

	
	public ArrayList<PersonalizedCalendarDate>[] getMonthDates() {
		return calendar;
	}
	
	public  ArrayList<PersonalizedCalendarDate> getDateAbsences(int date){
		return calendar[date];
	}
	
	
	public String getPersonAbsences(int date){
		ArrayList<PersonalizedCalendarDate> holder = calendar[date];
		String absences = "";
		for(int i=0; i<holder.size(); i++){
			absences+=holder.get(i).getDate();
			absences+="\n";
		}
		return absences;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
}
