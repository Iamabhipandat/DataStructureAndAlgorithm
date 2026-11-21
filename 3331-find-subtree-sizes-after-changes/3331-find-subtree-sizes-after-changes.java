
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        // Build original tree
        int[] head = new int[n];
        int[] next = new int[n];
        java.util.Arrays.fill(head, -1);

        for (int i = 1; i < n; i++) {
            next[i] = head[parent[i]];
            head[parent[i]] = i;
        }

        // Build modified tree
        int[] newHead = new int[n];
        int[] newNext = new int[n];
        java.util.Arrays.fill(newHead, -1);

        int[] last = new int[26];
        java.util.Arrays.fill(last, -1);

        int[] prevLast = new int[n];
        int[] newParent = new int[n];

        // Iterative DFS with enter/exit events
        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int event = stack[--top];

            if (event >= 0) {
                int node = event;
                int c = s.charAt(node) - 'a';

                prevLast[node] = last[c];
                last[c] = node;

                if (node == 0) {
                    newParent[node] = -1;
                } else {
                    newParent[node] =
                        prevLast[node] == -1
                        ? parent[node]
                        : prevLast[node];
                }

                // Exit event
                stack[top++] = ~node;

                // Enter children
                for (int child = head[node];
                     child != -1;
                     child = next[child]) {
                    stack[top++] = child;
                }

            } else {
                int node = ~event;
                int c = s.charAt(node) - 'a';

                last[c] = prevLast[node];
            }
        }

        // Construct modified tree
        for (int i = 1; i < n; i++) {
            int p = newParent[i];

            newNext[i] = newHead[p];
            newHead[p] = i;
        }

        // Traverse modified tree
        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int node = stack[--top];
            order[count++] = node;

            for (int child = newHead[node];
                 child != -1;
                 child = newNext[child]) {
                stack[top++] = child;
            }
        }

        // Calculate subtree sizes bottom-up
        int[] ans = new int[n];
        java.util.Arrays.fill(ans, 1);

        for (int i = count - 1; i >= 0; i--) {
            int node = order[i];

            if (newParent[node] != -1) {
                ans[newParent[node]] += ans[node];
            }
        }

        return ans;
    }
}
