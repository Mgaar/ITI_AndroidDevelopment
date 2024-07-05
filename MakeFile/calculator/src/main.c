#include "stdio.h"
#include "calculator.h"

int main ()
{
char op;
int num1,num2;
printf("enter operation :");
scanf("%c",&op);
printf("enter num1 :");
scanf("%d",&num1);

printf("enter num2 :");
scanf("%d",&num2);
switch (op){
case '+':add(num1,num2);break;
case '-':sub(num1,num2);break;
case '*':mul(num1,num2);break;
case '/':dev(num1,num2);break;
default :printf("wrong operation symbol");
}
return 0;
}
