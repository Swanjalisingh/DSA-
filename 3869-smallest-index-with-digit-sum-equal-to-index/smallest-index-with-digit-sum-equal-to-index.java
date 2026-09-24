class Solution {
    public int smallestIndex(int[] nums) {
        for(int i =0; i<nums.length; i++){
            int digit =0;
            int sum =0;
            while(nums[i] > 0){
                digit = nums[i]%10;
                sum += digit;
                nums[i] = nums[i]/10;

            }
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
}