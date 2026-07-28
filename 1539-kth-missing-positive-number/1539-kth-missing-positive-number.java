class Solution {
    public int findKthPositive(int[] arr, int k) {
     int low = 0, high = arr.length-1;

     while(low<=high){
        int mid = (low+high)/2;
        int correcNO = mid+1;
        int missingNo = arr[mid]-correcNO;
        if(missingNo>=k){
            high = mid-1;
        }else{
            low = mid+1;
        }
     }
     return high+1+k;
    }
}