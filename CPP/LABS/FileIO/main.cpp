#include "iostream"
#include "iomanip"
#include "fstream"
#include "string"
int main ()
{
    std::string buf;
    int sum=0;
    int min ;
    int max;
    double avg;
    int c=0;
    int num;

std::ifstream in ("file.txt");
if (!in)
std::cerr << "error openning input file";

std::ofstream out ("out.txt");
if (!out)
std::cerr << "error openning output file";

while (std::getline(in,buf))
{
    num=std::stoi(buf);
    c++;
    if(c==1)
    {
        min=max=num;
    }
    if (num>max)
    {
        max=num;
    }
    if (num<min)
    {
        min=num;
    }
    sum+=num;
}
avg=(double)sum/c;
in.close();
out << std::setw(57)<<std::setfill('-') << ""<<std::setfill(' ')<<std::endl;
out << "|"<<std::setw(8)<<std::right <<"sum"<< std::setw(6);
out << "|"<<std::setw(8)<<std::right <<"avg"<< std::setw(6);
out << "|"<<std::setw(8)<<std::right <<"min"<< std::setw(6);
out << "|"<<std::setw(8)<<std::right <<"max"<< std::setw(6)<<"|"<<std::endl;
out << std::setw(57)<<std::setfill('-') << ""<<std::setfill(' ')<<std::endl;
out << "|"<<std::setw(8)<<std::right <<sum<< std::setw(6);
out << "|"<<std::setw(10)<<std::right <<std::setprecision(3)<<std::fixed<<avg<< std::setw(4);
out << "|"<<std::setw(8)<<std::right <<min<< std::setw(6);
out << "|"<<std::setw(8)<<std::right <<max<< std::setw(6)<<"|"<<std::endl;
out << std::setw(57)<<std::setfill('-') << ""<<std::setfill(' ')<<std::endl;



    return 0;
}
