package BinarySearch;

public class MinimunInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {7,8,9,1,2,3,4};
//        int target = 1;
        System.out.print(rotatedArray(arr));
    }
    static int rotatedArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = start + (end - start) / 2;

            // If mid element is greater than end → min in right
            if(arr[mid] > arr[end]){
                start = mid + 1;
            }
            // Else min is in left (including mid)
            else{
                end = mid;
            }
        }

        // start == end → index of minimum
        return start;
    }
}
