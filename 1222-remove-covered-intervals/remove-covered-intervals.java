import java.util.*;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a ,b)->{
            if(a[0] == b[0])
             return b[1]-a[1];
             return a[0]-b[0];
        });
        int remove =0;
        int prev =0;
        for(int i=1; i<n; i++){
            int startinvl = intervals[i][0];
            int endinvl = intervals[i][1];
            int pstart = intervals[prev][0];
            int pend = intervals[prev][1];
            if (startinvl >= pstart && endinvl <= pend)
            remove++;
            else prev =i;
        }
        return n - remove;
       
    }
}