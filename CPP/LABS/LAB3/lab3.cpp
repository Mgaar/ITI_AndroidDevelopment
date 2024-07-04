#include "iostream"
typedef int* (*callback)(int** arr2d, int arrsize, int* colsize, int (*func)(int*, int));
int* add(int** arr2d, int arrsize, int* colsize, int (*func)(int*, int))
{
	int* ptr = (int*)malloc(arrsize * sizeof(int));
	if (ptr != 0)
	{
		for (int i = 0;i < arrsize;i++)
		{
			ptr[i] = func(arr2d[i], colsize[i]);
		}
	}
	else
		std::cout << "not enough space";
	return ptr;

}
int myfunc(int*arr, int size)
{
	int sum = 0;
	for (int i = 0;i < size;i++)
	{
		sum += arr[i];

	}
	return sum;

}
int main()
{
	
	
	int rows = 3;
	int sizes[3] = { 5,6,2 };
	int** arr = new int* [rows];
	arr[0] = new int[sizes[0]] { 5, 5, 5, 5, 5 };
	arr[1] = new int[sizes[1]] { 1, 1, 1, 1, 1, 1 };
	arr[2] = new int[sizes[2]] { 2, 2 };
	int*ptr=add(arr, 3, sizes, myfunc);
	for(int i=0;i<3;i++)
	std::cout << "sum of "<<i+1<<" array is " << ptr[i] << std::endl;
	return 0;
}
