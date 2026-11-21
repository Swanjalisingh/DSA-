class Solution {
public:
    vector<int> findSubtreeSizes(vector<int>& parent, string s) {
        int n = parent.size();

        vector<vector<int>> adj(n);

        // Step 1: Build the original tree
        for (int i = 1; i < n; i++) {
            adj[parent[i]].push_back(i);
        }

        // Step 2: Find new parent for every node
        vector<int> newParent(n, -1);
        vector<int> last(26, -1);

        function<void(int)> dfs = [&](int node) {
            int ch = s[node] - 'a';

            int old = last[ch];
            last[ch] = node;

            if (old != -1) {
                newParent[node] = old;
            } else {
                newParent[node] = parent[node];
            }

            for (int child : adj[node]) {
                dfs(child);
            }

            last[ch] = old;
        };

        dfs(0);

        // Step 3: Build the modified tree
        vector<vector<int>> tree(n);

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].push_back(i);
        }

        // Step 4: Calculate subtree sizes
        vector<int> ans(n, 1);

        function<void(int)> calculate = [&](int node) {
            for (int child : tree[node]) {
                calculate(child);
                ans[node] += ans[child];
            }
        };

        calculate(0);

        return ans;
    }
};