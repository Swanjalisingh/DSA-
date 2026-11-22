
// class Solution {
//     public boolean checkString(String s) {
//         return !s.contains("ba");
//     }
// }
// class Solution {
//     public boolean checkString(String s) {
//         return s.indexOf("ba") == -1;
//     }
// }
// for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == 'a' && s.charAt(i - 1) == 'b') {
        //         return false;
        //     }
        // }

        import java.util.*;

class Solution {
    public boolean checkString(String s) {
        char[] arr = s.toCharArray();

        char[] sorted = arr.clone();
        Arrays.sort(sorted);

        return Arrays.equals(arr, sorted);
    }
}