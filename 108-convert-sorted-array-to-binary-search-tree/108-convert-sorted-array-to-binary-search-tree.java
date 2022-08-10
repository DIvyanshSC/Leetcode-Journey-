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
    private TreeNode createTreeUtil(int[] nums, int l, int r){
        if(l>r){
            return null;
        }
        
        int m = (l+r)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = createTreeUtil(nums, l, m-1);
        root.right = createTreeUtil(nums, m+1, r);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return createTreeUtil(nums, 0, n-1);
    }
}