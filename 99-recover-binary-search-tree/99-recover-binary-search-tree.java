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
    private TreeNode a; // first
    private TreeNode b; // middle
    private TreeNode c; // last
    private TreeNode prev;
    
    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        if(prev != null && prev.val > root.val){
            // If this is a first violation, mark these 2 nodes as a & b
            if(a == null){
                a = prev;
                b = root;
            }
            // If this is a second violation, mark that nodes as c
            else{
                c = root;
            }
        }
        // mark current node as previous
        prev = root;
        inorder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        a = null;
        b = null;
        c = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(a != null && c != null){
            int temp = a.val;
            a.val = c.val;
            c.val = temp;
        }
        else if(a != null && b != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }
}