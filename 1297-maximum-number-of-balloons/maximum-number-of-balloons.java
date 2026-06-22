class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int [26];
        for(int ch : text.toCharArray()){
            count[ch - 'a']++;
        }
        int  bacount = Math.min(count['b' - 'a'] , count['a' - 'a']);
        bacount = Math.min(bacount , count['n' - 'a']);
        int  lo = Math.min(count['l' - 'a']/2 , count['o' - 'a']/2);
        int ballons = Math.min(bacount , lo);
        return ballons;
        
    }
}