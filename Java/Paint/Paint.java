import java.applet.Applet;
import java.awt.Graphics;

import java.awt.Color;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;




public class Paint extends Applet {
	abstract class Shape {
		private int p1;
		private int p2;
		private int p3;
		private int p4;
		private boolean solid;
		private Color myColor;
		 
		public int getP1 (){return p1;}
		public int getP2 (){return p2;}
		public int getP3 (){return p3;}
		public int getP4 (){return p4;}
		public boolean getSolid(){return solid;}
		public Color getMyColor(){return myColor;}
		 
		public void setP1 (int pV){p1=pV;}
		public void setP2 (int pV){p2=pV;}
		public void setP3 (int pV){p3=pV;}
		public void setP4 (int pV){p4=pV;}
		public void setMyColor (Color colorV){myColor = colorV ;}
		public void setSolid (boolean solidV){solid = solidV ;}
		
		public Shape (int p1V, int p2V , int p3V , int p4V , boolean solidV ,Color colorV)
		{
			p1=p1V;
			p2=p2V;
			p3=p3V;
			p4=p4V;
			myColor= colorV;
			solid = solidV;
		}
		abstract public void draw (Graphics g);
	 }
	 class Line extends Shape {
		public Line (int p1V, int p2V , int p3V , int p4V ,Color colorV)
		{
			super(p1V,p2V,p3V,p4V,false,colorV);
		}
		public void draw (Graphics g)
		{
			g.setColor(getMyColor());
			if (getP3()<getP1())
				g.drawLine(getP1(),getP2(),getP3(),getP4());
			else
			g.drawLine(getP1(),getP2(),getP3(),getP4());
			
		}
		 
	 }
	 class Oval extends Shape {
		public Oval (int p1V, int p2V , int p3V , int p4V ,boolean solidV ,Color colorV)
		{   
			super(p1V,p2V,p3V-p1V,p4V-p2V,solidV,colorV);
		}
		public void draw (Graphics g)
		{
			g.setColor(getMyColor());
			if(getSolid())
			g.fillOval(getP1(),getP2(),getP3(),getP4());
			else 
			g.drawOval(getP1(),getP2(),getP3(),getP4());
			
			
			
		}
		 
	 }
	 class Rect extends Shape {
		public Rect (int p1V, int p2V , int p3V , int p4V ,boolean solidV ,Color colorV)
		{
			super(p1V,p2V,p3V-p1V,p4V-p2V,solidV,colorV);
		}
		public void draw (Graphics g)
		{
			g.setColor(getMyColor());
			if(getSolid())
			g.fillRect(getP1(),getP2(),getP3(),getP4());
			else		
			g.drawRect(getP1(),getP2(),getP3(),getP4());
			
		}
		 
	 }
	private int p1;
	private int p2;
	private int p3;
	private int p4;
	private boolean solid;
	private Color myColor;
	private final int NONE = 0 ;
	private int shapeState;
	private final int LINE = 1 ;
	private final int OVAL = 2 ;
	private final int RECT = 3 ;
	private final int ERASE = 4 ;
	private final int PEN = 5 ;
	
	private  ArrayList<Shape> shapeList = new ArrayList<>();
	
