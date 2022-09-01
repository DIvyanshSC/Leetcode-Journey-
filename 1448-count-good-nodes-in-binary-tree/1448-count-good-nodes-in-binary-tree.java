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
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count; // returning the count value
    }

    private void helper(TreeNode root, int max) {
        if (root != null) {
            if (root.val >= max) { // if root.val > the max value of path from root of the tree to current node 
                count++; //increment count
            }
            helper(root.left, Math.max(root.val, max));  // updating max value of current path and traversing left to the current node
            helper(root.right, Math.max(root.val, max));  // updating max value of current path and traversing right to the current node
        }
    }
}