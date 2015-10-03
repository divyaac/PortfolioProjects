import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.JPanel;

/**
 * 
 * @author Tasmine Hackson
 * This class is the graphic representation of the month of May for 2014
 *
 */
public class Calendar extends JPanel implements MouseListener{

	
	UserOptionWindow a; 
	ArrayList<Rectangle> rect;
	private int key;

	

	
	/**
	 * No args constructor
	 * 
	 */
	public Calendar(){
		super();
		rect = new ArrayList<Rectangle>();
		this.addMouseListener(this);
	}
	/**
	 * Constructor that takes in a UserOptionWindow
	 * @param a UserOptionWindow
	 */
	public Calendar(UserOptionWindow a){
		super();
		this.a = a;
		rect = new ArrayList<Rectangle>();
		key = 0;
		this.addMouseListener(this);
		

		
	}
	@Override
	public void mouseClicked(MouseEvent ans) {
		
		int x = ans.getX();
		int y = ans.getY();
		if(x <= (getWidth()/6) && y <= (getHeight()/12) ){
			setRect(100);
			a.changeCard();
			
		}
		
	
		
			
		for(int i = 4; i < rect.size(); i++){
			Rectangle re = rect.get(i);
			
			
//			int x2 = (int) re.getCenterX();
//			int y2 = (int) re.getCenterY();
//			if( x <= (x2 + getWidth()/12) && x >= (x2 - getWidth()/12) ){
//				if(y <= (y2 + getHeight()/12) && y >= (y2 - getHeight()/12)){
//					setRect(i);
//					a.changeCard();
//					
//					return;
//				}
//				
//			}
			
		if(re.contains(x, y)){
			setRect(i);
			a.changeCard();
		}
		
	
		}
	
		
		
	}
	
	/**
	 * This method paints out the graphics for this JPanel
	 * @param g Graphics
	 * 
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    
		rect.clear();
	    Graphics2D g2 = (Graphics2D)g;
		

		
	    int width = getWidth();
	    int height = getHeight();
	  
	    g2.setColor(Color.BLACK);
	    
	   
	    
	    //draws days
	    for(int i = 0; i <=width - (width/ 7); i += (width/ 7)){
	    	g2.drawRect(i, height / 12, width / 7, height/ 12);
	    }
	    g2.drawString("Sunday", 10, height / 12 + 30);
	    g2.drawString("Monday", (width / 7) +10, height / 12 +30);
	    g2.drawString("Tuesday", 2 * (width / 7) +10, height / 12 +30);
	    g2.drawString("Wednesday", 3*(width / 7) +10 , height / 12 +30);
	    g2.drawString("Thursday", 4*(width / 7)+10, height / 12 +30);
	    g2.drawString("Friday", 5*(width / 7) +10, height / 12 +30);
	    g2.drawString("Saturday", 6*(width/7) +10, height / 12 +30);
	    
	    g2.drawString("May", width / 2 + 30, height /12 -20);
	    
	    
	    
	  
	    
	    //draws the boxes
	    int num = -4;
	    for(int i = height/6; i <=height - (height/6); i+=(height/6)){
	    	
	    	
	    	for(int j = 0; j <=width-(width/ 7); j += (width/ 7)  ){
	    		
	    		g2.drawRect(j, i, width / 7, height / 6);
	    		
	    		rect.add(new Rectangle(j, i, width / 7, height / 6));
	    		g2.drawRect(j, i, width / 21, height / 18);
	    		num += 1;
	    		if(num > 0){
	    			g2.drawString("" + num, j +10, (i + 20 ));
	    			
	    		}
	    	}
	    }
	    
	    g2.setColor(Color.BLUE);
	    g2.drawRect(0, 0, width / 6, height / 12);
	    
	    g2.setColor(Color.BLUE);
	    g2.drawString("BACK" , width / 15, height / 18);
	    
	    
	    
	    
	  }
	
	public void setRect(int i){
		key = i;
		
		
	}
	public int getRect(){
		return key;
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
	public void mousePressed(MouseEvent ans) {
		
		
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	 
	
	
	
	

}
