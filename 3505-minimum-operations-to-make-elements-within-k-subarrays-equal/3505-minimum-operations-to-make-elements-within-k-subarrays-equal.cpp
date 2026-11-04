
class Solution {
public:
    multiset<int> lo, hi;
    long long sumLo = 0, sumHi = 0;

    void add(int x) {
        if (lo.empty() || x <= *lo.rbegin()) {
            lo.insert(x);
            sumLo += x;
        } else {
            hi.insert(x);
            sumHi += x;
        }
        balance();
    }

    void remove(int x) {
        auto it = lo.find(x);

        if (it != lo.end()) {
            lo.erase(it);
            sumLo -= x;
        } else {
            it = hi.find(x);
            hi.erase(it);
            sumHi -= x;
        }

        balance();
    }

    void balance() {
        while (lo.size() > hi.size() + 1) {
            int x = *lo.rbegin();
            lo.erase(prev(lo.end()));
            sumLo -= x;

            hi.insert(x);
            sumHi += x;
        }

        while (lo.size() < hi.size()) {
            int x = *hi.begin();
            hi.erase(hi.begin());
            sumHi -= x;

            lo.insert(x);
            sumLo += x;
        }
    }

    long long getCost() {
        long long median = *lo.rbegin();

        return median * lo.size() - sumLo
             + sumHi - median * hi.size();
    }

    long long minOperations(vector<int>& nums, int x, int k) {
        int n = nums.size();

        // Calculate cost of every window of size x.
        vector<long long> cost(n - x + 1);

        for (int i = 0; i < n; i++) {
            add(nums[i]);

            if (i >= x) {
                remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = getCost();
            }
        }

        // DP: minimum cost to select j non-overlapping windows
        // from the first i elements.
        const long long INF = 1e18;

        vector<long long> prev(n + 1, 0);
        vector<long long> curr(n + 1, INF);

        for (int j = 1; j <= k; j++) {
            fill(curr.begin(), curr.end(), INF);

            for (int i = 1; i <= n; i++) {
                // Do not select a window ending here.
                curr[i] = curr[i - 1];

                // Select the window [i-x, i-1].
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev.swap(curr);
        }

        return prev[n];
    }
};
