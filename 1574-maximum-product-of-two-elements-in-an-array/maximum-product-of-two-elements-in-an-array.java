class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int product =( nums[n-1]-1)*(nums[n-2] -1);
        return product;
       
    }

}


// int max =-1;
        // int smax = -1;
        // for(int i =0 ; i<nums.length;i++){
        //     if(max<nums[i]){
        //         smax = max;
        //         max = nums[i];
        //     }
        //     else if(smax<nums[i]){
        //         smax=nums[i];
        //     }
        // }
        // int ans = (max-1)*(smax-1);
        //   return ans;