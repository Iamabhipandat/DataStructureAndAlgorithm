class Solution{


public int reverse(int n) {
    boolean negative = n < 0;

    long num = Math.abs((long)n);

    long ans = rev2(num);

    if (negative) ans = -ans;

    if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
        return 0;
    }

    return (int)ans;
}

static long rev2(long n) {
    if (n == 0) return 0;

    int digits = (int)(Math.log10(n) + 1);
    return helper(n, digits);
}

static long helper(long n, int digits) {
    if (n < 10) {
        return n;
    }

    long rem = n % 10;

    return rem * (long)Math.pow(10, digits - 1)
            + helper(n / 10, digits - 1);
}
}