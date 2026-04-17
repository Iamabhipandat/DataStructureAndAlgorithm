package linearSearch;

public class MinimumNumber {
    public static void main(String[] args) {
        int[] arr ={2,4,56,2,1,5};
        System.out.println(minimumNumber(arr));

    }

    static int minimumNumber(int[] arr){
        int ans = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i]<ans){
                arr[i]= ans;

            }
        }
        return ans;
    }
}
