/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }
    
    private boolean isSame(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        
        if(p == null || q == null) {
            return false;
        }
        
        boolean left = isSame(p.left, q.right);
        boolean right = isSame(p.right, q.left);
        
        return p.val == q.val && left && right;
    }
}