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
    boolean res;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        res = true;
        solve(head, head);
        return res;
    }
    
    ListNode solve(ListNode curr, ListNode head){
        if(curr.next == null){
            if(curr.val != head.val){
                res = false;
            }
            return head.next;
        }
        ListNode palNode = solve(curr.next, head);
        if(curr.val != palNode.val){
            res = false;
        }
        
        return palNode.next ;
    }
}