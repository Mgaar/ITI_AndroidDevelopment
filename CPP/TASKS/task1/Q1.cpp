using namespace std;

int main()
{
	int in=1;
	int result = 0;
	while (in)
	{
		cout << "please enter number\n";
		cin >> in;
		result += in;
	}
	cout << "result " << result;
}
