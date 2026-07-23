/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode * curr = head;
        unordered_set<ListNode*> mp;
                while(curr !=NULL){
                    if(mp.find(curr) != mp.end()){
                        return curr;
                    }
                    else{
                        mp.insert(curr);
                        curr = curr->next;
                    }
                }
                return NULL;
        
    }
};