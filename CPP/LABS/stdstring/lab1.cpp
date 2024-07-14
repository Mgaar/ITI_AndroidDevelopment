#include"iostream"
#include "string"

int main ()
{
std::string text="the cycle of life is a cycle of cycles";
auto i=text.find("cycle",0);
while (i!=std::string::npos)
{
    text.replace(i,6,"circle ");
    i=text.find("cycle",i);
}
    i=text.find("circle",0);
    text.insert(i,"great ");
    i=text.find("circle",i+10);
    text.insert(i,"never -ending ");
std::cout<<text;

    return 0;
}
