
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;

                // If the previous ')' was unmatched,
                // insert one ')' to complete its pair.
                if (i > 0 && s.charAt(i - 1) == ')') {
                    // Handled by the closing-parenthesis logic below.
                }
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    ans++;
                }

                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        return ans + 2 * open;
    }
}

