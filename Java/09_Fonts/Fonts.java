import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Font;

public class Fonts extends Applet{
	private String[] str;
	public void init ()
	{
		GraphicsEnvironment gE = GraphicsEnvironment.getLocalGraphicsEnvironment();
		str= gE.getAvailableFontFamilyNames();
	}
public void paint(Graphics g){
	Font f;
	for (int i=0;i<str.length;i++)
	{
		f=new Font (str[i],1,15);
		g.setFont(f);
g.drawString(str[i], 50, 20+(i*20));
f=null;
	}
}
}