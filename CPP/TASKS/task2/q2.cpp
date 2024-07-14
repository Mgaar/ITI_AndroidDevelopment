#include "iostream"
#include "cmath"
class calculator {
    private :
    static int add (int n1,int n2){return n1+n2;}
    static int sub (int n1,int n2){return n1-n2;}
    static int mul (int n1,int n2){return n1*n2;}
    static int dev (int n1,int n2){return n1/n2;}
    static int poww (int n1,int n2){return pow(n1,n2);}
    static double sqr (int n1){return sqrt(n1);}
    public :
    static void calc ()
    {
        char op='n';
        int num1,num2;
        std::cout << "enter operation + - * / ^ S:";
        std::cin >> op ;
        if (op=='S')
        {
        std::cout << "enter num :";
        std::cin >> num1 ;
        }
        else {
        std::cout << "enter num 1:";
        std::cin >> num1 ;
        std::cout << "enter num 2:";
        std::cin >> num2 ;
        std::cout << num1<< (char)op <<num2;
        }
        switch (op){
            case '+':std::cout <<"="<<add(num1,num2);break;            
            case '-':std::cout <<"="<<sub(num1,num2);break;
            case '*':std::cout <<"="<<mul(num1,num2);break;
            case '/':std::cout <<"="<<dev(num1,num2);break;
            case '^':std::cout <<"="<<poww(num1,num2);break;
            case 'S':std::cout <<"="<<sqr(num1);break;


        }
        

        


    }
};


int main ()
{
    while(1)
    calculator::calc();
}
