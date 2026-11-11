
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth,
                            int need1, int need2) {

        long both = Math.min(costBoth, (long) cost1 + cost2);

        long common = Math.min(need1, need2);
        long extra1 = need1 - common;
        long extra2 = need2 - common;

        long ans = common * both;

        ans += extra1 * Math.min(cost1, costBoth);
        ans += extra2 * Math.min(cost2, costBoth);

        return ans;
    }
}
