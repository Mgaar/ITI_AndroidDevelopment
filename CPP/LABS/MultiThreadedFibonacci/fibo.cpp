#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <vector>
#include <algorithm> 

std::vector<long long> fiboResults;
std::mutex mtx;
std::condition_variable cv;

long long fibonacci(int n) {
    if (n <= 1) return n;
    long long a = 0, b = 1, c;
    for (int i = 2; i <= n; ++i) {
        c = a + b;
        a = b;
        b = c;
    }
    return b;
}

void calculateFibo(int index, int n) {
    long long result = fibonacci(n);
    std::lock_guard<std::mutex> lock(mtx);
    fiboResults[index] = result;
    cv.notify_all();  
}

void printResults(const std::vector<int>& indices) {
    std::unique_lock<std::mutex> lock(mtx);
    cv.wait(lock, [&indices]() {
        for (int index : indices) {
            if (fiboResults[index] == -1) return false;  
        }
        return true;
    });

    long long sum = 0;
    for (int index : indices) {
        std::cout << "Fibonacci(" << index << ") = " << fiboResults[index] << std::endl;
        sum += fiboResults[index];
    }
    std::cout << "Sum of results = " << sum << std::endl;
}

int main() {
    std::vector<int> indices = {4, 9, 14, 17};
    fiboResults.resize(*std::max_element(indices.begin(), indices.end()) + 1, -1);
    std::vector<std::thread> threads;
    for (size_t i = 0; i < indices.size(); ++i) {
        threads.emplace_back(calculateFibo, indices[i], indices[i]);
    }
    std::thread printThread(printResults, std::cref(indices));
    for (auto& th : threads) {
        th.join();
    }
    printThread.join();

    return 0;
}

