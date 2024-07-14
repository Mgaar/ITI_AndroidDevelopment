#include <cstdlib>
#include <ctime>
#include <iostream>
struct Vertex {
    private :
    int x;
    int y;
    public:
    Vertex(void)
    {

    
    // Generate random number between -100 and 100
    x=(rand() % 201) - 100;
    y=(rand() % 201) - 100;
std::cout << "x="<<x<<" y="<<y;

    }
    
};

int main (){
srand(static_cast<unsigned int>(time(0)));
Vertex v1;
Vertex v2;
Vertex v3;


    return 0;
}
