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
    ArrayList<Integer> al =  new ArrayList<Integer>();
    public void tra(TreeNode r){
        if(r==null)
            return ;
        tra(r.left);
        al.add(r.val);
        tra(r.right);
        return ;
    }
    public boolean findTarget(TreeNode root, int k) {
        tra(root);
        int i=0,j=al.size()-1;
        while(i<j){
            if(al.get(i)+al.get(j)==k)
                return true;
            else if(al.get(i)+al.get(j)>k)
                j--;
            else
                i++;
        }
        return false;
    }
}