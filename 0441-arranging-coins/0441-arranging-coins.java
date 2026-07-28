class Solution {
       public int mySqrt(long x) {
    long low = 1, high = x;
    while(low<=high){
       long mid = low+(high-low)/2;
        if(mid==x/mid){
            return   (int) mid;
          
        }else if(mid>x/mid){
            high = mid-1;
        }else{
            low = mid+1;
        }
    }
       return (int)(high);
       }
    public int arrangeCoins(long n) {
        long m = (long)n;
       return (int)((mySqrt(8 * n + 1) - 1) / 2);
       }

}