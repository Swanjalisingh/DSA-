class Solution {
    private int[][] dp;
    private int[] suffix;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // Suffix sum
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        dp = new int[n][n + 1];

        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (i >= n) {
            return 0;
        }

        // If current player can take all remaining piles
        if (i + 2 * m >= n) {
            return suffix[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int best = 0;

        for (int x = 1; x <= 2 * m; x++) {
            best = Math.max(best,
                    suffix[i] - dfs(i + x, Math.max(m, x)));
        }

        dp[i][m] = best;
        return best;
    }
}