//Approach 1:Dijkstra-O(nk+mklog(mk))
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
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

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        
        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long currDist = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            if (currDist != dist[u][count]) {
                continue;
            }

            if (u == n - 1) {
                return (int) currDist;
            }

            for (int[] next : graph[u]) {

                int v = next[0];
                int w = next[1];

                int nextCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                if (nextCount > k) {
                    continue;
                }

                long nextDist = currDist + w;

                if (nextDist < dist[v][nextCount]) {
                    dist[v][nextCount] = nextDist;
                    pq.offer(new long[]{nextDist,v,nextCount});
                }
            }
        }

        return -1;
    }
}