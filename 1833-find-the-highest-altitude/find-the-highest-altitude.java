class Solution {
    public int largestAltitude(int[] gain) {
        int alti =0;
        int maxalti =0;
    for( int g : gain){
        alti += g;
        maxalti = Math.max(alti , maxalti);
    }
        return maxalti;
    }
}