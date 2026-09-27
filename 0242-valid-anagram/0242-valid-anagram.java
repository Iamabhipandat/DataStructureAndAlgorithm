class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
    return false;
}
       HashMap<Character ,Integer> Amap = new HashMap<>();
       for(char ch : s.toCharArray()){
        if(Amap.containsKey(ch)){
            int freq = Amap.get(ch);
            Amap.put(ch,freq+1);
        }else{
            Amap.put(ch,1);
        }
       }
       HashMap<Character ,Integer> Bmap = new HashMap<>();
       for(char ch : t.toCharArray()){
        if(Bmap.containsKey(ch)){
            int freq = Bmap.get(ch);
            Bmap.put(ch,freq+1);
        }else{
            Bmap.put(ch,1);
        }
       }
       for(char ch : Amap.keySet()){

        if(!Bmap.containsKey(ch)){
            return false;
        }
        if(!Amap.get(ch).equals(Bmap.get(ch))){
            return false;
        }
       }
       return true;
    }
}