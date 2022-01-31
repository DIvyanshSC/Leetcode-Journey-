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
    public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }
    
    private int sumHelper(TreeNode root, int parentSum) {
        if(root == null) {
            return 0;
        }
        
        int nodeSum = parentSum * 10 + root.val;
        if(root.left == null && root.right == null) {
            return nodeSum;
        }
        
        else {
            return sumHelper(root.left, nodeSum) + sumHelper(root.right, nodeSum);
        }
    }
}