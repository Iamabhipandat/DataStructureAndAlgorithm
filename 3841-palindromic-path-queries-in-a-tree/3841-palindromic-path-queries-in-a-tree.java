import java.util.*;

class Solution {
    private int[][] up;
    private int[] depth, tin, tout, parent, size, bit;
    private int n, LOG;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        size = new int[n];
        up = new int[LOG][n];
        bit = new int[n + 1];

        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0, count = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            tin[u] = count;
            order[count++] = u;
            size[u] = 1;

            for (int v : graph[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
            up[0][u] = parent[u];
        }

        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        char[] chars = s.toCharArray();
        int[] prefix = new int[n];

        // Calculate root-to-node parity masks
        for (int u : order) {
            int mask = 1 << (chars[u] - 'a');

            prefix[u] = (u == 0)
                    ? mask
                    : prefix[parent[u]] ^ mask;
        }

        // FIX: Initialize Fenwick Tree using XOR differences
        int previous = 0;

        for (int i = 0; i < n; i++) {
            int u = order[i];
            int difference = prefix[u] ^ previous;

            add(tin[u] + 1, difference);
            previous = prefix[u];
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split(" ");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                if (chars[u] == c) continue;

                int change = (1 << (chars[u] - 'a'))
                           ^ (1 << (c - 'a'));

                rangeXor(tin[u], tout[u], change);
                chars[u] = c;

            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int maskU = query(tin[u] + 1);
                int maskV = query(tin[v] + 1);

                int ancestor = lca(u, v);
                int maskLCA = 1 << (chars[ancestor] - 'a');

                int pathMask = maskU ^ maskV ^ maskLCA;

                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return answer;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    private void add(int index, int value) {
        while (index <= n) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    private int query(int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private void rangeXor(int left, int right, int value) {
        add(left + 1, value);

        if (right + 1 < n) {
            add(right + 2, value);
        }
    }
}