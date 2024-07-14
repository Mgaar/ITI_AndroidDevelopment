#include <string>
#include <iostream>
std::string & HayStack (std::string_view haystack,std::string & needle,std::string & replacment)
{
    auto i=haystack.find(needle,0);
   auto r=needle.size();
   static std::string haystacknew=(std::string)haystack;
while (i!=std::string::npos)
{
    haystacknew.erase(i,r);
    haystacknew.insert(i,replacment);
    i=haystacknew.find(needle,i+r);
}
    return haystacknew;
}

int main ()
{
std::string m="ahmed abdelnaby ahmed elgaar";
std::string needle ={"ahmed "};
std::string replacment ={"mohamed "};

std::cout << HayStack(m,needle,replacment);



    return 0;
}
