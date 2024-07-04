// Application2.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
struct vec {
    int size ;
    int capacity;
    int* ptr;
};
vec* init( int vsize, int* arr)
{
    
    vec* temp = new (vec);
    temp->capacity = vsize;
    temp->size = vsize;
    temp->ptr = new int[vsize] ;
    for (int i = 0;i < vsize;i++)
    {
        (temp->ptr)[i] = arr[i];
    }
    return temp;
}
void print(vec* vector)
{
    for (int i = 0;i < vector->size;i++)
        std::cout << (vector->ptr)[i] << std::endl;
}
void printbound(vec* vector,int index)
{
    if (index >= 0 && index <= vector->size)
        std::cout << (vector->ptr)[index] << std::endl;
    else
        std::cout << "error out of boundry" << std::endl;
}
void insert(vec* vector, int index,int data)
{
    vector->size++;
    int* nptr;
    if (vector->size > vector->capacity)
    {
        nptr = new int[(vector->capacity) * 2];
        vector->capacity *= 2;
        for (int i = 0;i < (vector->size) - 1;i++)
        {
            nptr[i] = (vector->ptr)[i];
        }
        free(vector->ptr);
        vector->ptr = nptr;
    }
    int temp = (vector->ptr)[index];
    int tt;
    (vector->ptr)[index] = data;
    index++;
   
    for (int i = index;i < vector->size + 1;i++)
    {
        tt = (vector->ptr)[i];
        (vector->ptr)[i] = temp;
        temp = tt;
    }
}
void deletevec(vec* vector, int index)
{
    int ss = vector->size;
    vector->size--;
    for (int i=0;i < vector->size+1;i++)
    {
        if (i == index)
        {
            for (int j = i;j < vector->size ;j++)
            {
                (vector->ptr)[j] = (vector->ptr)[j + 1];
            }
            break;
        }
    }

}
int main()
{
    int arr[5] = { 2,4,6,8,10 };
    int arr2[3] = { 20,40,60 };
    vec* v1 = init(5, arr);
    print(v1);
    printbound(v1, 3);
    printbound(v1, 10);
    insert(v1, 1, 3);
    print(v1);
    deletevec(v1, 4);
    print(v1);
    vec* v2 = init(3, arr2);
    print(v2);
    insert(v2, 3, 30);
    print(v2);
    return 0;
}

