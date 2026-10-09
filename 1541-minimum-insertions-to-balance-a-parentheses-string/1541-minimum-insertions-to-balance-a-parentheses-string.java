
import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                // Check whether the next character is ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    ans++; // Insert the missing ')'
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    ans++; // Insert the missing '('
                }
            }
        }

        // Every remaining '(' needs two ')'
        ans += stack.size() * 2;

        return ans;
    }
}
