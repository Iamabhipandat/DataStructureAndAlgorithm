package linearSearch;

public class Arrays {
    public static void main(String[] args){
        int[] nums = {-1,1,2,3,4,5,4};
        int target = 2;
        boolean ans = linearSearch3(nums,target);

        System.out.print(ans);

    }
    static boolean linearSearch3(int[] arr,int target ){
        if(arr.length==0){
            return false;
        }

        for(int element : arr){

            if(element == target){
                return true;
            }
        }
        return false;
    }

    static int linearSearch2(int[] arr,int target ){
        if(arr.length==0){
            return -1;
        }

        for(int element : arr){

            if(element == target){
                return element;
            }
        }
        return -1;
    }
    static int linearSearch(int[] arr,int target ){
        if(arr.length==0){
            return -1;
        }

        for(int index = 0;index<arr.length;index++){
            int element = arr[index];
            if(element == target){
                return index;
            }
        }
        return -1;
    }
    
}
