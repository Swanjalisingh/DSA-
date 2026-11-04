import java.util.*;

class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        long[] cost = getCosts(nums, x);

        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;

            for (int j = 1; j <= k; j++) {
                // Skip current element
                dp[i][j] = dp[i - 1][j];

                // Select window ending at i - 1
                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }

    private long[] getCosts(int[] nums, int x) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        long leftSum = 0, rightSum = 0;
        int leftSize = 0, rightSize = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (left.isEmpty() || val <= left.lastKey()) {
                left.merge(val, 1, Integer::sum);
                leftSum += val;
                leftSize++;
            } else {
                right.merge(val, 1, Integer::sum);
                rightSum += val;
                rightSize++;
            }

            // Balance the two halves
            while (leftSize > rightSize + 1) {
                int m = left.lastKey();
                remove(left, m);
                leftSum -= m;
                leftSize--;

                right.merge(m, 1, Integer::sum);
                rightSum += m;
                rightSize++;
            }

            while (leftSize < rightSize) {
                int m = right.firstKey();
                remove(right, m);
                rightSum -= m;
                rightSize--;

                left.merge(m, 1, Integer::sum);
                leftSum += m;
                leftSize++;
            }

            if (i >= x) {
                int out = nums[i - x];

                if (left.containsKey(out)) {
                    remove(left, out);
                    leftSum -= out;
                    leftSize--;
                } else {
                    remove(right, out);
                    rightSum -= out;
                    rightSize--;
                }
            }

            // Rebalance after removing outgoing element
            while (leftSize > rightSize + 1) {
                int m = left.lastKey();
                remove(left, m);
                leftSum -= m;
                leftSize--;

                right.merge(m, 1, Integer::sum);
                rightSum += m;
                rightSize++;
            }

            while (leftSize < rightSize) {
                int m = right.firstKey();
                remove(right, m);
                rightSum -= m;
                rightSize--;

                left.merge(m, 1, Integer::sum);
                leftSum += m;
                leftSize++;
            }

            if (i >= x - 1) {
                int median = left.lastKey();

                cost[i - x + 1] =
                    (long) median * leftSize - leftSum
                    + rightSum - (long) median * rightSize;
            }
        }

        return cost;
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }
}