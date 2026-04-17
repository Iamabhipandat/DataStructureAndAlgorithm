package BinarySearch;

public class OrderAgnosticBs {
    public static void main(String[] args) {
        int[] arr= {122222,122,12,2,0,-12};
        int target = 1;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }

    static int binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start) / 2;


            if(arr[mid] == target)
                return mid;

            if(isAsc){
                // ascending order
                if(arr[mid] < target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
               // proper descending logic
                if(arr[mid] > target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return start;
    }
}