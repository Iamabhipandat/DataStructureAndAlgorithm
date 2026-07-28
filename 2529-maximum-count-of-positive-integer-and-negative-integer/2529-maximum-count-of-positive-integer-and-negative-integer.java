class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int start =0, end = nums.length-1;
        int negative ;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]>=0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
       negative = start;
         
         
     start = 0; end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<=0){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return Math.max(n-start,negative);
    }
}