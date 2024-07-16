class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int i=0;
        int max=0;
        int temp=0;
        for (int i=0;i<gain.size();i++)
        {
            temp=temp+gain[i];
            if (temp>max)
            max=temp;
        }
        return max;
        
    }
};
