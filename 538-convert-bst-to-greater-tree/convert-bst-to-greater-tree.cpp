/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* convertBST(TreeNode* root) {
        if(root == NULL){
            return root;
        }
        TreeNode*curr = root;
        int sum =0;
        while(curr != NULL){
        if(curr-> right == NULL){
            sum += curr->val;
            curr->val = sum;
            curr = curr->left;
        }
        else{
            TreeNode*succ = curr->right;
            while(succ->left != NULL && succ->left != curr){
                succ = succ->left;
            }
            if(succ->left == NULL){
                succ->left = curr;
                curr = curr->right;
            }
            else{
                sum += curr->val;
                curr->val = sum;
                succ->left = NULL;
                curr = curr->left;
            }
        }
        }
    return root;
        
    }
};