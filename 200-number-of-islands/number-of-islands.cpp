// class Solution {
//     private:
//     void Dfs(vector<vector<char>>& grid , int r, int c){
//         int m = grid.size();
//         int n = grid[0].size();
//         grid[r][c] = '0';
//         //up
//         if(r-1 >=0 && grid[r-1][c] == '1')
//          Dfs(grid , r-1, c);
//          //right
//          if(c+1 <n && grid[r][c+1] =='1')
//          Dfs(grid, r, c+1);
//          //down
//          if(r+1 <m && grid[r+1][c] == '1')
//          Dfs(grid , r+1 , c);
//          //left
//          if(c-1 >=0 && grid[r][c-1] == '1')
//          Dfs(grid , r , c-1);

//     }
// public:
//     int numIslands(vector<vector<char>>& grid) {
//          int count =0;
//         int m = grid.size();
//         int n = grid[0].size();
//         if(m ==0){
//             return 0;
//         }

//         for(int r =0; r<m; r++){
//             for(int c=0; c<n; c++){
//                 if(grid[r][c] == '1'){
//                     Dfs(grid , r,c);
//                     count++;

//                 }
//             }
//         }
//         return count;
//     }
// };








///using BFS
class Solution {
private:
    void Bfs(vector<vector<char>>& grid, int r, int c) {
        int m = grid.size();
        int n = grid[0].size();

        queue<pair<int, int>> q;
        q.push({r, c});

        // Mark as visited
        grid[r][c] = '0';

        while (!q.empty()) {
            int row = q.front().first;
            int col = q.front().second;
            q.pop();

            // Up
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                grid[row - 1][col] = '0';
                q.push({row - 1, col});
            }

            // Right
            if (col + 1 < n && grid[row][col + 1] == '1') {
                grid[row][col + 1] = '0';
                q.push({row, col + 1});
            }

            // Down
            if (row + 1 < m && grid[row + 1][col] == '1') {
                grid[row + 1][col] = '0';
                q.push({row + 1, col});
            }

            // Left
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                grid[row][col - 1] = '0';
                q.push({row, col - 1});
            }
        }
    }

public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();

        if (m == 0)
            return 0;

        int n = grid[0].size();
        int count = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == '1') {
                    Bfs(grid, r, c);
                    count++;
                }
            }
        }

        return count;
    }
};