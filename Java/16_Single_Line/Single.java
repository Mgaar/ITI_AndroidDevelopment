import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;


public class Single extends Applet {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	public void init (){
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e)
			{
				x2=e.getX();
				y2=e.getY();
				repaint();
			}
		});
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				x1=e.getX();
				y1=e.getY();
				
			}
			
			public void mouseReleased(MouseEvent e)
			{
				x2=e.getX();
				y2=e.getY();
				repaint();
				
			}
			
		});
	}
	public void paint(Graphics g){
		g.drawLine(x1,y1,x2,y2);
		
	}
	
} 


//اللي هيحصل عليه الاكشن هو الابليت عن طريق الماوس فهنضيف الليسنر للابليت 		
//الماوس بيحصله ايفنتات كتير احنا عايزين نهاندل منه 3 انواع 
//الماوس ايفنت مدينا فانكشنز تدينا معلومات 
