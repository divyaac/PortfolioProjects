import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This class represents the people not attending a specific 
 * day 
 * @author Tasmine Hackson
 *
 */
public class PeopleCard extends JPanel implements MouseListener{

	
	UserOptionWindow b; 
	private int key;
	private  ArrayList<PersonalizedCalendarDate> dateAbsences = new ArrayList<PersonalizedCalendarDate>() ;

	/**
	 * No args constructor
	 * 
	 */
	public PeopleCard(){
		super();
		key = 0;
		this.addMouseListener(this);
//		s = new String();
	}
	/**
	 * Constructor initializes fields
	 * @param b UserOptionWindow
	 */
	public PeopleCard(UserOptionWindow b){
		super();
		this.b = b;
		key = 0;
		this.addMouseListener(this);
	}
	
	
	
	
	/**
	 * This method creates the graphical representation 
	 * of the people who are not present on a specific day
	 * @param g Graphics
	 * 
	 */
	public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g); 
	    

		Graphics2D g2 = (Graphics2D)g;
		

		
	    int width = getWidth();
	    int height = getHeight();
	    
		Font fontInfo = new Font("SansSerif", Font.PLAIN, 16);
    	g2.setFont(fontInfo);
    	FontMetrics metrics = g2.getFontMetrics();
	    if(dateAbsences.size()==0){
	    	String absences = "No Employee Absences";
	        g2.drawString(absences, width / 2, height / 2);
	    }else{

	    
	    	for(int i=0; i<dateAbsences.size(); i++){

	    		PersonalizedCalendarDate pd = dateAbsences.get(i);
	    		String absences = pd.getName() + "     :    " + pd.getDate().getReason();
	    		
	    		g2.drawString(absences, (width / 2)-(metrics.getMaxAdvance()), (height / 2) + (metrics.getHeight()*i) );
	    	}
	    	
	    }
	
	    //makes spots for the people not attending
	    
	    
	    
	    g2.setColor(Color.BLUE);
	    g2.drawRect(0, 0, width / 6, height / 12);
	    
	    g2.setColor(Color.BLUE);
	    g2.drawString("BACK" , width / 15, height / 18);
	    
	
	  }
	public void setInfo( ArrayList<PersonalizedCalendarDate> dateAbsences){
		this.dateAbsences = dateAbsences;
		repaint();
	}
	
	public void setRect(int i){
		key = i;
		
	}
	public int getRect(){
		return key;
	}
	@Override
	public void mouseClicked(MouseEvent ans) {
		int x = ans.getX();
		int y = ans.getY();
		if(x <= (getWidth()/6) && y <= (getHeight()/12) ){
			setRect(100);
			b.changeCard();
			
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
