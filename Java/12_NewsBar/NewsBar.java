
import java.applet.Applet;
import java.awt.Graphics;


public class NewsBar extends Applet implements Runnable {
	private int x=0;
	
	public void init (){
		Thread th = new Thread (this);
		th.start();
	}
	public void paint (Graphics g)
	{
		if (x<=getWidth())
			x+=10;
		else 
			x=-50;
		g.drawString("Hello Java",x,100);
	}
	public void run()
	{
		while (true)
		{
			try{
			Thread.sleep(200);
			repaint();
		}catch (InterruptedException e){
			e.printStackTrace( );
		}
		}
	}	
}