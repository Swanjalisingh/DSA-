import java.util.*;

class Solution {

    private void dfs(int node, Map<Integer, List<Integer>> adj,
                     boolean[] visited, int[] info) {

        visited[node] = true;
        info[0]++; // number of nodes
        info[1] += adj.getOrDefault(node, new ArrayList<>()).size(); // total degrees

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, info);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i]) continue;

            int[] info = new int[2]; // info[0] = nodes, info[1] = total degrees

            dfs(i, adj, visited, info);

            // For a complete graph:
            // Sum of degrees = k * (k - 1)
            if (info[0] * (info[0] - 1) == info[1]) {
                result++;
            }
        }

        return result;
    }
}