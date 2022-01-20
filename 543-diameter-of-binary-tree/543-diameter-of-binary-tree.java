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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1]; // look at intellij for explanation
        heightDiameter(root, diameter);
        return diameter[0];
    }
    
    private int heightDiameter(TreeNode currNode, int[] diameter) {
        if(currNode == null) {
            return 0;
        }

        int lHeight = heightDiameter(currNode.left, diameter);
        int rHeight = heightDiameter(currNode.right, diameter);

        diameter[0] = Math.max(diameter[0], lHeight + rHeight);

        return 1 + Math.max(lHeight, rHeight);
    }
}