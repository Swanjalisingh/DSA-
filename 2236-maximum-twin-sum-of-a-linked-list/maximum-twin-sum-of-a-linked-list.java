/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {

        ArrayList<Integer> arr = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            arr.add(curr.val);
            curr = curr.next;
        }

        int result = 0;
        int i = 0;
        int j = arr.size() - 1;

        while (i < j) {
            result = Math.max(result, arr.get(i) + arr.get(j));
            i++;
            j--;
        }

        return result;
    }
}