#include "cstring"
#include "iostream"
class car 
{
private :
const char*company;
const char*model;
int year;
public:
void setcompany (const char*str){this->company=str;}
void setmodel (const char*str){this->model=str;}
void setyear (int year){this->year=year;}
const char* getcomapny (void){return company;}
const char* getmodel (void){return model;}
int getyear (void){return year;}
};

int main()
{
    car c;
    c.setcompany("kia");
    c.setmodel("sportage");
    c.setyear(2020);
    std::cout << c.getcomapny()<<" "<<c.getmodel()<<" "<<c.getyear();
    return 0;
}
