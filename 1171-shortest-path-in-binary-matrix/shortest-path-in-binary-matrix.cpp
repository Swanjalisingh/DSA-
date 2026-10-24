// class Solution {
// public:
//     int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
//     int n = grid.size();
//     //deal edge cases;
//     if(n == 0 || grid[0][0] == 1|| grid[n-1][n-1] == 1){
//         return -1;
//     }
//     if(n == 1){ // one cell
//         return 1;
//     }
//     vector<pair<int , int>> directions = {
//         {-1 , 0},{1 , 0},{0 , -1},{0 ,1}, {-1 , -1,},{-1 , 1},{1 ,-1},{1 ,1}};
// // set up the bfs
//      queue<array<int ,3>>q;
//      q.push({0,0,1}); // push sorce
//      grid[0][0] = 1; // make visited
//      while(!q.empty()){
//         auto [r , c, d] = q.front();
//         q.pop();
//         if (r == n - 1 && c == n - 1) {
//                 return d;
//             }
//         //explore the neighbour;
//         for(auto [x ,y] : directions){
//             int rn = r+x;
//             int cn = c+y;
//             if(rn >= 0 && rn<n && cn >=0 && cn <n && grid[rn][cn] == 0){
//                 grid[rn][cn] = 1;
//                 q.push({rn , cn, d+1});
//             }
//         }

//      }
//      return -1;


//     }
// };





























class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        int n = grid.size();

        // Handle edge cases
        if (n == 0 || grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        if (n == 1) {
            return 1;
        }

        vector<pair<int, int>> directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        // Distance matrix
        vector<vector<int>> dist(n, vector<int>(n, INT_MAX));

        // Min-heap: {distance, row, column}
        priority_queue<
            array<int, 3>,
            vector<array<int, 3>>,
            greater<array<int, 3>>
        > pq;

        dist[0][0] = 1;
        pq.push({1, 0, 0});

        while (!pq.empty()) {
            auto [d, r, c] = pq.top();
            pq.pop();

            // Skip outdated distances
            if (d > dist[r][c]) {
                continue;
            }

            // Destination reached
            if (r == n - 1 && c == n - 1) {
                return d;
            }

            // Explore all 8 directions
            for (auto [x, y] : directions) {
                int nr = r + x;
                int nc = c + y;

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    int newDist = d + 1;

                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        pq.push({newDist, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
};
