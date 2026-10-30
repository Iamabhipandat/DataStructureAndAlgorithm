
import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
        }

        // dist[node][count]
        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        // Priority Queue: {distance, node, consecutiveCount}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Starting node has one character
        if (k < 1) return -1;

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long d = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            if (d != dist[node][count]) {
                continue;
            }

            // Destination reached
            if (node == n - 1) {
                return (int) d;
            }

            for (int[] edge : graph[node]) {

                int next = edge[0];
                int weight = edge[1];

                int newCount;

                if (labels.charAt(node) == labels.charAt(next)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                // Cannot have more than k identical characters
                if (newCount > k) {
                    continue;
                }

                long newDist = d + weight;

                if (newDist < dist[next][newCount]) {

                    dist[next][newCount] = newDist;

                    pq.offer(new long[]{
                        newDist, next, newCount
                    });
                }
            }
        }

        return -1;
    }
}
