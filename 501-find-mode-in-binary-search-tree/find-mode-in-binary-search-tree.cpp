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

public:
    vector<int> findMode(TreeNode* root) {
        inorder(root);

        int maxFreq = 0;

        // Find maximum frequency
        for (auto it : mp) {
            maxFreq = max(maxFreq, it.second);
        }

        // Store all modes
        for (auto it : mp) {
            if (it.second == maxFreq) {
                ans.push_back(it.first);
            }
        }

        return ans;
    }

    void inorder(TreeNode* root) {
        if (root == NULL)
            return;

        inorder(root->left);

        mp[root->val]++;

        inorder(root->right);
    }
};