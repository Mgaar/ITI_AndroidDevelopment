import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;



public class ThreeLines extends Applet {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private MyLine[] lines = new MyLine[3] ;
	private int counter=0 ;
	public void init (){
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e)
			{
				if (counter < 3)
				{
					x2=e.getX();
					y2=e.getY();
					repaint();	
				}
			}
		});
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				if (counter < 3)
				{
					x1=e.getX();
					y1=e.getY();
						
				}
				
			}
			
			public void mouseReleased(MouseEvent e)
			{
				if (counter < 3)
				{
					x2=e.getX();
					y2=e.getY();
					if (!((x2==x1)&&(y2==y1)))
					lines[counter++]=new MyLine(x1,y1,x2,y2);
					y1=y2=x2=x1=0;
				
					repaint();	
				}
				
				
			}
			
		});
	}
	public void paint(Graphics g){
		for (int i = 0 ;i<counter;i++)
		{
			g.drawLine(lines[i].getX1(),lines[i].getY1(),lines[i].getX2(),lines[i].getY2());
	
		}
		g.drawLine(x1,y1,x2,y2);
	}
	class MyLine {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	public int getX1(){return x1;}
	public int getX2(){return x2;}
	public int getY1(){return y1;}
	public int getY2(){return y2;}
	public MyLine(int x1V,int y1V,int x2V,int y2V){
		x1=x1V;
		x2=x2V;
		y1=y1V;
		y2=y2V;
				
	}
	} 
} 


