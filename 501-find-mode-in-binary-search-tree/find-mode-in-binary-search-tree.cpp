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
    map<int, int> mp;
    vector<int> ans;
    int maxFreq = 0;

public:
    vector<int> findMode(TreeNode* root) {
        inorder(root);
        return ans;
    }

    void inorder(TreeNode* root) {
        if (root == NULL)
            return;

        inorder(root->left);

        mp[root->val]++;

        if (mp[root->val] > maxFreq) {
            maxFreq = mp[root->val];
            ans.clear();
            ans.push_back(root->val);
        }
        else if (mp[root->val] == maxFreq) {
            ans.push_back(root->val);
        }

        inorder(root->right);
    }
};