	public void init ()
	{
		myColor=Color.BLACK;
		Button lineButton = new Button("Line");
		Button ovalButton = new Button("Oval");
		Button rectButton = new Button("Rect");
		Button eraseButton = new Button("Erase");
		Button penButton = new Button("Pen");
		
		Button clearButton = new Button("Clear");
		Button undoButton = new Button("Undo");
		
		Button redButton = new Button("Red");
		Button blueButton = new Button("Blue");
		Button greenButton = new Button("Green");
		
		Checkbox solidCheckbox = new Checkbox ("solid");
		
		lineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeState=LINE;
			}
			
		});
		ovalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeState=OVAL;
			}
			
		});
		rectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeState=RECT;
			}
			
		});
		eraseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeState=ERASE;
			}
			
		});
		penButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeState=PEN;
			}
			
		});
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeList.clear();
				repaint();
			}
			
		});
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				shapeList.remove(shapeList.size()-1);
				repaint();
			}
			
		});
		
		redButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				myColor = Color.RED;
			}
		});
		blueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				myColor = Color.BLUE;
			}
		});
		greenButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				myColor = Color.GREEN;
			}
		});
		
		solidCheckbox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e)
			{
				if (solid == true)
					solid = false ;
				else 
				solid = true ;	
			}
		});
		redButton.setBackground(Color.RED);
		blueButton.setBackground(Color.BLUE);
		greenButton.setBackground(Color.GREEN);
		add(clearButton);
		add(undoButton);
		add(lineButton);
		add(ovalButton);
		add(rectButton);
		add(penButton);
		add(eraseButton);
		add(solidCheckbox);
		add(redButton);
		add(blueButton);
		add(greenButton);
		
		this.addMouseListener(new  MouseAdapter(){
			public void mousePressed(MouseEvent e)
			{
				if (shapeState != NONE)
				{
					p1=e.getX();
					p2=e.getY();
				}
			}
			public void mouseReleased(MouseEvent e)
			{
				if (shapeState != NONE)
				{
				p3=e.getX();
				p4=e.getY();	
				
				switch (shapeState){
					case LINE :
					shapeList.add(new Line(p1,p2,p3,p4,myColor));
					p1=0;
					p2=0;
					p3=0;
					p4=0;
					break ;
					case OVAL:
						if ((p1>p3)&&(p2>p4))
					{
					shapeList.add(new Oval(p3,p4,p1,p2,solid,myColor));

					}
					else if (p1>p3)
						shapeList.add(new Oval(p3,p2,p1,p4,solid,myColor));
					else if (p2>p4)
						shapeList.add(new Oval(p1,p4,p3,p2,solid,myColor));
					else 
					shapeList.add(new Oval(p1,p2,p3,p4,solid,myColor));
					p1=0;
					p2=0;
					p3=0;
					p4=0;
					break;
					case RECT:
					if ((p1>p3)&&(p2>p4))
					{
					shapeList.add(new Rect(p3,p4,p1,p2,solid,myColor));

					}
					else if (p1>p3)
						shapeList.add(new Rect(p3,p2,p1,p4,solid,myColor));
					else if (p2>p4)
						shapeList.add(new Rect(p1,p4,p3,p2,solid,myColor));
					else 
					shapeList.add(new Rect(p1,p2,p3,p4,solid,myColor));
					p1=0;
					p2=0;
					p3=0;
					p4=0;
					break;
					case ERASE :
					if ((p1>p3)&&(p2>p4))
					{
					shapeList.add(new Rect(p3,p4,p1,p2,solid,myColor));

					}
					else if (p1>p3)
						shapeList.add(new Rect(p3,p2,p1,p4,solid,myColor));
					else if (p2>p4)
						shapeList.add(new Rect(p1,p4,p3,p2,solid,myColor));
					else 
					shapeList.add(new Rect(p1,p2,p3,p4,solid,myColor));
					p1=0;
					p2=0;
					p3=0;
					p4=0;
					break;
					case PEN :
					shapeList.add(new Line(p1,p2,p3,p4,myColor));
					p1=0;
					p2=0;
					p3=0;
					p4=0;
					break;
				}
				repaint();
				
				}	
			}
		});
		this.addMouseMotionListener (new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e)
			{
				if (shapeState != NONE)
				{
				p3=e.getX();
				p4=e.getY();
				if (shapeState == ERASE)
				{	
					 
					shapeList.add(new Rect(p1,p2,p1+10,p2+10,solid,Color.WHITE));
					p1=p3;
					p2=p4;
					
				}
				else if (shapeState == PEN)
				{	
					shapeList.add(new Line(p1,p2,p3,p4,myColor));
					p1=p3;
					p2=p4;
					
				}
				repaint();
				}	
			}
		});
	}
	public void paint (Graphics g)
	{
		int pXMax = p3;
		int pXMin = p1;
		int pYMax = p4;
		int pYMin = p2;
		g.setColor(myColor);
		switch (shapeState){
					case LINE :
					g.drawLine(p1,p2,p3,p4);
					break ;
					case OVAL :
					if((p1>p3)&&(p2>p4))
					{
						pXMax = p1;
						pXMin = p3;
						pYMax = p2;
						pYMin = p4;
					}				
					else if (p1>p3)
					{
						pXMax = p1;
						pXMin = p3;
						
					}
					else if (p2>p4)
					{
						pYMax = p2;
						pYMin = p4;
					}
					
					 
					if(solid)
						g.fillOval(pXMin,pYMin,Math.abs(pXMax-pXMin),Math.abs(pYMax-pYMin));
					else		
						g.drawOval(pXMin,pYMin,Math.abs(pXMax-pXMin),Math.abs(pYMax-pYMin));
					break ;
					case RECT :
					if((p1>p3)&&(p2>p4))
					{
						pXMax = p1;
						pXMin = p3;
						pYMax = p2;
						pYMin = p4;
					}				
					else if (p1>p3)
					{
						pXMax = p1;
						pXMin = p3;
						
					}
					else if (p2>p4)
					{
						pYMax = p2;
						pYMin = p4;
					}
					if(solid)
						g.fillRect(pXMin,pYMin,Math.abs(pXMax-pXMin),Math.abs(pYMax-pYMin));
					else		
						g.drawRect(pXMin,pYMin,Math.abs(pXMax-pXMin),Math.abs(pYMax-pYMin));
					break ;
					
				}
				
		for (Shape s : shapeList )	
		{
			s.draw(g);
		}
			
	}
	
	 
} 


