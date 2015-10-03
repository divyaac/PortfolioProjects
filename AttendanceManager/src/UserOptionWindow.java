import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 *This class creates the main window for an AttendenceManager that displays information of the month
 *of May in 2014. This main window changes cards, and updates the database when called by other cards and classes.
 * @author Divya
 *
 */
public class UserOptionWindow extends JFrame{

	JPanel cardPanel;
	private boolean editInfoClicked = false;
	private boolean calendarInfoClicked = false;

	public static void main(String[] args){


		UserOptionWindow mainWindow = new UserOptionWindow();
		




	}

	private static final int VACATION_DAYS = 30;

	Calendar c;
	PeopleCard pc;
	EmployeeEditCard ec;
	AddEmployeeCard ac;
	EditInfoCard eic;
	CalendarMonth month;
	int monthIndex;
	int lastDate;


	private int key;
	private int day;

	private EmployeeDatabase database = new EmployeeDatabase();
	private boolean addEmployeeSelected;
	private boolean editInfoSelected;
	private boolean backSelected = false;
	private String linesep;

	/**
	 * No args contructor for the UserOptionWindow
	 */
	public UserOptionWindow(){
		super();
		String dbFile = "";
		Properties prop = new Properties();
		InputStream input = null;
		FileReader datainput = null;
		try {
			 
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			dbFile = prop.getProperty("database");
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		loadDatabase(dbFile);

		monthIndex=5;
		month = new CalendarMonth(monthIndex, 2014, database);

		//Hardcoded last date of the month
		lastDate=31;

		day = 0;
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		cardPanel = new JPanel();
		CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);


		IntroWindow iw = new IntroWindow(this);
		iw.setBackground(Color.WHITE);
		iw.setName("1");
		cardPanel.add( iw, "1");

		c = new Calendar(this);
		c.setBackground(Color.WHITE);
		c.setName("2");
		cardPanel.add(c, "2");

		pc = new PeopleCard(this);
		pc.setBackground(Color.WHITE);
		pc.setName("3");
		cardPanel.add(pc,"3");

		ec = new EmployeeEditCard(this);
		ec.setBackground(Color.WHITE);
		ec.setName("4");
		cardPanel.add(ec, "4");

		ac = new AddEmployeeCard(this);
		ac.setBackground(Color.WHITE);
		ac.setName("5");
		cardPanel.add(ac, "5");

		eic = new EditInfoCard(this);
		eic.setBackground(Color.WHITE);
		eic.setName("6");
		cardPanel.add(eic, "6");




		add(cardPanel);

		setVisible(true);
		setResizable(true);
		//add different cards

	}





	/**
	 * Indicates that the user wants to edit/add info to the calendar. Not view the calendar.
	 */
	public void editInfoClicked(){
		editInfoClicked = true;
		calendarInfoClicked = false;
	}

	/**
	 * Indicates that the user wants to just view the calendar. Not edit/add info the calendar.
	 */
	public void calendarInfoClicked(){
		calendarInfoClicked = true;
		editInfoClicked =false;
	}


