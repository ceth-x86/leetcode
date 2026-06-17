#include <algorithm>
#include <cassert>
#include <iostream>
#include <string>
#include <vector>

int maxProfit(const std::vector<int>& prices) {
    std::vector<int> prefixMin(prices.size());
    prefixMin[0] = prices.front();

    for (std::size_t i = 1; i < prices.size(); ++i) {
        prefixMin[i] = std::min(prefixMin[i - 1], prices[i]);
    }

    int bestProfit = 0;
    for (std::size_t i = 0; i < prices.size(); ++i) {
        bestProfit = std::max(bestProfit, prices[i] - prefixMin[i]);
    }

    return bestProfit;
}

struct TestCase {
    std::string name;
    std::vector<int> prices;
    int expected;
};

int main() {
    std::vector<TestCase> tests = {
        {"example 1: profitable swing", {7, 1, 5, 3, 6, 4}, 5},
        {"example 2: decreasing",       {7, 6, 4, 3, 1},    0},
        {"single price",                {5},                0},
        {"two increasing",              {1, 2},             1},
        {"two decreasing",              {2, 1},             0},
        {"best sale before later low",  {2, 4, 1},          2},
        {"multiple valleys",            {3, 2, 6, 5, 0, 3}, 4},
        {"all equal",                   {5, 5, 5},          0},
        {"zero price",                  {0, 4, 0, 10},      10},
    };

    for (const auto& [name, prices, expected] : tests) {
        int result = maxProfit(prices);
        assert(result == expected);
        std::cout << "PASS: " << name << std::endl;
    }

    std::cout << "\nAll tests passed!" << std::endl;
    return 0;
}
