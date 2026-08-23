class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder binarystr = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            String bin = String.format("%8s" , Integer.toBinaryString(c)).replace(' ' , '0');
            binarystr.append(bin);
        }
        String result = binarystr.toString();
        int left =0;
        int right = result.length()-1;
        while(left<right){
            if(result.charAt(left) != result.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}