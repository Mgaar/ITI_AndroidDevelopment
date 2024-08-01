#include <iostream>
#include <atomic>
#include <thread>
#include <chrono>

class Spinlock {
public:
    Spinlock() : flag(ATOMIC_FLAG_INIT) {}

    void lock() {
        int count = 0;
        while (flag.test_and_set(std::memory_order_acquire)) {
            ++count;
            if (count >= 20) {
                std::this_thread::yield(); // Yield control to avoid busy waiting.
                count = 0;
            }
        }
    }

    void unlock() {
        flag.clear(std::memory_order_release);
    }

private:
    std::atomic_flag flag;
};

void multiplyByTwo(int& sharedVar, Spinlock& spinlock) {
    for (int i = 0; i < 10; ++i) {
        spinlock.lock();
        sharedVar *= 2;
        std::cout << "Multiplied by 2: " << sharedVar << std::endl;
        spinlock.unlock();
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
    }
}

void divideByTwo(int& sharedVar, Spinlock& spinlock) {
    for (int i = 0; i < 10; ++i) {
        spinlock.lock();
        sharedVar /= 2;
        std::cout << "Divided by 2: " << sharedVar << std::endl;
        spinlock.unlock();
        std::this_thread::sleep_for(std::chrono::milliseconds(50));
    }
}

int main() {
    Spinlock spinlock;
    int sharedVar = 1;

    std::thread t1(multiplyByTwo, std::ref(sharedVar), std::ref(spinlock));
    std::thread t2(divideByTwo, std::ref(sharedVar), std::ref(spinlock));

    t1.join();
    t2.join();

    return 0;
}
