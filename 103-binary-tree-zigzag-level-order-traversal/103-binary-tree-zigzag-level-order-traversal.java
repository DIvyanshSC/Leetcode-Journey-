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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        
        Queue<TreeNode> q = new ArrayDeque();
        q.offer(root);
        List<List<Integer>> outer = new ArrayList<>();
        int flag = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
        
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                if(temp.left != null) {
                    q.offer(temp.left);
                }
                
                if(temp.right != null) {
                    q.offer(temp.right);
                }
                
                inner.add(temp.val);
            }
            
            if(flag == 0) {
                outer.add(inner);
                flag = 1;
            }
            
            else if(flag == 1) {
                Collections.reverse(inner);
                outer.add(inner);
                flag = 0;
            }
        }
        
        return outer;
    }
}