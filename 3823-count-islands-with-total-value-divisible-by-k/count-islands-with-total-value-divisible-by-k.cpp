class Solution {
    vector<vector<int>> grid;
    vector<vector<bool>>visited;
public:
long long dfs(int r , int c){
    if(r<0 || r>=grid.size()|| c<0||c>=grid[0].size() || grid[r][c] == 0||visited[r][c])
    return 0;
    visited[r][c] = true;
    return grid[r][c]+dfs(r-1 ,c)+dfs(r+1 ,c)+dfs(r , c-1)+dfs(r , c+1);

}

    int countIslands(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        this->grid = grid;
        visited = vector<vector<bool>>(m , vector<bool>(n,false));
        int count =0;
        for(int r =0; r<m;r++){
            for(int c =0; c<n; c++){
                if (grid[r][c] != 0 && !visited[r][c]){
                long long currsum = dfs(r,c);
                if(currsum%k==0){
                    count++;
                }
            }
        }
    }
        return count;
        
    }
};