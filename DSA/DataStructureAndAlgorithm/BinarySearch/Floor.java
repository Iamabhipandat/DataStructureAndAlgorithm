package BinarySearch;

public class Floor {

        public static void main(String[] args) {
            int[] arr= {12,13,14,16,17,18};
            int target = 15;
            int ans = binarSearch(arr,target);
            System.out.print(ans);


        }
        static int binarSearch(int[] arr, int target ){
            int start = 0;
            int end = arr.length-1;
            while(start<=end){
                int mid = 0;
                mid = start+(end-start)/2;
                if(arr[mid]<target){
                    start  = mid+1;
                } else if(arr[mid]>target){
                    end = mid-1;
                }else return mid;
            }
            return end;

        }


    }

