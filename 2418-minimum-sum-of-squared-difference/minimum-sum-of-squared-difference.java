class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int maxDiff = 0;
        long total = 0;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            total += diff[i];
        }

        int k = k1 + k2;

        if (total <= k) {
            return 0;
        }

        int low = 0, high = maxDiff;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long needed = 0;

            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int target = low;
        long remaining = k;

        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                int reduce = diff[i] - target;
                diff[i] -= reduce;
                remaining -= reduce;
            }
        }

        // Use remaining operations to reduce values from target to target - 1.
        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == target && target > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;

        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}