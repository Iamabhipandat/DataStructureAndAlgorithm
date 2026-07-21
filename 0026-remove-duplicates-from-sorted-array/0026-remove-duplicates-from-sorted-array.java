class Solution {
    public int removeDuplicates(int[] nums) {

      if(nums.length==0){
        return 0;
      }
      int i = 0;
      int unique = 1;
      int j = 1;
      int n = nums.length;
      while(j<n){
        if(nums[j]==nums[j-1]){
            j++;
            continue;
        }else{
            nums[i+1]=nums[j];
            i++;
            j++;
            unique++;
        }

      }
      return unique;
      }
}