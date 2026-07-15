class Solution {
    private int GCD(int a , int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int oddsum =0; 
        int evensum =0;
        int evennumber =2;
        int oddnumber =1;
        for(int i =0; i<n; i++){
            oddsum += oddnumber;
            evensum += evennumber;
            oddnumber += 2;
            evennumber +=2;
        }
        return GCD(oddsum , evensum);
        
    }
}