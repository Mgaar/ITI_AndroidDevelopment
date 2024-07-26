#include <iostream>
#include <thread>
#include <chrono>

bool flag = true;

void beeb(int x) {
    while (flag) {
        std::this_thread::sleep_for(std::chrono::seconds(x));
        std::cout << "\a" << std::flush;
        
    }
}

int main() {
    std::thread obj(beeb, 3);
    std::cin.ignore();
    std::cin.get(flag);
if (flag=='\n')
    flag = false;
    obj.join();

    return 0;
}
