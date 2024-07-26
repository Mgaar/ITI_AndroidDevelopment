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
    // Create a thread to run the beeb function with a 3-second delay
    std::thread obj(beeb, 3);

    // Wait for the user to press Enter
    std::cin.ignore();
    std::cin.get(flag);
if (flag=='\n')
    // Signal the beeping thread to stop
    flag = false;

    // Wait for the beeping thread to finish
    obj.join();

    return 0;
}
