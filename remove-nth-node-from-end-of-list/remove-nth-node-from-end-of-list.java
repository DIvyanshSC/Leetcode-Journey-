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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        
        ListNode temp = head;
        int size = 0;
        
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        
        temp = head;
        int count = 0;
        
        if(size - n <= 0) {
            head = head.next;
            return head;
        }
        
        while(size - n - 1 > count) {
            count++;
            temp = temp.next;
        }
        
        
        
        
        if(size >= 3) {
            temp.next = temp.next.next;
        }
        
        else if(size == 2){
            if(n == 1) {
                head.next = null;
            }
            
            else if(n == 2) {
                head = head.next;
            }
        }
        
        else {
            head = null;
        }
        
        return head;
    }
}