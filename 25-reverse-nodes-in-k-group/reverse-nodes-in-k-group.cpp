/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
// class Solution {
// public:
//     ListNode* reverseKGroup(ListNode* head, int k) {
//         //step first check the length of the linkedlist
//         if(head == NULL || head->next == NULL){
//             return head;
//         }
//         ListNode* temp = head;
//         int count =0;
//         while(count<k){
//             if(temp == NULL){
//                 return head;
//             }
//             temp = temp->next;
//             count++;
//         }
//         // gohead for the rest of the linkedlist
              
//             ListNode* prev = reverseKGroup(temp , k);
//         for(int i =1; i<=k; i++){
//             ListNode* Nxt = temp->next;
//             temp->next = prev;
//             prev = temp;
//             temp= Nxt;
//             count++;
//         }
//         head->next = prev;
//         return prev;
        

        
        
//     }
// };




class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {

        // Step 1: Check if at least k nodes exist
        ListNode* temp = head;

        int count = 0;

        while (count < k) {
            if (temp == NULL) {
                return head;
            }

            temp = temp->next;
            count++;
        }

        // Step 2: Recursively reverse remaining groups
        ListNode* prev = reverseKGroup(temp, k);

        // Step 3: Reverse current k nodes
        ListNode* curr = head;

        for (int i = 0; i < k; i++) {

            ListNode* Nxt = curr->next;

            curr->next = prev;

            prev = curr;

            curr = Nxt;
        }

        // Step 4: Return new head
        return prev;
    }
};
