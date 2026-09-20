// class Solution {
//     public int search(int[] nums,int target) {
//         int low =0;
//         int high= nums.length-1;
//         while(low<=high){
//             int mid = (low+high)/2;
//             if(nums[mid]==target){
//                 return mid;
//             }
//             if(nums[mid]<target){
//                 low=mid+1;

//             }
//             else{
//                 high=mid-1;
//             }
//         }
//         return -1;
        

//     }
// }



class Solution {
    static int solve(int[] arr , int target , int s , int e){
        if(s>e){
            return -1;
        }
       int mid = (s+e)/2;
       if(arr[mid] == target){
        return mid;
       }
       if(arr[mid] > target){
        e = mid -1;
       }
       else if(arr[mid] < target){
        s = mid +1;
       }
       return solve(arr , target , s, e);
    }
    public int search(int[] nums,int target) {
        int s =0;
         int e = nums.length-1;
        int ans = solve(nums , target , s, e);
        return ans;
    }
}