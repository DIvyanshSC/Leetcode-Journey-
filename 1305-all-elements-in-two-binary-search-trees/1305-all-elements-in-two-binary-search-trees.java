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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        
        inorder(root1, t1);
        inorder(root2, t2);

        
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < t1.size() && j < t2.size()) {
            if(t1.get(i) <= t2.get(j)) {
                res.add(t1.get(i));
                i++;
            }
            
            else {
                res.add(t2.get(j));
                j++;
            }
        }
        
        if(i >= t1.size()) {
            while(j < t2.size()) {
                res.add(t2.get(j));
                j++;
            }
        } 
        
        else if(j >= t2.size()) {
            while(i < t1.size()) {
                res.add(t1.get(i));
                i++;
            }  
        }
        
        return res;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }
}