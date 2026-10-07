class Solution {
static int[] dp;
    public int fibboo(int n) {
        if(n<2)return n;
        if(dp[n]!=0)return dp[n];
        int ans = fibboo(n-1)+fibboo(n-2);
        dp[n] = ans;
        return ans;
        
    }
    public int fib(int n) {
        dp = new int[n+1];
        return fibboo(n);
        
    }
}