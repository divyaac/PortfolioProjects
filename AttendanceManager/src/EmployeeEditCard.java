import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * Creates a card where the user can add an absence to an already existing employee. This contains
 * a display panel and an edit panel.
 * @author Divya
 *
 */
public class EmployeeEditCard extends JPanel implements MouseListener{
	private UserOptionWindow a;
	private Button create;
	private Button edit;
	private int key;
	
	/**
	 * Creates the object.
	 * @param a The main window that contains this edit card.
	 */
	public EmployeeEditCard(UserOptionWindow a){
		super();
		this.a =a;
		this.addMouseListener(this);
		key = 0;
		
	}
	
	 
	public void paintComponent(Graphics g)
		  {
		    super.paintComponent(g); 
		    
			Graphics2D g2 = (Graphics2D)g;
			
			
			Font aInfo = new Font("SansSerif", Font.PLAIN, 16);
			Font fontInfo = new Font("SansSerif", Font.BOLD, 20);
	    	g2.setFont(aInfo);
	    
			
		    int width = getWidth()-100;
		    int height = getHeight();
		    
		    g2.setColor(Color.BLUE);
		    g2.drawRect(0, 0, width / 6, height / 12);
		    
		    g2.setColor(Color.BLUE);
		    g2.drawString("BACK" , width / 15, height / 18);
		    
		    
		    g2.setColor(Color.LIGHT_GRAY);
		    g2.fillRect(width/ 6, height  / 3, width / 3, height / 7);
		    g2.fillRect(width * 2 / 3, height  / 3, width / 3, height / 7);
		    
		    
		    g2.setFont(fontInfo);
		    g2.setColor(Color.BLACK);
		    g2.drawString("Add Employee", (width/ 6) + (width/15), (height  / 3)+ (height/14) );
		    g2.drawString("Edit Information", (width * 2 / 3) + (width/15), (height  / 3)+ (height/14) );
		    
		   
		    
		    
		    
		    
		    
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
		int width = getWidth()-100;
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
		
		
	}
	
	

