class Solution {
    public int maxSubArray(int[] nums) {
        
        // int currsum = nums[0];
        // int maxsum = nums[0];
        // for(int i =1; i<nums.length;i++){
        //     if(currsum + nums[i] > nums[i]){
        //         currsum += nums[i];         }
        //         else {
        //             currsum = nums[i];
        //         }
        //         maxsum = Math.max(currsum , maxsum);
        // }
        // return maxsum;
        int sum =0;
        int maxi = Integer.MIN_VALUE;
        for(int i =0; i<nums.length; i++){
            sum = sum + nums[i];
            maxi =Math.max(maxi , sum);
            if(sum<0)
            sum =0;
        }
        return maxi;
    }
}