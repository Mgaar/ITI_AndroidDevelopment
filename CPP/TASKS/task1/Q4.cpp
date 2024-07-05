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

/*
we can use this formula to clculate number of years without looping 
P(t)=P(0)×(1+r)^t
 

where:

P(t) is the future population.
𝑃(0) is the initial population (162,100).
r is the annual growth rate (6.5% or 0.065).
t is the number of years.
*/
