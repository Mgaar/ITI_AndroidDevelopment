#include "iostream"
#include <cstdlib> // for rand() and srand()
#include <ctime>   // for time()

class BattleShip {
    private :
    bool grid[5][5]={false} ;
    int gusses ;
    int maxgusses;
    int locationx;
    int locationy;
    public :
    BattleShip(int max):maxgusses{max},gusses{0},locationx{rand()%5},locationy{rand()%5}{
grid[locationx][locationy]=true;   } 
bool  gameover ()
{
    if (gusses==maxgusses)
    return true;
    return false;
}
bool guess (int x,int y){
        gusses++;
if(!gameover()){

    if (x==locationx&&y==locationy)
    {
        std::cout << "congratulations u guessed it right in "<<gusses<<" gusses\n";
        return false;
    }
    else if (x==locationx)
    {
        std::cout << " u guessed x location right \n";
    }
    else if (y==locationy)
    {
        std::cout << " u guessed y location right \n";
    }
    else if (x==locationx-1||x==locationx+1)
    {
        x>locationx?std::cout << "u are 1 step ahead in x ":std::cout << "u are 1 step behind in x \n";
    }
    else if (y==locationy-1||y==locationy+1)
    {
        y>locationy?std::cout << "u are 1 step ahead in y ":std::cout << "u are 1 step behind in y \n";
    }
    else {
        if (x>4||x<0||y>4||y<0)
        {
            gusses--;
            std :: cout << "out of boundries x and y must be between 0,4\n";
        }
        else 
        {
            std::cout << "wrong try again "<<maxgusses-gusses<< "guesses remaning\n";
        }
    }
}
else 
{
std::cout << "game over\n";
return false;
}
return true ;
}   
int getguesses (void){return gusses;}
    
};
int main(){
    srand(static_cast<unsigned int>(time(0)));
BattleShip b(5);
int x,y;
std::cin >> x >> y; 
while (b.guess(x,y))
{
    std::cout << "enter x and y\n";
   std::cin >> x >> y; 
 
}


    return 0;
}
