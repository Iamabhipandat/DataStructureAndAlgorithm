package linearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {

        int[][] arr = {
                {2,4,5,6},
                {1,5,89,0},
                {30,29,90,3}

        };
        int target = 89;
        int[] ans = Search(arr,target);
        System.out.println(Arrays.toString(ans));

        System.out.println(Search2(arr));
        System.out.println(Search3(arr));


    }
    static int Search3(int[][] arr) {
        int min = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col]<min) {
                    min=arr[row][col];

                }
            }

        }
        return min;
    }
    static int Search2(int[][] arr){
        int max = Integer.MIN_VALUE;
        for(int row = 0;row<arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){
                if(arr[row][col] >max){
                    max=arr[row][col];

                }
            }

        }
        return max;
    }
    static int[] Search(int[][] arr,int target){
        for(int row = 0;row<arr.length;row++){
            for(int col = 0;col<arr[row].length;col++){
                if(arr[row][col]==target){
                    return new int[]{row,col};
                }
            }

        }
        return new int[]{-1,-1};

    }
}
