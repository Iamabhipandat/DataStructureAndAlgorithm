package BinarySearch;
import java.util.Arrays;
public class ForSorted2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {11,22,33,44},
                {222,333,444,5555}
        };
        // int target = 55;
        System.out.print(Arrays.toString(Search(arr,55555)));
    }
    static int[] Search(int[][] arr, int target){
        int r = 0;
        int col = arr[0].length-1;
        while(r<arr.length && col>=0){
            if(arr[r][col]== target){
                return new int[]{r,col};
            }
            if(arr[r][col]<target){
                r++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}
