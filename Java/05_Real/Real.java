class Number {
	private int real;
	private int imagine;
	
	public void setReal (int n){real=n;}
	public int getReal() {return real;}
	
	public void setImagine (int n){imagine=n;}
	public int getImagine(){return imagine;}
	
	public Number (){
		System.out.println("default");
	} 
	public Number (int n1 , int n2 ){
real=n1;
imagine=n2;
		System.out.println("two arg ");
	} 

	
	public static Number sum(Number num1,Number num2)
	{
		Number num3 = new Number(num1.real+num2.real,num2.imagine+num1.imagine);
		return num3;
	}
	public static Number sub(Number num1,Number num2)
	{
		Number num3 = new Number(num1.real-num2.real,num1.imagine-num2.imagine);
		return num3;
	}
	public static void print(Number num)
	{
		if (num.getImagine() > 0)
	System.out.println(num.getReal() + "+" +num.getImagine() + "i");
    else 
			System.out.println(num.getReal() + "-" +(-1*num.getImagine()) + "i");

	}

}



class Main {
	public static void main (String[] args)
	{
		Number num1 = new Number(5,6);
		Number num2 = new Number (3,10);
		Number.print(Number.sum(num1,num2));
		Number.print(Number.sub(num1,num2));
	}
}