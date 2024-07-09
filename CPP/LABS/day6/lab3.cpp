#include "iostream"

template <typename t1,typename t2>
class KeyValuePair {
    private :
    t1 key;
    t2 value;
    public :
    KeyValuePair(t1 key,t2 value):key{key},value{value}{}
    t2 getvalue(void){return value;}
    t1 getkey(void){return key;}
    void setvalue(t2 value){this->value =value; }
    void setkey(t1 key){this->key=key;}
    void print(void){std::cout<<"key="<<key<<" value="<<value<<std::endl; }
};

int main (){
    KeyValuePair <int ,double> p1 (1,3.15);
    p1.print();
    p1.setkey(5);
    p1.setvalue(25.62);
    p1.print();

    return 0;
}
