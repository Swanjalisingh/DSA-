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
private:
       TreeNode * x_parent = NULL;
        TreeNode* y_parent = NULL;
        int X_depth =-1;
        int Y_depth =-1;


public:
   void DFS(TreeNode* root ,int x, int y, TreeNode*parent , int depth){
    if(root == nullptr){
    return ;
}
       if(root->val == x){
        x_parent = parent;
        X_depth = depth;
       }
       if(root->val == y){
         y_parent = parent;
        Y_depth = depth;
       }
       DFS(root->left , x,y,root , depth+1);
       DFS(root->right ,x,y, root, depth+1);

   }






    bool isCousins(TreeNode* root, int x, int y) {
        DFS(root , x,y,NULL,0);
        return X_depth == Y_depth && x_parent != y_parent;
       
        
    }
};