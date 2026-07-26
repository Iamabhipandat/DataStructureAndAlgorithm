class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 1;
        int end = arr.length-2;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>arr[mid-1]&& arr[mid]>arr[mid+1]){
                return mid;
            }else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}