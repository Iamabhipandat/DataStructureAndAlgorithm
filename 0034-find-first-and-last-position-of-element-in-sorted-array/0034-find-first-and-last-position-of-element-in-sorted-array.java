class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
       int index = -1;
       int index1 = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid +1;
            }else{
                index = mid;
                end = mid-1;
               

            }
        }
        start = 0;
        end = nums.length-1;
            while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]>target){
                end = mid-1;
            }else if(nums[mid]<target){
                start = mid +1;
            }else{
                index1 = mid;
               start = mid +1;
               

            }
        }
        return new int[]{index,index1};
        
    }
}