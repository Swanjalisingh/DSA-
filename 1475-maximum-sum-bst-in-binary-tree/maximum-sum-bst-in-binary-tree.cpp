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
 class info {
    public:
    int sum;
    int maxval;
    int minval;
    info(int sum , int maxval , int minval){
        this->sum = sum;
        this->maxval = maxval;
        this->minval = minval;
    }
 };
class Solution {
    int maxsum =0;
public:
    int maxSumBST(TreeNode* root) {
        solve(root);
        return maxsum;
        
        
    }
    info solve(TreeNode* root){
        if(root == nullptr)
        return info(0 , INT_MIN , INT_MAX);
        if(root->left == nullptr && root->right == nullptr)
        return info(root->val, root->val , root->val);

        info left = solve(root->left);
        info right = solve(root->right);
        if(root->val > left.maxval && root->val < right.minval){
            int s = root->val +left.sum + right.sum;
            maxsum = max(maxsum , s);
            int mx = max(root->val , right.maxval);
            int mn = min(root->val , left.minval);
            return info(s, mx, mn);

        }
        else{
            int s = max(left.sum , right.sum);
            maxsum = max(maxsum , s);
            int mx = INT_MAX;
            int mn = INT_MIN;
            return info(s , mx , mn);
        }
    }
};