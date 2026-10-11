class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sqsum =0;
        for(int i =1; i<=n; i++){
            if(n%i == 0){
             int product = nums[i-1]*nums[i-1];
             sqsum += product;

            }
        }
        return sqsum;
        
    }
}