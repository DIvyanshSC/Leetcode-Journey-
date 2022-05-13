/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int nodesAtCurrentLevel = q.size();
            // polling the first node outside the loop to avoid extra checks in the loop
			Node prev = q.poll();
            if (prev.left != null)
                q.offer(prev.left);
            if (prev.right != null)
                q.offer(prev.right);
            Node current = null;
            for (int i = 1; i < nodesAtCurrentLevel; i++) {
                current = q.poll();
                if (current.left != null)
                    q.offer(current.left);
                if (current.right != null)
                    q.offer(current.right);
                prev.next = current;
                prev = current;
            }
            if (current == null) // indicates there was only 1 node at this level, setting prev's next to null
                prev.next = null;
            else // otherwise setting the next of the last node in this level to null
                current.next = null;
        }
        return root;
    }
}