#include <iostream>
#include"string.h"
using namespace std;
int main()
{
    int size ;
    int strsize;
    int j = 0;
    cout << "enter number of strings";
    cin >> size;
    char**arr=(char**)malloc(sizeof(char*)*size);
    if (arr != 0)
    {
        for (int i = 0;i < size;i++)
        {
            cout << "enter size of string " << i + 1 << ":";
            cin >> strsize;
            arr[i] = (char*)malloc(strsize);
            if (arr[i] != 0)
            {
               
                for (;j < strsize;j++)
                {
                    cin >> arr[i][j];
                }
                arr[i][j] = 0;
                j = 0;
            }
            
        }
        for (int i = 0;i < size;i++)
        {
            cout << arr[i] << endl;
        }
    }
    
   
}
