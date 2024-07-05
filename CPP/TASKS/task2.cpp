int main()
{
	int in=1;
	int hr = 0;
	int min = 0;
		cout << "please enter seconds \n";
		cin >> in;
		hr = in / 3600;
		in %= 360;
		min = in / 60;
		in %= 60;


		cout << "H:M:S - " << hr << ":" << min << ":" << in;
	
}
