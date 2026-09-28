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
    public ListNode mergeNodes(ListNode head) {
        int sum =0;
        ListNode write = head;
        ListNode read = head.next;
        while(read != null){
            while(read.val != 0){
                sum = sum +read.val;
                read = read.next;
            }
            write.val = sum;
            sum =0;
            write.next = read.next;
            read = read.next;
            write = write.next;
        }
        return head;
        
        
        
    }
}