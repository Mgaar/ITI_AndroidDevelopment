class Solution {
public:
    bool isAnagram(string s, string t) {
        int freq[26]={0};
        int freq2[26]={0};
bool f=true;
        for (int i=0;s[i];i++)
        freq[s[i]-'a']++;
        for (int i=0;t[i];i++)
        freq2[t[i]-'a']++;

        for (int i=0;i<26;i++)
        {
            if (freq[i]!=freq2[i])
            {
f=false;
break;
            }
        }

       return f; 
    }
};
