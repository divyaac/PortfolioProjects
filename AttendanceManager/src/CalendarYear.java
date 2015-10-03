
/**
 * Creates a calendar for the whole year, with months each filled with absence dates and the people with absences and the reasons for the absence.
 * @author Divya
 *
 */
public class CalendarYear {
	private EmployeeDatabase database;
	private int year;
	private CalendarMonth[] calendarYear;
	
	/**
	 * Creates the object
	 * @param database The employee database to be used to fill calendar
	 * @param year The year of absences to be created. This year will be the only year filled with absence dates from any dates that year
	 */
	public CalendarYear(EmployeeDatabase database, int year){
		this.database = database;
		this.year = year; 
		calendarYear = new CalendarMonth[13];
		
	}
	
	
	/**
	 * Fills the year with different calendar months for that year, each with all the absences.
	 */
	public void loadYear(){
		for(int i=0; i<12; i++){
			calendarYear[i] = new CalendarMonth(year, i, database);
		}
	}
	
	
	public CalendarMonth[] getCalendarYear(){
		return calendarYear;
	}
	
	public int getYear(){
		return year;
	}
	
	
	
	
}
