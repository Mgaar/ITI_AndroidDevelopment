class Parent {
	private int no1;
	private int no2;
	
	public void setNo1 (int n){
	no1=n;}
	public void setNo2 (int n){
	no2=n;}
	public int getNo1 (){
	return no1; }
	public int getNo2 (){
	return no2; }
	public int sum (){
	return no1+no2;}
    public Parent()
	{
	System.out.println("parent default");	
	}
	public Parent(int x)
	{
		no1=x;
	System.out.println("one args parent default");	
	}
	public Parent(int x,int y)
	{
		no1=x;
		no2=y;
	System.out.println("two args parent default");	
	}	
}

class Child extends Parent {
	private int no3;
	public void setNo3 (int n){
	no3=n;}
	public int getNo3 (){
	return no3;}
	public int sum()
	{
		return no3+super.sum();
	}
	public Child ()
	{
	super();
	System.out.println("child default");
	}
	public Child (int x)
	{
		super(x);
		System.out.println("child 1 arg");

	}
	public Child (int x,int y)
	{
		super(x,y);
		System.out.println("child 2 arg");

	}
	public Child (int x,int y,int z)
	{
		super(x,y);
		no3=z;
		System.out.println("child 3 arg");
	}
}

class Main {
	public static void main (String[] args)
	{
		Child c = new Child(10,15,5) ;
		System.out.println(c.sum());
	}
}