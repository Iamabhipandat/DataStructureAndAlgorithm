
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find minimum price and count factors
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Count all multiples for each factor
        int[] multiples = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            multiples[i] = freq[i];

            for (int j = i * 2; j <= n; j += i) {
                multiples[i] += freq[j];
            }
        }

        // Step 3: Store bonus opportunities by price
        TreeMap<Integer, Long> map = new TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            // Buying this item must be cheaper than
            // buying two cheapest items
            if (price >= 2L * minPrice) {
                continue;
            }

            // Exclude the item itself
            int freeCount = multiples[factor] - 1;

            if (freeCount > 0) {
                map.put(price,
                    map.getOrDefault(price, 0L) + freeCount);
            }
        }

        // Step 4: Greedily purchase bonus opportunities
        long ans = 0;
        long remaining = budget;

        for (Map.Entry<Integer, Long> entry : map.entrySet()) {

            int price = entry.getKey();
            long count = entry.getValue();

            long buy = Math.min(count, remaining / price);

            remaining -= buy * price;

            // Each purchased item gives one free item
            ans += buy * 2;
        }

        // Step 5: Spend remaining budget on cheapest item
        ans += remaining / minPrice;

        return (int) ans;
    }
}
