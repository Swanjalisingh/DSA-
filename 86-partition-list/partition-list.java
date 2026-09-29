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
    public ListNode partition(ListNode head, int x) {
        
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        
        ListNode b = before;
        ListNode a = after;
        
        while (head != null) {
            if (head.val < x) {
                b.next = head;
                b = b.next;
            } else {
                a.next = head;
                a = a.next;
            }
            
            head = head.next;
        }
        
        // End the after list
        a.next = null;
        
        // Connect before and after
        b.next = after.next;
        
        return before.next;
    }
}