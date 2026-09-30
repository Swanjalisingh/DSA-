/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
     while(a != null && b != null){
        a = a.next;
        b = b.next;
     }
       if(a == null){
        int bextralen = 0;
        while(b != null){
            bextralen++;
            b = b.next;
        }
        while(bextralen-- > 0){
            headB = headB.next;
        }
       }
       else{
        int aextralen =0;
        while(a != null){
            aextralen++;
            a = a.next;
        }
        while(aextralen-- > 0){
            headA = headA.next;
        }
       }
       //ab mere pass headA ans headB is tarike se lage hue h k unse start karte huye end tak jaye to equal length mile
       while(headA != null && headB != null){
        if(headA == headB){
        return headA;
        }
        else{
            headA = headA.next;
            headB = headB.next;
        }
       }
       return null;
        
    }
}