import java.lang.Double;
import java.lang.Character;

class Calc {
	
	public static void main (String[] args)
	{
		if (args.length == 3 )
		{
			
		Double num1 = Double.valueOf(args[0]);
		Double num2 = Double.valueOf(args[2]);
		
		switch (args[1].charAt(0))
		{
			case '+':
			System.out.println((int)(num1.doubleValue()+num2.doubleValue()));
			break;
			case '-':
			System.out.println((int)(num1.doubleValue()-num2.doubleValue()));
			break;
			case 'x':
			System.out.println((int)(num1.doubleValue()*num2.doubleValue()));
			break;
			case '/':
			if(num2.doubleValue() ==(double)0 )
			System.out.println("can not divide by 0");
			else
			System.out.println((num1.doubleValue()/num2.doubleValue()));			
			break ;
			default : 
			System.out.println("unvalid operator + - / x ");
			break;
		}	
		}
		else 
		{
			System.out.println("must be 3 args ");
		}
		
		
		
	}
	
	
	
	
	
}