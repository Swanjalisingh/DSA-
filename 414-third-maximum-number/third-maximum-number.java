class Solution {
    public int thirdMax(int[] nums) {
        // Arrays.sort(nums);
        // int count =1;
        // int n = nums.length;
        // for(int i = n-1; i<0; i--){
        //     if(nums[i] != nums[i-1]){
        //         count++;
        //     }
        //     if(count ==3){
        //         return nums[i-1];
        //     }
        
        // }
        // return nums[n-1];
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        if(set.size()<3){
            return Collections.max(set);
        }
        set.remove(Collections.max(set));
         set.remove(Collections.max(set));
         return Collections.max(set);
    }
}