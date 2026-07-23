class Solution {
    public int uniqueXorTriplets(int[] nums) {

       int  n = nums.length;
        int ans =1;
        if(n ==1 || n ==2){
            return n;
        }
        while(ans <= n){
            ans *= 2;
        }
        return ans;
        
    }
}