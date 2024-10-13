import java.applet.Applet;
import java.awt.Graphics;
import java.util.Date;



public class MyDate extends Applet implements Runnable {
	
	public void init ()
	{
		Thread th = new Thread(this) ;
		th.start();
	}
	public  void paint(Graphics g)
	{
		Date d = new Date();
		g.drawString(d.toString(),getWidth()/2,getHeight()/2);
		
	}
	public void run()
	{
		while (true)
		{
			try{
			Thread.sleep(1000);
			repaint();
		}catch (InterruptedException e){
			e.printStackTrace( );
		}
		}
	}	
}