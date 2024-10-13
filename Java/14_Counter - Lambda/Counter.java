import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Counter extends Applet {
	private int x;
	public void init ()
	{
		Button b = new Button("+") ;
		ActionListener ref;
		ref = (e) -> {x++;repaint();}	;
		b.addActionListener(ref);
	/*	b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x++;
				repaint();
			}
			
		});*/
		add(b);
		
		Button b2 = new Button("-") ;
		b2.addActionListener(e -> {x--;repaint();});
/*		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				x--;
				repaint();
			}
			
		});*/
		
		add(b2);
	}
	public void paint (Graphics g)
	{
		g.drawString("counts = "+x,getWidth()/2,getHeight()/2);
	}
}