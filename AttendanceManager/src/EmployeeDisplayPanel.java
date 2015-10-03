import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * A display panel that graphically displays all the information of a give employee. The information
 * displayed includes all of they days absent, and all of the employee information.The display updates 
 * every time the employee is edited.
 * @author Divya
 *
 */
public class EmployeeDisplayPanel extends JPanel implements MouseListener{
	Person p1;
	private boolean employeeSelected;
	private UserOptionWindow a;
	private boolean addPanel = false;

	/**
	 * Creates this display panel
	 * @param a The main window that contains the edit/add card, that will in turn contin the panel.
	 */
	public EmployeeDisplayPanel(UserOptionWindow a){
		super();
		this.a = a;
		employeeSelected = false;
		addMouseListener(this);
	}



	public void paintComponent(Graphics g)
	{
		super.paintComponent(g); 
		Graphics2D g2 = (Graphics2D)g;

		int width = getWidth();
		int height = getHeight();

		Font fontInfo = new Font("SansSerif", Font.PLAIN, 16);
		g2.setFont(fontInfo);
		FontMetrics metrics = g2.getFontMetrics();
		
		

	    
	    
		if(employeeSelected){

		
			g2.drawString("Name: " + p1.getName(), (width / 4)-(metrics.getMaxAdvance()), (height / 4) + (metrics.getHeight()) );
			g2.drawString("Age: " + p1.getAge(), (width / 4)-(metrics.getMaxAdvance()), (height / 4) + (metrics.getHeight())*2 );
			g2.drawString("Job: " + p1.getJob(), (width / 4)-(metrics.getMaxAdvance()), (height / 4) + (metrics.getHeight())*3 );
			g2.drawString("Vacation Days Left: " + p1.getVacationDaysLeft(), (width / 4)-(metrics.getMaxAdvance()), (height / 4) + (metrics.getHeight())*4 );
			g2.drawString("Absence Dates: ", (width / 4)-(metrics.getMaxAdvance()), (height / 4) + (metrics.getHeight())*5 );

			ArrayList<AbsenceDate> dates = p1.getAllDaysAbsent();
			for(int i=0; i<dates.size(); i++){
				String holder = dates.get(i).getStrungDate() + ": " + dates.get(i).getReason();
				g2.drawString(holder, (width / 4), (height / 4) + (metrics.getHeight())*(i+6) );


				
			}
			Font fontInfo2 = new Font("SansSerif", Font.PLAIN, 12);
			g2.setFont(fontInfo2);
			g2.setColor(Color.BLUE);
		    g2.drawRect(0, 0, width / 6, height / 12);
		    
		    g2.setColor(Color.BLUE);
		    g2.drawString("BACK" , width / 15, height / 18);
		    
		}else if(addPanel ){
			Font fontInfo2 = new Font("SansSerif", Font.PLAIN, 12);
			g2.setFont(fontInfo2);
			g2.setColor(Color.BLUE);
		    g2.drawRect(0, 0, width / 6, height / 12);
		    
		    g2.setColor(Color.BLUE);
		    g2.drawString("BACK" , width / 15, height / 18);
			
			
		}else{
		   
			g2.setColor(Color.BLUE);
		    g2.drawRect(0, 0, width / 6, height / 12);
		    
		    g2.setColor(Color.BLUE);
		    g2.drawString("BACK" , width / 15, height / 18);
			}
		}
	

	//makes spots for the people not attending



	/**
	 * Sets whether an employee to edit was selected
	 * @param p12 The person that was searched and found in the databse by the user.
	 */
	public void employeeSelected(Person p12) {
		p1 = p12;
		employeeSelected = true;

	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(x <= (getWidth()/6) && y <= (getHeight()/12) ){
			a.backSelected();
			a.changeCard();
			
		}
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void addCardInPlace() {
		addPanel = true;
		
	}



	public void employeeAdded(String eName, String eAge, String eJob,
			String eVDays) {
		p1 = new Person(eName, eJob, Integer.parseInt(eAge), Integer.parseInt(eVDays));
		employeeSelected = true;
		
	}
}
