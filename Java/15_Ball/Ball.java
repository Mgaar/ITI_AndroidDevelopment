
import java.applet.Applet;
import java.awt.Graphics;



import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Ball extends Applet  {
	private int x=(getWidth()/2);
	private int y=(getHeight()/2);
	
	private boolean directionX = false; 
	private boolean directionY = false; 
	private boolean startState = false;
	
	private Thread th = new Thread(){
		public void run()
		{
		while (true)
		{
			try{
			Thread.sleep(100);
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
			repaint();
		}catch (InterruptedException e){
			e.printStackTrace( );
		}
		}
		}};
	
	public void init (){
		Button b = new Button("start") ;
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if (startState == false )
				{
					th.start();
					startState = true;
				}
				else 
				{
					
						th.resume();
						
							
				}
			}
			
		});
		add(b);
		
		Button b2 = new Button("pause") ;
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
						th.suspend();
						
			
			}
			
		});
		add(b);
		add(b2);
		
	}
	public void paint (Graphics g)
	{
		
		g.setColor(Color.RED);
		g.fillOval(x,y,30,30);
	}
		
}



			