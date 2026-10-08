class Solution {
    public String removeOuterParentheses(String s) {

        int open = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                if (open > 0) {
                    ans.append('(');
                }
                open++;
            } 
            else {
                open--;
                if (open > 0) {
                    ans.append(')');
                }
            }
        }

        return ans.toString();
    }
}