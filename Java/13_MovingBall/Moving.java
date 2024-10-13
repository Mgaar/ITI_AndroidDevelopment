
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class Moving extends Applet implements Runnable {
	private int x=50;
	private int y=200;
	private boolean directionX = false; 
	private boolean directionY = false; 

	public void init (){
		Thread th = new Thread (this);
		th.start();
	}
	public void paint (Graphics g)
	{
		
		if (directionX == false )
		{
			x+=10;
		
			if (x+10==getWidth())
				directionX = true ;
			
		}	
		else 
		{
			
			x-=10;
			if (x==0)
				directionX = false ;
			
			
		}
		if (directionY == false )
		{
				y+=10;
				if (y+20==getHeight())
				directionY = true ;
		}
		else 
		{
			y-=10;
			if (y==0)
			directionY = false ;
		}
			
		g.setColor(Color.RED);
		g.fillOval(x,y,30,30);
	}
	public void run()
	{
		while (true)
		{
			try{
			Thread.sleep(100);
			repaint();
		}catch (InterruptedException e){
			e.printStackTrace( );
		}
		}
	}	
}