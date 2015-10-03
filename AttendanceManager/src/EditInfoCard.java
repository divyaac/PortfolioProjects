import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 * Creates a card where the User can edit the info of any already existing employee. This edit card can only add absence dates.First the user
 * must type in the name of the Employee into the top JTextfield.
 * This card will contain a display panel that will show the added absences, and employee info. This will also contain an edit panel
 * that allows the user to add absences for the given employee.
 * @author Divya
 *
 */
public class EditInfoCard extends JPanel implements ActionListener, MouseListener{
	private UserOptionWindow a;
	private Button create;
	private Button edit;
	private int key;
	EmployeeDisplayPanel edp;
	EmployeeEditPanel eep;
	
	private Person p1;
	
	private EmployeeDatabase ed;
	private JTextField name;

	
	/**
	 * Creates the EditInfoCard object
	 * @param a The main window that is to contain this card.
	 */
	public EditInfoCard(UserOptionWindow a){
		super();
		this.a =a;
		
		ed = a.getDatabase();
		
		
		setLayout(new BorderLayout());
		
		name = new JTextField("Enter Employee Name", 30);
		name.addActionListener(this);
		add(name, BorderLayout.NORTH);
		
		edp = new EmployeeDisplayPanel( a);
		add(edp, BorderLayout.CENTER);
		edp.setVisible(true);
		edp.setBackground(Color.WHITE);
		edp.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.GRAY));

		eep = new EmployeeEditPanel(a, edp);
		add(eep, BorderLayout.EAST);
		eep.setVisible(false);
		eep.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.GRAY));

		
		
		this.addMouseListener(this);
		key = 0;
		
	}
	
	 
		
	public void setRect(int i){
		key = i;
		
		
	}
	public int getRect(){
		return key;
	}
	
	@Override
	public void mouseClicked(MouseEvent ans) {
		int x= ans.getX();
		int y = ans.getY();
		int height = getHeight();
		int width = getWidth();
		if(x <= (this.getWidth()/6) && y <= (this.getHeight()/12) ){
			a.changeCard();
			
		}else if(y>=height/3 && y<=(height  / 3)+ (height/7)){
			if(x>=(width/6) && x<=(width/6)+ (width/3)){
				a.AddEmployeeSelected();
				a.changeCard();
			}else if(x>=(width * 2 / 3) && x<=(width * 2 / 3) + (width/3)){
				a.EditInfoSelected();
				a.changeCard();
			}
		}
		else if(x <= (getWidth()/6) && y <= (getHeight()/12) ){
				setRect(100);
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


	@Override
	public void actionPerformed(ActionEvent e) {
		String eName = name.getText();
		name.selectAll();
		if(ed.getEmployees().containsKey(eName)){
			p1 = ed.getEmployees().get(eName);
			edp.setVisible(true);
			eep.setVisible(true);
			
			
			edp.employeeSelected(p1);
			eep.employeeSelected(p1);
			edp.repaint();
			eep.repaint();
		}
		
		
	}
		
		

}
