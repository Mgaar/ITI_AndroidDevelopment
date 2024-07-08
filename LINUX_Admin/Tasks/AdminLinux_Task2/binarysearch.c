#include "stdio.h"

int binsearch (int*arr,int size,int num)
{
int first=0;
int last=size-1;
int current =size/2;
while(first<=last)
{
if (arr[current]==num)
	return current;
else if (arr[current]>num)
	last=current-1;
else 
	first=current+1;
current = (first+last)/2;
}
return -1;
}

int main(){
	int num;

int arr[10]={15,20,31,32,37,40,44,107,152,200};
while(1){
scanf("%d",&num);
printf("%d is at %d\n",num,binsearch(arr,10,num));
	}
	return 0;
}
