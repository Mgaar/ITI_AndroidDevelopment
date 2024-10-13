import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.Font;


public class FontsDepr extends Applet{
	private String[] s;
	public void init ()
	{
	Toolkit t= Toolkit.getDefaultToolkit();
   s = t.getFontList();
	}
	


public void paint(Graphics g){
	Font f;
	for (int i=0;i<s.length;i++)
	{
		f=new Font (s[i],1,15);
		g.setFont(f);
g.drawString(s[i], 50, 20+(i*20));
f=null;
	}
}
}