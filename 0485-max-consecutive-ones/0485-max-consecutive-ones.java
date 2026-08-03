class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int i = 0;
        int count= 0;
        for(int j = 0;j<nums.length;j++){

     
            if(nums[j]==1 ){

       
            count++;
            i = Math.max(count,i);
            }
          else  {
            count = 0;
          }

        }
        return i;
        
    }
}