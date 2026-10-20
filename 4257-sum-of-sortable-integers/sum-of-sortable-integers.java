
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k == 0 && check(nums, k)) {
                ans += k;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int k) {
        int n = nums.length;
        int prevMax = Integer.MIN_VALUE;

        for (int start = 0; start < n; start += k) {
            int min = nums[start];
            int max = nums[start];
            int descents = 0;

            for (int i = start; i < start + k; i++) {
                int next = (i + 1 == start + k)
                         ? start : i + 1;

                if (nums[i] > nums[next]) {
                    descents++;
                }

                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
            }

            // This block must be sortable by rotation.
            if (descents > 1) {
                return false;
            }

            // Blocks must join in non-decreasing order.
            if (prevMax > min) {
                return false;
            }

            prevMax = max;
        }

        return true;
    }
}
