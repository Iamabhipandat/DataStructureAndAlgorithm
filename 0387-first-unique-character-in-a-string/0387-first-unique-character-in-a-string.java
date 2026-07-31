class Solution {
    public int firstUniqChar(String s) {
       int n = s.length();
       int[] freq = new int[26];
       for(int i = 0;i<n;i++){
        char ch = s.charAt(i);
        int idx = ch-'a';
        freq[idx]++;
       }
       int minfreq = Integer.MAX_VALUE;
       char ans = s.charAt(0);
       for(int i = 0;i<n;i++){
         char ch = s.charAt(i);
        int idx = ch-'a';
        if(freq[idx]==1){
            return i;
            
        }
       }
       
     
      
        return -1;
        
    }
}