 import java.lang.Integer;

class Pattern {
	public static void main (String[] args){
		String str1 = new String("*");
		String str2 =new String ("     ");
		Integer num = Integer.valueOf(args[0]);
		for (int i=0;i<num;i++)
		{
			str2+=" ";
		}
		str2+="*";
String str=str1;
String strr=str2;
	for (int i =0;i<5;i++)
	{
		System.out.println(str1 );
		str1+="*";
		strr=strr.substring(2);
		strr+=" *";
	}		
	}	
}