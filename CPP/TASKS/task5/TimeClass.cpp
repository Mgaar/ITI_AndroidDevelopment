#include <iostream>

class Time
{
private :
int hour;
int min;
int sec;
public:
Time(int hour=0,int min=0,int sec=0):hour{hour},min{min},sec{sec}{}
void display() const{
    std::cout<<hour<<":"<<min<<":"<<sec;
}
void addtime (const Time & t1,const Time & t2)
{
    sec=t1.sec+t2.sec;
    if (sec>=60)
    {sec%=60;
    min++;
    }
        min+=t1.min+t2.min;
          if (min>=60)
    {min%=60;
    hour++;
    }
    hour+=t1.hour+t2.hour;
}
};


int main (void)
{

Time t1(5,50,55);

Time t;
Time t2 (4,15,30);

t.addtime(t1,t2);
t.display();



return 0;
}
