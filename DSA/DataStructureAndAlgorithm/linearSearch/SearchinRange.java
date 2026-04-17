package linearSearch;

public class SearchinRange {
    public static void main(String[] args) {

        int[] arr = {2,4,5,3,5,6,6};
        int target = 9;
        System.out.println(linearSearch(arr,target ,1,4));


}

    static int linearSearch(int[] arr,int target,int start ,int end ){
        if(arr.length==0){
            return -1;
        }

        for(int index = start;index<end;index++){
            int element = arr[index];
            if(element == target){
                return index;
            }
        }
        return -1;
    }
}
