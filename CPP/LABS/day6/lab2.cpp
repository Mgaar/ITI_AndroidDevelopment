#include"iostream"
template <typename t1,typename t2>

class pair {
private :
    t1 first;
    t2 second;
    public :
    pair (t1 first=0,t2 second=0):first{first},second{second}{}
    t1 getfirst (void){return this->first;}
    t2 getsecond (void){return second;}
    void setfirst (t1 first){this->first=first;}
    void setsecond (t2 second){this->second=second;}
    void setpair (t1 first,t2 second){setfirst(first);setsecond(second);}
   /* void swap (void){int temp=this->first;
    this->first=this->second;
    this->second=temp;}*/
    void print (void){    std::cout <<"first ="<< first << "    second"<<second<< std::endl;}

    
};


int main ()
{
    pair<int,int> p1(5,10);
    pair<int,int> p2;
    p2.setfirst(550);
    p2.setsecond(100);
    p1.print();
    p2.print();
pair<int,int> p3;
p3.setpair(10,20);
p3.print();
//p3.swap();
p3.print();

    return 0;
}
