

/**
 * Creates a calendardate that contains the name of the person, their absence date, and the reason for their absence.
 * @author Divya
 *
 */
public class PersonalizedCalendarDate {
	private String name;
	private AbsenceDate date;
	
	/**
	 * Creates the calendar date object.
	 * @param name The name of the person who has this absence
	 * @param date The date of the absence, along with its reason
	 */
	public PersonalizedCalendarDate(String name, AbsenceDate date){
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public AbsenceDate getDate() {
		return date;
	}
	
	/**
	 * Returns the name followed by a space, a semicolon, and the reason for their absence on this day.
	 * @return A string containing the name of the person, and the reason for the person's absence. 
	 */
	public String getAbsence(){
		return name + " : " + date.getReason();
	}

	
	
}
