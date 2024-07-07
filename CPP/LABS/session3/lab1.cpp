#include "math.h"
namespace MathFunctions {
    void print(double var)
    {
        
        std::cout << sqrt(var)<<"\n";
    }
}


namespace StringFunctions {
    void print(char* var)
    {
        for (int i=0;var[i];i++)
            if (isupper(var[i]))
        std::cout << (char)(var[i]-'A'+'a') << "\n";
            else 
             std::cout << (char)(var[i] + 'A' - 'a') << "\n";

    }
}


namespace ArrayFunctions {
    void print(int* var,int size)
    {
        for (int i = size-1;i>=0;i--)
                std::cout << toupper(var[i])<<"  ";
        std::cout << "\n";
    }
    
}


int main()
{
    int  arr[5] = {1, 2, 3, 4, 5};

    ArrayFunctions::print(arr, 5);
    StringFunctions::print((char*)"hello WORLD");
    MathFunctions::print(25);
return 0;
}
