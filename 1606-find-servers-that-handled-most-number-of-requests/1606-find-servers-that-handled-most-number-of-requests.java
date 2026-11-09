
import java.util.*;

class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        // Initially all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Process every request
        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers whose requests are completed
            while (!busy.isEmpty() && busy.peek()[0] <= time) {

                int[] server = busy.poll();

                available.add(server[1]);
            }

            // If all servers are busy, drop request
            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int preferred = i % k;

            // Find preferred or next available server
            Integer server = available.ceiling(preferred);

            // Wrap around if necessary
            if (server == null) {
                server = available.first();
            }

            // Assign request
            available.remove(server);

            count[server]++;

            // Calculate when server becomes free
            int endTime = arrival[i] + load[i];

            busy.offer(new int[]{endTime, server});
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        // Return all servers with maximum requests
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}
