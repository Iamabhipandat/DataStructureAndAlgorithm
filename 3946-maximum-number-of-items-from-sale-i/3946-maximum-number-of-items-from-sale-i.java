
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // 0/1 Knapsack
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int price = items[i][1];

            int count = 0;

            // Count purchased item + free items
            for (int j = 0; j < n; j++) {
                if (items[j][0] % factor == 0) {
                    count++;
                }
            }

            // Buy first copy of this item type
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(
                    dp[j],
                    dp[j - price] + count
                );
            }
        }

        int ans = 0;

        // Spend remaining budget on cheapest items
        for (int i = 0; i <= budget; i++) {
            ans = Math.max(
                ans,
                dp[i] + (budget - i) / minPrice
            );
        }

        return ans;
    }
}
