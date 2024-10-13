abstract class Shape {
private int dim1;
public void setDim1 (int d){dim1=d;}
public int  getDim1 (){return dim1;}
abstract double calcArea ();
public Shape(){System.out.println("default shape created");}
public Shape(int x){dim1=x;
System.out.println("one arg shape");
}   
}

class Circle extends Shape {
	public Circle (){System.out.println("default Circle created");} 
	public Circle (int d) 
	{super(d);
	System.out.println("one arg circle");}
	public double calcArea (){ 
	return 3.14*super.getDim1();
	}
}

class Rectangle extends Shape {
	private int dim2;
	public Rectangle (){System.out.println("default Rec created");} 
	public Rectangle (int d) 
	{super(d);
		System.out.println("one arg Rec");
		}
	public Rectangle (int d,int d2) 
	{
		super(d);
	dim2 = d2;
	System.out.println("two arg Rec");}
	public void setDim2(int d2){dim2=d2;}
	public int getDim2(){return dim2;}
	public double calcArea (){ 
	return super.getDim1()*dim2;
	}
}

class Triangle extends Shape {
	private int dim2;
	public Triangle (){System.out.println("Triangle Rec created");} 
	public Triangle (int d) 
	{super(d);
		System.out.println("one arg Triangle");
		}
	public Triangle (int d,int d2) 
	{super(d);
	dim2 = d2;
	System.out.println("two arg Triangle");}
	public void setDim2(int d2){dim2=d2;}
	public int getDim2(){return dim2;}
	public double calcArea (){ 
	return super.getDim1()*dim2*0.5;
	}
}


class Main {
	
	public static void main (String[] args)
	{
		Circle c =new Circle(5);
		Rectangle r = new Rectangle(15,14);
		Triangle t = new Triangle(20,10);
		System.out.println(calcSum(c,r,t));
	}
	public static double calcSum(Shape s1,Shape s2,Shape s3)
	{
		return s1.calcArea()+s2.calcArea()+s3.calcArea();
	}
	
}