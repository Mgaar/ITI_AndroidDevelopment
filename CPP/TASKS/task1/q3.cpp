#include <iostream>
using namespace std;
int binarytodecimal( char* binary)
{
	int num = 0;
	for (int i = 0;i < 32;i++)
		num |= (binary[i] << i);

	return num;
	
}

char* decimaltobin(int num)
{
	static char arr[32];
	
	for (int i = 31;i >= 0;i--)
	{
		arr[i] = (num >> i) & 1;
		cout << ((num >> i)&1);
	}
	return arr;
		
}

int main()
{
	int in = 5;
		cout << binarytodecimal(decimaltobin(5));
		
	
}