	/**
	 * This method changes the window of the JFrame
	 */
	public void changeCard(){




		Component c1 = cardPanel.getComponent(1);
		Component c2 = cardPanel.getComponent(2);
		Component c3 = cardPanel.getComponent(3);
		Component c4 = cardPanel.getComponent(4);
		Component c5 = cardPanel.getComponent(5);

		if(c1.isVisible()){
			if(c.getRect() == 100) {

				((CardLayout)cardPanel.getLayout()).show(cardPanel, "1");
				requestFocus();

			}
			else{
				day = c.getRect() - 3;


				pc.setRect(day);
				ArrayList<PersonalizedCalendarDate> holder = new ArrayList<PersonalizedCalendarDate>();
				holder = month.getDateAbsences(day);
				pc.setInfo(holder);
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "3");
				requestFocus();



			}
		}
		else if( c2.isVisible()){
			if(pc.getRect() == 100){
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "2");
				requestFocus();
			}

		}
		else if(c3.isVisible()){

			if(ec.getRect() == 100){

				((CardLayout)cardPanel.getLayout()).show(cardPanel, "3");
				requestFocus();

			}
			else if(addEmployeeSelected){
				addEmployeeSelected  = false;
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "5");
				requestFocus();
			}else if(editInfoSelected){
				editInfoSelected = false;
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "6");
				requestFocus();
			}else{
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "1");
				requestFocus();
			}

		}else if(c5.isVisible()){
			if(backSelected){
				backSelected = false;
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "4");
				requestFocus();
			}
		}else if(c4.isVisible()){
			if(backSelected){
				backSelected = false;
				((CardLayout)cardPanel.getLayout()).show(cardPanel, "4");
				requestFocus();
			}
		}

		else{
			if(editInfoClicked){

				((CardLayout)cardPanel.getLayout()).show(cardPanel, "4");
				requestFocus();
				editInfoClicked = false;
			}else if (calendarInfoClicked)

				((CardLayout)cardPanel.getLayout()).show(cardPanel, "2");
			requestFocus();
			calendarInfoClicked = false;
		}



	}


	/**
	 * Indicates that the user wants to add an employee, after they have decided to edit innfo on the calendar.
	 */
	public void AddEmployeeSelected() {
		addEmployeeSelected = true;
		editInfoSelected = false;

	}

	/**
	 * Indicates that the user wants to add an absence for an existing employee after they have decided to edit the info on the calendar.
	 */
	public void EditInfoSelected() {
		editInfoSelected = true;
		addEmployeeSelected = false;

	}



	private void loadDatabase() {
		Person p1 = new Person("Divya", "Lawyer", 24, VACATION_DAYS);


		//Check to see if this throws an error if given a weird date as an absence
		//p1.addAbsence(1995, 1, 45, "TestReason");
		p1.addAbsence(2014, 5, 16, "Vacation");
		p1.addAbsence(2005, 5, 31, "Sick");
		p1.addAbsence(1998, 2, 28, "Other");



		Person p2 = new Person ("Tasmine", "Doctor", 26, VACATION_DAYS);
		p2.addAbsence(2014, 5, 13, "Work Day");
		p2.addAbsence(2014, 5, 16, "Sick");
		p2.addAbsence(1998, 2, 28, "Relgious Fucntion");

		//Check to see the differentiation between the reasons for absence, and the effect on the vacation days

		//Check to see if it loads all the months properly into the year
		//Check to see if it only loads days for one month
		//Check to see if it only loads days for that month and that year


		database.addEmployee(p1);
		database.addEmployee(p2);

	}





	/**
	 * Adds the new Person to the dataabase, and the storage file.
	 * @param eName The name of the new person.
	 * @param eAge The age of the new person.
	 * @param eJob the job of the new person
	 * @param eVDays The number of vacation days for the new person.
	 */
	public void addToDatabase(String eName, String eAge, String eJob,
			String eVDays) {
		int age = Integer.parseInt(eAge);
		int vacationDays = Integer.parseInt(eVDays);
		Person p1 = new Person(eName, eJob, age, vacationDays);
		database.addEmployee(p1);
		month = new CalendarMonth(monthIndex, 2014, database);
		
		String dbFile = "";
		Properties prop = new Properties();
		InputStream input = null;
		FileReader datainput = null;
		try {
			 
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			dbFile = prop.getProperty("database");
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		exportDatabase(dbFile);


	}





	public EmployeeDatabase getDatabase() {
		return database;

	}





	public int getMonth() {

		return monthIndex;
	}





	/**
	 * Updates the datbase with the given person's new absece.
	 * @param month Month of the absence
	 * @param date Date of the absennce.
	 * @param year year of the absence.
	 * @param reason Reason for the absence.
	 * @param p1 Person that has this absence.
	 */
	public void updateDatabase(int month, int date, int year,
			String reason, Person p1) {
		String dbFile = "";
		Properties prop = new Properties();
		InputStream input = null;
		FileReader datainput = null;
		try {
			 
			input = new FileInputStream("config.properties");
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			dbFile = prop.getProperty("database");
			input.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if(date<=lastDate){
			p1.addAbsence(year, month, date, reason);
			database.editEmployees(p1.getName(), p1);
			exportDatabase(dbFile);
		}
	}





	/**
	 * Sets that the backbutton on any given card has been selected. Card will be changed accordingly.
	 */
	public void backSelected() {
		backSelected  = true;

	}





	/**
	 * The month reloads with the new database.
	 */
	public void updateMonth() {
		month = new CalendarMonth(monthIndex, 2014, database);

	}


	private void loadDatabase(String inputFile){
		String data = "";
		Scanner scan = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String linefromFile;
			while ((linefromFile = br.readLine()) != null) {
				String personInfo[] = linefromFile.split("\\|");
				Person p1 = new Person(personInfo[0], personInfo[1], Integer.parseInt(personInfo[2]), Integer.parseInt(personInfo[3]));
				for(int i=4; i<personInfo.length; i=i+4){
					p1.addAbsence(Integer.parseInt(personInfo[i]), Integer.parseInt(personInfo[i+1]), Integer.parseInt(personInfo[i+2]), personInfo[i+3]);
				}
				database.addEmployee(p1);
			}

		} catch (FileNotFoundException ex) {
			System.err.println("File not found in the computer");
		} catch (IOException ex) {
			ex.printStackTrace();

		}catch(NullPointerException ex){
			ex.printStackTrace();
		}
		finally {
			if (scan != null)
				scan.close();
		}

	}



	/**
	 * Copies all the information from the database to a textfile that contains all edits and data for multiple computers.
	 * @param outputFile
	 */
	public void exportDatabase(String outputFile) {
		FileWriter writ = null;
		String allData="";
		try {
			writ = new FileWriter(outputFile);
			HashMap<String, Person> employees = database.getEmployees();
			Set<String> names = employees.keySet();
			Iterator<String> it = names.iterator();
			while(it.hasNext()){
				Person p1 = employees.get(it.next());
				allData+=p1.getName()+"|"+p1.getJob()+"|"+p1.getAge()+"|"+p1.getVacationDaysLeft()+"|";
				ArrayList<AbsenceDate> dates = p1.getAllDaysAbsent();
				for(AbsenceDate d: dates){
					allData+=d.getYear()+"|"+d.getMonth()+"|"+d.getDate()+"|"+ d.getReason()+"|";
				}
				allData+=System.getProperty("line.separator");;


			}
			writ.write(allData, 0, allData.length());
			writ.flush();
		}catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (writ != null)
					writ.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}




