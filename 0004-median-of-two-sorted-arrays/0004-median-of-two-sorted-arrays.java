class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] Merged = new int[n+m];
        for(int i =0;i<n;i++){
            Merged[i] = nums1[i];
        }
        for(int j = 0;j<m;j++){
            Merged[n+j] = nums2[j];
        }
        Arrays.sort(Merged);
        int len = Merged.length;
        int mid = len / 2;

        if (len % 2 == 1) {
            return Merged[mid];
        } else {
            return (Merged[mid - 1] + (double) Merged[mid]) / 2.0;
        }
    }
}