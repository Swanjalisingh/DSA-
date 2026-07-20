class Solution {

    void reverse(int[][] grid, int i, int j) {
        int cols = grid[0].length;

        while (i < j) {
            int temp = grid[i / cols][i % cols];
            grid[i / cols][i % cols] = grid[j / cols][j % cols];
            grid[j / cols][j % cols] = temp;
            i++;
            j--;
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        k %= total;

        if (k != 0) {
            reverse(grid, 0, total - 1);
            reverse(grid, 0, k - 1);
            reverse(grid, k, total - 1);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                list.add(grid[i][j]);
            }
            ans.add(list);
        }

        return ans;
    }
}