
public class TesterMain {

	/**
	 * @param args
	 */
	
	private static final int VACATION_DAYS = 30;
	public static void main(String[] args) {
	
		
		
		EmployeeDatabase database = new EmployeeDatabase();
		
		
		Person p1 = new Person("Divya", "Police", 24, VACATION_DAYS);
		
		
		//Check to see if this throws an error if given a weird date as an absence
		//p1.addAbsence(1995, 1, 45, "TestReason");
		p1.addAbsence(2005, 5, 30, "Vacation");
		p1.addAbsence(2005, 1, 31, "Sick");
		p1.addAbsence(1998, 2, 28, "Other");
		
		
		
		Person p2 = new Person ("Tasmine", "Doctor", 26, VACATION_DAYS);
		p2.addAbsence(2005, 1, 13, "Work Day");
		p2.addAbsence(1998, 2, 28, "Relgious Fucntion");
		
		//Check to see the differentiation between the reasons for absence, and the effect on the vacation days
		
		//Check to see if it loads all the months properly into the year
		//Check to see if it only loads days for one month
		//Check to see if it only loads days for that month and that year
		
		
		database.addEmployee(p1);
		database.addEmployee(p2);
		
		
		CalendarMonth may = new CalendarMonth(1, 2005, database);
		System.out.println(may.getMonth());
	}

}
