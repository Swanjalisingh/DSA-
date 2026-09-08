class Solution {
    public int countCommas(int n) {
        // int count =0;
        // while(n>0){
        //     int digit = n%10;
        //     count++;
        //     n = n/10;

        
        // if(count>=4){
        //     return count-1;
        // }
        // }
        // return 0;
        int count =0;
        for(int i =1; i<=n; i++){
            if(i>= 1000){
                count++;
            }
        }
        return count;
    }
}