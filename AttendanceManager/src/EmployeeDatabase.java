import java.util.ArrayList;
import java.util.HashMap;


/**
 * Creates a database of the employees, their absences, and the reasons for their absences.
 * @author Divya
 *
 */
public class EmployeeDatabase {
	private HashMap<String, Person> employees;
	
	/**
	 * Creates the database object
	 */
	public EmployeeDatabase(){
		employees = new HashMap<String, Person>();
	}
	
	/**
	 * Adds an employee to the database.
	 * @param p1 Person to be added
	 */
	public void addEmployee(Person p1){
		employees.put(p1.getName(), p1);
	}
	
	
	public HashMap<String, Person> getEmployees(){
		return employees;
	}
	
	/**
	 * Changes the person given in the database
	 * @param searchName The name of the person to be edited
	 * @param edited The person to be put in place of the old name.
	 * 
	 * If the person is the same, but information as been changed, a new person with the changed information will be put in.
	 */
	public void editEmployees(String searchName, Person edited){
		if(edited.getName().equalsIgnoreCase(searchName)){
			employees.put(searchName, edited);
		}else{
			employees.remove(searchName);
			employees.put(edited.getName(), edited);
		}
	}
}
