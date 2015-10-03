import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates a panel to be placed on the Add Employee Card for the AttendanceManager. This panel
 * contains all the buttons and the textfields, and provided information to the database
 * and updates the calendar and program according the information entered.
 * @author Divya
 *
 */
public class CreationPanel extends JPanel implements ActionListener {

	private UserOptionWindow a;
	private JTextField name;
	private JTextField age;
	private JTextField job;
	private JTextField vacationDays;
	private JButton addPerson;
	private EmployeeDisplayPanel edp;
	private EmployeeDatabase ed;



	/**
	 * Creates the CreationPanel object.
	 * @param a The main program that contains the add employee card.
	 * @param edp The display panel that should display the updated information, that is ideally connected to the Add Employee card.
	 */
	public CreationPanel(UserOptionWindow a, EmployeeDisplayPanel edp){
		this.a= a;
		this.edp = edp;

		ed = a.getDatabase();

		edp.addCardInPlace(); 
		setLayout (new GridLayout(5,1));

		name = new JTextField("Enter Employee Name", 30);
		name.addActionListener(this);

		age = new JTextField("Enter Employee Age", 30);
		age.addActionListener(this);

		job = new JTextField("Enter Employee Job", 30);
		job.addActionListener(this);

		vacationDays = new JTextField("Enter Vacation Days", 30);
		vacationDays.addActionListener(this);

		addPerson = new JButton("Create Person");
		addPerson.addActionListener(this);

		add(name);
		add(age);
		add(job);
		add(vacationDays);
		add(addPerson);
	}


	private boolean isNumeric(String str)  
	{  
		try  
		{  
			int d = Integer.parseInt(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String eName = name.getText();
		name.selectAll();

		String eAge = age.getText();
		age.selectAll();

		String  eJob= job.getText();
		job.selectAll();

		String  eVDays= vacationDays.getText();
		job.selectAll();


		if(e.getActionCommand().equals("Create Person")){
			if(!ed.getEmployees().containsKey(eName)){
				if(!eName.isEmpty()  && !eAge.isEmpty() && !eJob.isEmpty() && !eVDays.isEmpty()){
					if(isNumeric(eAge) && isNumeric(eVDays)){
						if(!eJob.equalsIgnoreCase("Enter Employee job") && !eName.equalsIgnoreCase("Enter Employee Name") ){
							a.addToDatabase(eName, eAge, eJob, eVDays);
							edp.employeeAdded(eName, eAge, eJob, eVDays);
							edp.repaint();
						}
					}
				}


			}

		}
	}
}
