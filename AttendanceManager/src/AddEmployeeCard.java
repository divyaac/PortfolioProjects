import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * Creates a card where the user can create a new employee and add it to teh database.
 * @author Divya
 *
 */
public class AddEmployeeCard extends JPanel {
	
		private UserOptionWindow a;
		
		
		private EmployeeDisplayPanel edp;

		private CreationPanel cp;
		

		/**
		 * Creates a display and actual creation panel on the card that displays the new employee once
		 * it has been properly initialized.
		 * @param a The main program to be used that contains the database, and the specified month calendar.
		 */
		public AddEmployeeCard(UserOptionWindow a){
			super();
			this.a =a;
			
			setLayout(new BorderLayout());
			
			
			edp = new EmployeeDisplayPanel( a);
			add(edp, BorderLayout.CENTER);
			edp.setVisible(true);
			edp.setBackground(Color.WHITE);
			edp.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.GRAY));

		
			
			
			
			cp = new CreationPanel(a, edp);
			add(cp, BorderLayout.EAST);
			cp.setVisible(true);
			cp.setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.GRAY));
			
			
			
		
		}

		
		


	}

