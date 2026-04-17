package BinarySearch;

public class FirstandlastOccurence {

        public static void main(String[] args){
            int[] arr = {1,2,3,4,5,6,7};
            int target = 3;


            int[] ans  = { -1,-1};
            int start = binarySearch(arr,target , true);
            int end = binarySearch(arr,target , false);

            ans[0]= start;
            ans[1] = end;

            System.out.println(ans[0]+" "+ans[1]);


        }
        static  int binarySearch(int[] arr,int target,boolean FirstStartIndex){
            int ans = -1;
            int start = 0;
            int end = arr.length-1;
            while(start<=end){
                int mid = start + (end-start)/2;
                if(arr[mid]<target){
                    start = mid+1;

                }else if(arr[mid]>target){
                    end= mid-1;
                }else {

                    ans = mid;
                    if(FirstStartIndex)
                        end = mid-1;
                    else
                        start = mid+1;
                }
            }
            return ans;
        }
    }

