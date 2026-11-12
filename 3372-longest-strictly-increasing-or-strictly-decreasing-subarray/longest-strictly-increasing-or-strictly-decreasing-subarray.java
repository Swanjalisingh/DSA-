class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int incount =1;
        int decount =1;
        int ans =1;

        for(int i =1;i<n; i++){
            if(nums[i]<nums[i-1]){
                incount++;
                decount =1;
            }
           else if(nums[i]>nums[i-1]){
                decount++;
                incount =1;
            }
            else{
                incount =1;
                decount =1;

            }
            ans = Math.max(ans , Math.max(incount , decount));
        }
       
        
        return ans;
        
        
    }
}