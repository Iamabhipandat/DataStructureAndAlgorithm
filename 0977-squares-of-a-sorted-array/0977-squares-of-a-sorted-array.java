class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;
        int j = n - 1;
        int idx = n - 1;

        while (i <= j) {
            int left  = nums[i]*nums[i];
            int right= nums[j]*nums[j];


            if(left<right){
                ans[idx]= right;
                j--;
            }else{
                ans[idx]= left;
                i++;
            }
            idx--;
        }
    

        return ans;
    }
}
        
