class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merge = new int[n+m];
        for(int i = 0;i<n;i++){
            merge[i] = nums1[i];
        }
        for(int j = 0;j<m;j++){
            merge[n+j] = nums2[j];
        }
        Arrays.sort(merge);
        int len = merge.length;
        int mid = len/2;

        if(len%2==1){
            return merge[mid];
        }else{
            return ((merge[mid-1]+merge[mid])/2.0);
        }
    }
}