package BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {

    }
    public int splitArray(int[] nums, int k) {
int start = 0;
int end = 0;
for(int i = start; i < nums.length; i++){
   start = Math.max(start,nums[i]);// in the end of the loop this will contain the max item the max element from the array
end += nums[i];


}
while(start<end){
    int mid = start +(end-start)/2;
    int sum = 0;
    int peices = 1;
    for(int num : nums){
        sum += num;
    }

if(peices>k){
    start = mid+1;
}else {
    end = mid;
}
}

     return end;
}
}
