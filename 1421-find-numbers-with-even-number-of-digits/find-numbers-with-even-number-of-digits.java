 class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
         int evencount =0;
         for(int i =0; i<n; i++){
             int num = nums[i];
                  int count =0;
             while(num>0){
                  int digit = num%10;
                  count++;
                  num = num/10;
            }
                 if(count %2 ==0){
        evencount++;
        }
}
        return evencount;
  }
 }

// class Solution {
//     public int findNumbers(int[] nums) {

//         int n = nums.length;
//         int evencount = 0;

//         for (int i = 0; i < n; i++) {

//             int count = 0;
//             int num = nums[i];

//             while (num > 0) {
//                 int digit = num % 10;
//                 count++;
//                 num = num / 10;
//             }

//             if (count % 2 == 0) {
//                 evencount++;
//             }
//         }

//         return evencount;
//     }
// }