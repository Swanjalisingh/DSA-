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
int DFS(TreeNode* root , int& camera){
if(root == NULL){
    return 1;
}
int left = DFS(root->left , camera);
int right = DFS(root->right , camera);
    if(left ==  -1 || right == -1){
        camera++;
        return 0;
    }
    else if(left == 1 && right == 1){
        return -1;
    }
    else{
        return 1;
    }

}
    int minCameraCover(TreeNode* root) {
        int cameracount =0;
        if(DFS(root , cameracount) == -1){
            cameracount++;
        }
        return cameracount;
        
    }
};