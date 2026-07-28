class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int rows = arr.length, cols = arr[0].length;
        int low =0, high = rows*cols-1;
        while(low<=high){
            int mid = (low+high)/2;
            int midRows = mid/cols,midCol = mid%cols;
            if(arr[midRows][midCol]==target){
                return true;
            }else if(arr[midRows][midCol]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
    return false;
    }
}