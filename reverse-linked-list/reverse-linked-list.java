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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        return rev(head);
    }
    
    private ListNode rev(ListNode head) {
        if(head.next == null || head == null) {
            return head;
        }
        
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        
        return temp;
    }
}