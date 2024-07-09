#include <iostream>
#include <typeinfo>

enum e {
    int_t = 0,
    char_t = 1,
    double_t = 2,
    unknown_t = 3
};

class vPointerArray {
private:
    void **ptr;
    int size;

public:
    vPointerArray(int size) : size{size}, ptr{new void*[size]} {}
    ~vPointerArray() {
        for (int i = 0; i < size; i++) {
            switch (getdatatype(i)) {
                case e::int_t: delete static_cast<int*>(ptr[i]); break;
                case e::char_t: delete[] static_cast<char*>(ptr[i]); break;
                case e::double_t: delete static_cast<double*>(ptr[i]); break;
                default: break;
            }
        }
        delete[] ptr;
    }

    void setvalue(int index, void *value) { ptr[index] = value; }
    void* getvalue(int index) { return ptr[index]; }
    int getsize() const { return size; }

    e getdatatype(int index) {
        if (typeid(*static_cast<int*>(ptr[index])) == typeid(int)) {
            return e::int_t;
        } else if (typeid(*static_cast<char*>(ptr[index])) == typeid(char)) {
            return e::char_t;
        } else if (typeid(*static_cast<double*>(ptr[index])) == typeid(double)) {
            return e::double_t;
        } else {
            return e::unknown_t;
        }
    }

    void print() {
        for (int i = 0; i < size; i++) {
            switch (getdatatype(i)) {
                case e::int_t: 
                    std::cout << "int " << "data " << *(static_cast<int*>(ptr[i])) << std::endl;
                    break;
                case e::char_t: 
                    std::cout << "char " << "data " << static_cast<char*>(ptr[i]) << std::endl;
                    break;
                case e::double_t: 
                    std::cout << "double " << "data " << ())*(static_cast<double*>(ptr[i])) << std::endl;
                    break;
                default:
                    std::cout << "Unknown type" << std::endl;
                    break;
            }
        }
    }
};

int main() {
    vPointerArray arr(2);
    int x = 5;
    char str[6] ="hello";
    

    arr.setvalue(0, &x);
    arr.setvalue(1, str);
    std::cout<<"h";
    arr.print();
    std::cout<<"h";

    return 0;
}
