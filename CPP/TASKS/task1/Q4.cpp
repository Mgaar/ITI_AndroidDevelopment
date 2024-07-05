#include <iostream>
using namespace std;




int main()
{
	int people(162100);
	int years = 0;
	while (people <= 1000000)
	{
		years++;
		people = people+((people*65)/1000);
	}
	cout << years << " years ";

	
}
