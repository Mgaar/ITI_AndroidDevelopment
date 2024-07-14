#include <cstdlib>
#include <ctime>
#include <iostream>
#include <string>
class Vertex {
    private :
    int x;
    int y;
    public:
    Vertex(void)
    {

    
    // Generate random number between -100 and 100
    x=(rand() % 201) - 100;
    y=(rand() % 201) - 100;

    }

    void setx (int x){this->x=x;}
    void sety (int y){this->y=y;}
    int getx (void){return x;}
    int gety (void){return y;}
    std::string getverstr(void){
    std::string str="x="+std::to_string(x)+" y="+std::to_string(y);
    return str;
    }

    
};

int main (){
srand(static_cast<unsigned int>(time(0)));
Vertex v1;
Vertex v2;
Vertex v3;
std::cout << v1.getverstr();

    return 0;
}
