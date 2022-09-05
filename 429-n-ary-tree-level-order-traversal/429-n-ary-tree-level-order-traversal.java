/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Integer> tp = new ArrayList<>();
        tp.add(root.val);
        ans.add(tp);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < size ; j++){
                Node t = q.poll();
                for(int i = 0 ; i < t.children.size() ; i++){
                    temp.add(t.children.get(i).val);
                    q.add(t.children.get(i));
                }
            }
            if(temp.size() != 0)
                ans.add(temp);
        }
        
        return ans;
    }
}