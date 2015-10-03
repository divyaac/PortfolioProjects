import java.util.ArrayList;
import java.util.Date;


/**
 * Creates a class  of Person, with the age, job, vacation days, and absences.
 * @author Divya
 *
 */
public class Person {
	private String name;
	private String job;
	private int age;
	
	private  int vacationDaysLeft;
	private ArrayList<AbsenceDate> datesMissed;

	
	
	/**
	 * Creates the person object.
	 * @param name The name of the person
	 * @param job The occupation of the person
	 * @param age The age of the person
	 */
	public Person(String name, String job, int age, int vacationDays){
		this.name = name;
		this.job = job;
		datesMissed = new ArrayList<AbsenceDate>();
		vacationDaysLeft = vacationDays;
		this.age = age;

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * Returns how many vacation days this person has left.
	 * @return
	 */
	public int getVacationDaysLeft() {
		return vacationDaysLeft;
	}


	
	public void setVacationDaysLeft(int vacationDaysLeft) {
		this.vacationDaysLeft = vacationDaysLeft;
	}
	
	/**
	 * Adds an absence to the person's list of absences. If the absence is either unexcused, vacation, or any other reason, the number
	 * of vacation days left for that person is reduced.
	 * @param year The year of the absence.
	 * @param month The month of the absence (where 1 = January and 12 = December)
	 * @param day The date of the of the absence in the specified month and year
	 * @param reason The reason for the absence. 
	 */
	public void addAbsence(int year, int month, int day , String reason){
		if(day>31){
			throw new IllegalArgumentException("Enter a valid date");
		}
	
		
		datesMissed.add(new AbsenceDate(year, month, day, reason));
	
		if(reason.equalsIgnoreCase("vacation") || reason.equalsIgnoreCase("unexcused") || reason.equalsIgnoreCase("other")){
			vacationDaysLeft--;
		}
		if(vacationDaysLeft <0){
			vacationDaysLeft = 0;
		}
	}
	
	
	
	/**
	 * Strings the name, the job, and the age of the person.
	 */
	public String toString(){
		return getName() + ", " + getJob() + ", " + getAge();
	}
	
	/**
	 * Strings together the days and the reason for absence
	 * @return
	 */
	public String daysAbsent(){
		String holder = "";
		for(int i=0; i<datesMissed.size(); i++){
			holder+= datesMissed.get(i).getJustDate() + ": " + datesMissed.get(i).getReason();
			holder+= '\n';
		}
		
		return holder;
	}
	
	/**
	 * Returns all the days absence for this person.
	 * @return All the days absent for this person.
	 */
	public ArrayList<AbsenceDate> getAllDaysAbsent(){
		return datesMissed;
	}
	

	
	
	/**
	 * Returns the absences for a specified month.
	 * @param month The month of the absences for the person, where 1 = January, and 12 = December
	 * @return Arraylist of dates missed along with their reasons. 
	 */
	public ArrayList<AbsenceDate> getDaysAbsentOfMonth(int month){
		ArrayList<AbsenceDate> holder = new ArrayList<AbsenceDate>();
		for(AbsenceDate e: datesMissed){
			if(e.getMonth()== month){
				holder.add(e);
			}
		}
		
		return holder;
		
		
		
		
		
	}

	
	
}
