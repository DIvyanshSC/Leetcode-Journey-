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
    static int count=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root==null) return 0;
        count=0;
        /*
        Make a array to store values with their frequencies, the array will be max of size 9 [ From Ques: Given a binary tree where node values are digits from 1 to 9].
        */
        int values[]=new int[10];
        pseudoPalindromicPaths(root, values);
        return count;
    }
    
    public void pseudoPalindromicPaths (TreeNode root, int []arr) {
        if(root==null) return;
        
        //Increase the freq of the current value in the array
        arr[root.val]++;
        
        pseudoPalindromicPaths(root.left,arr);
        pseudoPalindromicPaths(root.right,arr);
        
        //If you reached to a leaf node, check the path is palindrome or not
        if(root.left==null && root.right==null){
            /*
                * For checking if the path is palindrome or not
                    1. We have our root to node path for the current parth
                    2. we also have all the values which lies in the path with their freq stored in our array
                    3. we will travel our array and check if the count of odd freq value if that is <=1 then it is a palindomic path, increment count
                    4. else do nothing and backtrack
                    5. while bactracking decrement the count of freq by 1 for the current value in the path
            */
            int flag=0;//odd occ count;
            for(int i=1;i<=9;i++){
                if(arr[i]%2!=0) flag++;
            }
            
            if(flag<=1){
                count++;
            }
        }
        //Backtrack and decrease the freq of the current value in the array
        arr[root.val]--;
    }
}