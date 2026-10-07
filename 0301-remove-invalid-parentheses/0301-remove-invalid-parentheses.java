class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        int left = 0;
        int right = 0;

        // Find minimum number of invalid '(' and ')'
        for (char c : s.toCharArray()) {

            if (c == '(') {
                left++;
            } 
            else if (c == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, new StringBuilder(), ans);

        return ans;
    }


    void dfs(String s, int index, int left, int right,
             StringBuilder curr, List<String> ans) {

        // Reached end
        if (index == s.length()) {

            if (left == 0 && right == 0 && isValid(curr)) {

                String str = curr.toString();

                if (!ans.contains(str)) {
                    ans.add(str);
                }
            }

            return;
        }


        char c = s.charAt(index);


        // -------- REMOVE --------

        if (c == '(' && left > 0) {
            dfs(s, index + 1, left - 1, right, curr, ans);
        }

        if (c == ')' && right > 0) {
            dfs(s, index + 1, left, right - 1, curr, ans);
        }


        // -------- KEEP --------

        curr.append(c);

        dfs(s, index + 1, left, right, curr, ans);

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);
    }


    // Check whether parentheses are valid
    boolean isValid(StringBuilder s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                count++;
            } 
            else if (c == ')') {

                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}