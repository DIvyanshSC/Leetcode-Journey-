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
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return result;
    }
    
    int result = 0;
    private void helper(TreeNode curr, int max, int min) {
        if(curr == null) {
            return;
        }
        
        int possible_ans = Math.max(Math.abs(max - curr.val), Math.abs(min - curr.val));
        result = Math.max(result, possible_ans);
        
        max = Math.max(max, curr.val);
        min = Math.min(min, curr.val);
        
        helper(curr.left, max, min);
        helper(curr.right, max, min);
        
    }
}