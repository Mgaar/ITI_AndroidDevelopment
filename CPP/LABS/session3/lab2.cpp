namespace DynamicAlloc {
    int** create(int size,int col)
    {
        int** ptr = new int*[size];
        for (int i = 0;i < size;i++)
            ptr[i] = new int[col];
        return ptr;
   }
    void delete2d(int** ptr,int size)
    {
        for (int i = 0;i < size;i++)
            delete[] ptr[i];
        delete[] ptr;
    }
}

int main()
{
    int**arr2d=DynamicAlloc::create(10,5);
   DynamicAlloc::delete2d(arr2d, 10);
    std::cout << "all";
    return 0;

}
