import java.util.Date;


/**
 * Creates an object that holds the date of the absence along with the 
 * the reason for the absence.
 * @author Divya
 *
 */
public class AbsenceDate{
	private int year;
	private  int month;
	private int date; 
	private String reason;
	
	
	/**
	 * Creates the object.
	 * @param year The year of the date of the absence.
	 * @param month The month of the date of the absence. 
	 * @param day	The date of the month 
	 * @param reason The reason for the absencce.
	 */
	public AbsenceDate(int year, int month, int day, String reason){
		this.year = year;
		this.date = day;
		this.month = month;
		this.reason = reason;
	}
	
	
	
	/**
	 * Returns the date and reason for the absence in string format.
	 * @return String of the absence and date  
	 */
	public String toString(){
		return "Reason for absence on: " + month + "/" + date + "/" + year + " is " + reason;
		
	}
	
	
	
	/**
	 * Changes the reason for the absence
	 * @param reason The new reason for the absence on that day
	 */
	public void setReason(String reason){
		this.reason = reason;
	}
	
	
	public String getReason(){
		return reason;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDate(){
		return date;
	}
	
	public int getYear(){
		
		return year;
	}
	
	
	
	/**
	 * Returns the integer format of the date in the form of an array, where the first index is the month, the second is the date, and the third is the year.
	 * 
	 * @return the int array for mat of the date
	 */
	public int[] getJustDate(){
		int[] dates = new int[3];
		dates[0] = month;
		dates[1] = date;
		dates[2] = year;
		return dates;
	}


	/**
	 * Returns the American number representation of the date. For example
	 * May 3rd, 2014 would be returned as 5/3/2014
	 * @return String of numerical representation of date.
	 */
	public String getStrungDate() {
		return month+ "/" + date + "/" + year;
	}
	

	
}
