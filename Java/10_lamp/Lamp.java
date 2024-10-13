import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;


public class Lamp extends Applet{
	


public void paint(Graphics g){
	
	g.drawLine(50,65,40,150);
	g.drawLine(150,65,160,150);
	
	g.drawArc(40,135,120,30,180,180);
	g.drawLine(90,165,85,210);
	g.drawLine(110,165,115,210);
	g.drawRect(65,210,70,10);
	g.setColor(Color.RED);
	g.fillOval(50,50,100,30);
	g.fillOval(50,100,20,30);
	g.fillOval(130,100,20,30);
	g.fillOval(80,100,40,50);

}
}