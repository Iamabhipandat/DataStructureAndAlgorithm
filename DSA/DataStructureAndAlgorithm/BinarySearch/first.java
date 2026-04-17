package BinarySearch;

public class first {
    public static void main(String[] args) {
        int[] arr= {-12,-1,0,12,122,1222,122222};
        int target = 1222;
        int ans = binarySearch(arr,target);
        System.out.println(ans);

    }

    static int binarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<target){
                start = mid+1;

            }else if(arr[mid]>target){
                end= mid-1;
            }else return mid;
        }
    return -1;
    }
}
