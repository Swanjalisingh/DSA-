class Solution {
    public int climbStairs(int n) {
      if(n<=2){
        return n;

      }
    
        int firststep =1;
        int secondstep =2;
        for(int i =3; i<=n; i++){
            int temp = firststep+secondstep;
            firststep = secondstep;
            secondstep = temp;
         
        }
      
      return secondstep;
      }
    }

















    // if(n==1){
    //     return 1;
    //    }
    //    if(n==2){
    //     return 2;
    //    }
      
    //     int ans =climbStairs(n-1)+climbStairs(n-2);
    //     return ans;
           
