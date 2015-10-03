import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class is the graphical representation of the intro window
 * and also deals with the actionListener
 * @author Tasmine Hackson
 *
 */
public class IntroWindow extends JPanel implements MouseListener{

	
	UserOptionWindow c; 
	private boolean editInfoClicked =false;
	/**
	 * No args constructor
	 */
	public IntroWindow(){
		super();
		this.addMouseListener(this);
	}
	/**
	 * Constructor
	 * @param c UserOptionWindow
	 */
	public IntroWindow(UserOptionWindow c){
		super();
		this.c = c;

		this.addMouseListener(this);

	}
	
	
	/**
	 * This method makes the graphics for the intro window
	 * @param g Graphics
	 * 
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    

		Graphics2D g2 = (Graphics2D)g;
		Font aInfo = new Font("SansSerif", Font.BOLD, 15);
		Font fontInfo = new Font("SansSerif", Font.BOLD, 20);
    	g2.setFont(aInfo);
    

		
	    int width = getWidth();
	    int height = getHeight();
	    
	  
	    
	   
	    g2.setColor(Color.pink);
	    g2.fillRect(width/ 6, height  / 3, width / 6, height / 10);
	    g2.fillRect(width * 2 / 3, height  / 3, width / 6, height / 10);
	    
	    
	    g2.setColor(Color.BLACK);
	    g2.drawString("Edit Employees ", (width / 6)  + (width/50), (height / 3) + (height/20) );
	    g2.drawString("Calendar ", (width * 2 / 3) + (width/22),  (height / 3) + (height/20) );
	    
	    

	    
	    
	
	    
	  }
	@Override
	public void mouseClicked(MouseEvent ans) {
		int x = ans.getX();
		int y = ans.getY();
		
		if(x >= getWidth()*2/3 && x <= ((getWidth() *2/3) +(getWidth() /6)) ){
			if(y >= (getHeight()/3) && y <= ((getHeight()/3) + (getHeight()/10))){
				c.calendarInfoClicked();
				c.changeCard();
			}
		}else if(x >= getWidth()/6 && x <= ((getWidth()/6) +(getWidth() /6)) ){
			if(y >= (getHeight()/3) && y <= ((getHeight()/3) + (getHeight()/10))){
				c.editInfoClicked();
				c.changeCard();
			}
		}
		
	}
	
	
	public boolean geteditInfoClicked(){
		return editInfoClicked;
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