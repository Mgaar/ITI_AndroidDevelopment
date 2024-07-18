class Solution {
public:
    int addDigits(int num) {
        int sum=0;
    if (num<10)
    return num;
    else
    while (num)
    { 
    while (num)
    {
       
sum+=num%10;
num/=10;
    }
    if (sum>9)
    {
    num=sum;
sum=0;
    }
    }
    return sum;
    }
  
};
