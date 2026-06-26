import java.util.HashMap;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        long validLeftPoint = 0;
        long result = 0;
        int cumSum = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                validLeftPoint += mp.getOrDefault(cumSum, 0);
                cumSum++;
            } else {
                cumSum--;
                validLeftPoint -= mp.getOrDefault(cumSum, 0);
            }

            mp.put(cumSum, mp.getOrDefault(cumSum, 0) + 1);
            result += validLeftPoint;
        }

        return result;
    }
}