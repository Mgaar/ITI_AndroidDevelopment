#include "iostream"
#include "vector"

std::vector<std::vector<int>> transpose (std::vector<std::vector<int>>& v)
{
    int rows=v.size();
    int cols=v[0].size();
    std::vector<int> temp;
    std::vector<std::vector<int>>v2;
    for (int i=0;i<cols;i++)
    {
        for(int j=0;j<rows;j++)
        {
            temp.push_back(v[j][i]);
        }
        v2.emplace_back(temp);
        temp.erase(temp.begin(),temp.end());
    }
    
return v2;
}

void print(std::vector<std::vector<int>>v)
{
    int rows=v.size();
    int cols=v[0].size();
    for (int i=0;i<rows;i++)
    {
for (int j=0;j<cols;j++)
{
    std::cout << v[i][j]<<" ";

}
std::cout << std::endl;
    }
}

int main ()
{
std::vector<std::vector<int>>v={{1,2},
                                {4,5},
                                {7,8},
                                {9, 10}};
print(v);                                
auto v2=transpose(v);
print(v2);  

    return 0;
}
