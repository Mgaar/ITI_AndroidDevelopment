import java.util.StringTokenizer;

class Functions {
	public static void first(String s)
	{
		int index;
		int from=0;
		index=s.indexOf('.');
		while (index!=-1)
		{
		System.out.println(s.substring(from,index));
		from=index+1;
		index = s.indexOf('.',index+1);
		}
		System.out.println(s.substring(from));

	}
	
	public static void second (String s)
	{
		System.out.println(s);
		String[] str = s.split("\\.",0);
		for (int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}
		
	
	}
	public static void third (String s)
	{
		System.out.println(s);
		StringTokenizer st = new StringTokenizer(s,".");
     while (st.hasMoreTokens()) {
         System.out.println(st.nextToken());
     }
	}
	
}


class Ip {
	public static void main (String[] args)
	{
	Functions.first(args[0]);
	Functions.second(args[0]);
	Functions.third(args[0]);
	}
	
	
}
