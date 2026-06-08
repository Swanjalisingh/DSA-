// brute force; 
// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         List<Integer> less = new ArrayList<>();
//         List<Integer> equal = new ArrayList<>();
//         List<Integer>  greater = new ArrayList<>();

//         for(int num : nums){
//             if(num <pivot)
//             less.add(num);
//            else if(num==pivot)
//             equal.add(num);
//             else 
//             greater.add(num);
//         }
        
//         int[] ans = new int[nums.length];
//         int k = 0;

//         for (int x : less) ans[k++] = x;
//         for (int x : equal) ans[k++] = x;
//         for (int x : greater) ans[k++] = x;

//         return ans;
//     }
// }


class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int countless =0;
        int countequal =0;
        for(int num : nums){
            if(num < pivot)
            countless++;
            else if(num == pivot)
            countequal++;
        }
         int i =0;
         int j = countless;
         int k = countless + countequal;
         int[] result = new int[n];
         
          for(int num : nums){
            if(num < pivot){
                  result[i] = num;
                  i++;

            }
            else if ( num == pivot){
                result[j] = num;
                j++;
            }else{
                result[k] = num;
                k++;

            }
          }
           
           return result;
    }
}