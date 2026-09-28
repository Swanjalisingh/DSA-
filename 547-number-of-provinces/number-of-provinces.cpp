// class Solution {
// public:

//     void bfs(vector<vector<int>>& isConnected, int start, vector<bool>& visited) {
//         queue<int> q;

//         q.push(start);
//         visited[start] = true;

//         while (!q.empty()) {
//             int node = q.front();
//             q.pop();

//             for (int j = 0; j < isConnected.size(); j++) {
//                 if (isConnected[node][j] == 1 && !visited[j]) {
//                     q.push(j);
//                     visited[j] = true;
//                 }
//             }
//         }
//     }

//     int findCircleNum(vector<vector<int>>& isConnected) {
//         int n = isConnected.size();

//         vector<bool> visited(n, false);
//         int count = 0;

//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 bfs(isConnected, i, visited);
//                 count++;
//             }
//         }

//         return count;
//     }
// };























class Solution {
public:

    void dfs(vector<vector<int>>& isConnected, int node, vector<bool>& visited) {
        visited[node] = true;

        for (int j = 0; j < isConnected.size(); j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(isConnected, j, visited);
            }
        }
    }

    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();

        vector<bool> visited(n, false);
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }
};