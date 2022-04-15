/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Find the number of nodes in our linked list
        int totalNodes = 0;
        ListNode temp = head;
        while(temp != null){
            totalNodes++;
            temp = temp.next;
        }
        
        // Call to the Recursive function to reverse k nodes at a time
        ListNode node = reverse(head, totalNodes, k);
        
        return node;
    }
    
    public ListNode reverse(ListNode head, int remainingNodes, int k){
        
        //Termination condition
        if(remainingNodes < k){
            return head;
        }
        
        // First, reversing k nodes
        int i = 0;
        ListNode prev = null;
        ListNode cur = head;
        ListNode n = head.next;
        
        while(i++ < k){
            cur.next = prev;
            prev = cur;
            cur = n;
            n = n == null ? null : n.next;
        }
        
        // Secondly, Recursive call to the remaining part of linked list
        ListNode temp = null;
        if(cur != null){
            temp = reverse(cur, remainingNodes - k, k);
        }
        
        //  Third step, attaching the original tail of current linked list to the head of that linked list which is returned by the recursive call.
        head.next = temp;
        
        // Finally returning the head of our reversed linked list
        return prev;
    }
}