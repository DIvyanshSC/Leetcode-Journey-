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
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) {
            return 0;
        }
        preorder(root, 0);
        return sum;
    }
    
    public int sum = 0;
    
    public void preorder(TreeNode r, int curr) {
        if(r != null) {
            curr = (curr << 1) | r.val;
            
            if(r.left == null && r.right == null) {
                sum += curr;
            }
            
            preorder(r.left, curr);
            preorder(r.right, curr);
        }
    }
}