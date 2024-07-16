/*
Implement a class for a dynamic array (Vector)
    * Containing the following functions
        * resize() - resize the array to double the size
        * pushback(value) - add the value to the end of the array
        * popback() - remove the last element from the array
        * removeAt(index) - remove the element at the given index
        * insertAt(index, value) - insert the value at the given index and shift the elements to the right
        * insertMiddle(value) - insert the value in the middle of the array
        * removeMiddle() - remove the middle element from the array
        * size() - return the size of the array
        * print() - print the array
 
    * The following overload constructors:
        * DynamicArray() - default constructor with capacity of 1
        * DynamicArray(size) - constructor with given capacity
        * DynamicArray(size, value) - constructor with given capacity and initial value for all elements --> DynamicArray arr(5, 10);
        * DynamicArray(size, values) - constructor with given capacity and initial values --> DynamicArray arr(5, new int[5]{1, 2, 3, 4, 5});
        * DynamicArray(arr) - copy constructor
 
    * Appropriate destructor
 
    - Private members:
        * array - pointer to the array
        * capacity - capacity of the array
        * currentSize - current size of the array
 */
#include "initializer_list"
#include "iostream"

template <typename t>

class DynamicArray {
private :
t * ptr;
int capacity;
int currentsize;
public:
DynamicArray():ptr{new t},capacity{1},currentsize{0}{}
DynamicArray(int capacity):ptr{new t[capacity]},capacity{capacity},currentsize{0}{}
DynamicArray(int capacity,t value):ptr{new t[capacity]{value}},capacity{capacity},currentsize{capacity}{}
DynamicArray(int capacity,std::initializer_list <t> list):ptr{new t[capacity]},capacity{capacity},currentsize{capacity}
{
    int j=0;
    for (auto i:list)
    {
ptr[j]=i;
j++;
    }
}
DynamicArray(const DynamicArray & source):DynamicArray(source.capacity)
{
    for (int i=0;i<source.capacity;i++)
    {
        this->ptr[i]=source.ptr[i];
    }
}
~DynamicArray(){delete []this->ptr;}
void resize(void)
{
    t * temp=new t[capacity*2] ;
    for (int i=0;i<currentsize;i++)
    temp[i]=ptr[i];
    delete []ptr;
    ptr=temp;
    capacity=capacity*2;
}
void pushback (t v)
{
    if (currentsize==capacity)
    resize();
    ptr[currentsize]=v;
    currentsize++;
}
void popback ()
{
    currentsize--;
}
void removeat (int index)
{
    for (int i=index;i<currentsize-1;i++)
    {
        ptr[i]=ptr[i+1];
    }
    currentsize--;
}
void insertAt(int index,t v)
{
    t temp;
    t t2;
if (currentsize==capacity)
    resize();
    temp=ptr[index];
    ptr[index++]=v;
    for (int i=index;i<currentsize+1;i++)
    {
        t2=ptr[i];
ptr[i]=temp;
temp=t2;
    }
    currentsize++;
}
void insertmiddle (t d)
{
insertAt(currentsize/2,d);
}
void removemiddle ()
{
removeat(currentsize/2);
}
int size(){return currentsize;}
void print(void) {for (int i=0;i<currentsize;i++)std::cout << ptr[i]<<" ";}
};



