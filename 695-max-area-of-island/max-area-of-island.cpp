class Solution {
    vector<vector<int>> grid;
    vector<vector<bool>> visited;
    public:
    int dfs(int r , int c){
       if(r < 0 || r >= grid.size() ||
   c < 0 || c >= grid[0].size() ||
   grid[r][c] == 0 ||
   visited[r][c])
        return 0;
        visited[r][c] = true;
        return 1+ dfs(r-1 , c)+dfs(r+1 , c)+dfs(r , c-1)+dfs(r , c+1);
    }


    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        this->grid = grid;
        visited = vector<vector<bool>>(m,vector<bool>(n,false));
        int maxarea =0;
        
        for(int r =0; r<m; r++){
            for(int c =0; c<n; c++){
                int currarea = dfs(r,c);
                maxarea = max(maxarea , currarea);
            }
        }
        return maxarea;

        
    }
    

};