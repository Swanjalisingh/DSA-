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
   public ListNode getmid(ListNode head){
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null){
        fast = fast.next;
        if(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
    }
    return slow;
   }
   public ListNode revrseLL(ListNode head){
    ListNode prev  = null;
    ListNode curr = head;
    while(curr != null){
        ListNode forward = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forward;

    }
    return prev;
   }


    public boolean isPalindrome(ListNode head) {

        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        //mid point LL -> break;
        //list1 , list2 separate;
        //list 2 ->reverse;
        //list1 , list 2 comapre;
        //return true or false;
        ListNode list2 = getmid(head);
        ListNode temp = head;
        while(temp.next != list2){
            temp = temp.next;
        }
        temp.next = null;
        ListNode head2 = revrseLL(list2);
        ListNode temp1 = head;
        ListNode temp2 = head2;
        while(temp1 != null && temp2 != null){
            if(temp1.val != temp2.val){
                return false;
            }
            else{
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }

     return true;
        
    }
}