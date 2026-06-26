class Solution {
public:
    long long countMajoritySubarrays(vector<int>& nums, int target) {
        long long validLeftPoint = 0;
        long long result = 0;
        int cumSum = 0;

        unordered_map<int, int> mp;
        mp[0] = 1;

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                validLeftPoint += mp[cumSum];
                cumSum++;
            } else {
                cumSum--;
                validLeftPoint -= mp[cumSum];
            }

            mp[cumSum]++;
            result += validLeftPoint;
        }

        return result;
    }
};