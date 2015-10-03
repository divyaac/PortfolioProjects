import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates a panel that allows the user to add an absence to an already existing employee. This holds
 * all the new entered information about the employee.
 * @author Divya
 *
 */
public class EmployeeEditPanel extends JPanel implements ActionListener{
	UserOptionWindow a;
	private Person p1;
	private boolean selected;
	JTextField absenceMonth;
	JTextField dateOfAbsence;
	JTextField yearOfAbsence;
	JTextField reason;
	private EmployeeDisplayPanel display;

	JButton edit;



	/**
	 * Creates the panel
	 * @param a The main window that contains the Editcard.
	 * @param display The display that it connects to in the EditCard. This display card will graphically show the updated person.
	 */
	public EmployeeEditPanel(UserOptionWindow a, EmployeeDisplayPanel display){
		this.a = a;
		this.display = display;
		setLayout (new GridLayout(5,1));

		absenceMonth = new JTextField("Enter Month of Absence", 30);
		absenceMonth.addActionListener(this);

		dateOfAbsence = new JTextField("Enter Date of Absence", 30);
		dateOfAbsence.addActionListener(this);

		yearOfAbsence = new JTextField("Enter Year of Absence", 30);
		yearOfAbsence.addActionListener(this);

		reason = new JTextField("Enter Reason for Absence", 30);
		reason.addActionListener(this);

		edit = new JButton("Edit Employee");
		edit.addActionListener(this);




		add(absenceMonth);
		add(dateOfAbsence);
		add(yearOfAbsence);
		add(reason);
		add(edit);


	}

	private void updateDatabase(String month, String date, String year, String reason){
		if(isNumeric(month) && isNumeric(date) && isNumeric(year)){
			if(!reason.equalsIgnoreCase("Enter Reason for Absence")){
				if(checkAllOthers(month, date, year, reason))
					if(dateNotAlreadyPresent(month, date, year)){
						a.updateDatabase(Integer.parseInt(month), Integer.parseInt(date), Integer.parseInt(year), reason, p1);
					}
			}
		}
	}




	private boolean dateNotAlreadyPresent(String month, String date, String year) {
		int nmonth = Integer.parseInt(month);
		int ndate = Integer.parseInt(date);
		int nyear = Integer.parseInt(year);
		ArrayList<AbsenceDate> absences = p1.getDaysAbsentOfMonth(nmonth);
		for(AbsenceDate a: absences){
			if(a.getDate()==ndate && a.getYear()==nyear){
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String month = absenceMonth.getText();
		absenceMonth.selectAll();

		String date = dateOfAbsence.getText();
		dateOfAbsence.selectAll();

		String  year= yearOfAbsence.getText();
		yearOfAbsence.selectAll();

		String  reasonForAbsence= reason.getText();
		reason.selectAll();


		if(e.getActionCommand().equals("Edit Employee")){
			if(!month.isEmpty()  && !date.isEmpty() && !year.isEmpty() && !reasonForAbsence.isEmpty()){

				updateDatabase(month, date, year, reasonForAbsence);
				a.updateMonth();
				display.repaint();
			}
		}

	}

	private boolean checkAllOthers(String month, String date, String year,
			String reasonForAbsence) {
		int nmonth = Integer.parseInt(month);
		int ndate = Integer.parseInt(date);
		int nyear = Integer.parseInt(year);
		if(ndate>0  && ndate<32){
			if(nmonth>0 && nmonth<13){
				if(nyear>1900 && nyear<2500){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Sets that an employee was searched, and found. An employee to be edited is set.
	 * @param p12 The employee to the be edited.
	 */
	public void employeeSelected(Person p12) {
		this.p1 = p12;
		selected = true;

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
}
