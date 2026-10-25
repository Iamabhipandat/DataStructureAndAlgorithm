class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int n1 = t.length();
        int i = 0;
        int j = 0;
        while(j<t.length()){
            if(s.isEmpty()){
                return true;
            }
            if(i<s.length() && s.charAt(i)==t.charAt(j)){
                i++;
                   
            }
            j++;
           
        }
        return i==s.length();
        
    }
}