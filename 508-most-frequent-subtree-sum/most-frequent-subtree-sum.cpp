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

public:
    vector<int> findFrequentTreeSum(TreeNode* root) {
        vector<int> result;

        if (root == NULL)
            return result;
        calculate(root);

        int maxFreq = 0;

        for (auto it : mp) {
            maxFreq = max(maxFreq, it.second);
        }

        for (auto it : mp) {
            if (it.second == maxFreq)
                result.push_back(it.first);
        }

        return result;
    }

    void calculate(TreeNode* root) {
        if (root == NULL)
            return;

        int sum = getSum(root);

        mp[sum]++;

        calculate(root->left);
        calculate(root->right);
    }

    int getSum(TreeNode* root) {
        if (root == NULL)
            return 0;

        return root->val + getSum(root->left) + getSum(root->right);
    }
};