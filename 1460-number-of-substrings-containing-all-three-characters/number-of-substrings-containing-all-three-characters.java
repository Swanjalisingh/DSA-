class Solution {
    public int numberOfSubstrings(String s) {
        int right =0;
        int left = 0;
        int ans =0;
        int[] count = new int[3];
        int n = s.length();
        while(right<n){
            count[s.charAt(right) - 'a']++;
            while(isValid(count)){
                ans += (n-right);
                count[s.charAt(left) - 'a']--;

                left++;
            }
            right++;
        }
       
      return ans;
    
}
private boolean isValid(int[] count) {
        return count[0] > 0 && count[1] > 0 && count[2] > 0;
    }
}