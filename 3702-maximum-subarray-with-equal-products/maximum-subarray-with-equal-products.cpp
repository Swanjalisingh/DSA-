class Solution {
public:
    int maxLength(vector<int>& nums) {
        int n = nums.size();
        int best =0;
        for(int i =0; i<n; i++){
            int prod = 1;
            int currgcd = 0;
            int currlcm =1;
            for(int j =i; j<n; j++){
                prod *= nums[j];
                currgcd = gcd(currgcd , nums[j]);
                currlcm = currlcm / gcd(currlcm , nums[j])*nums[j];
                if(prod > 25200){
                    break;
                }
                if(prod == currlcm *currgcd){
                    best = max(best , j-i+1);
                }
            }
        }
        return best;
        
    }
};