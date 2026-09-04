class Solution {
    public int removeDuplicates(int[] nums) {
        // Set<Integer> set = new LinkedHashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }
        // int i =0;
        // for(int num :set){
        //     nums[i]=num;
        //     i++;
        // }
        // return i;
        int n = nums.length;
        int i =0;
         int j =1;
         while(j<n){
            if(nums[i] == nums[j]){
                j++;
            }
            else{
                i++;
                nums[i] = nums[j];
                j++;
            }
         }
         return i+1;
    }
}