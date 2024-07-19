class Solution {
public:
    string addStrings(string num1, string num2) {
          int s1 = num1.size() - 1;
        int s2 = num2.size() - 1;
        int carry = 0;
        int sum;
        int n1,n2;
        std::string result;

        while (s1 >= 0 || s2 >= 0 || carry) {
            if (s1>=0)
            {
                n1=num1[s1]-'0';
                s1--;
            }
            if (s2>=0)
            {
                n2=num2[s2]-'0';
                s2--;
            }
           
             sum = n1 + n2 + carry;
            carry = sum / 10;
            if(carry)
            sum=sum-10;
            n1=0;
            n2=0;
            result.push_back(sum + '0');
        }

        std::reverse(result.begin(), result.end());
        return result;
    }
};
