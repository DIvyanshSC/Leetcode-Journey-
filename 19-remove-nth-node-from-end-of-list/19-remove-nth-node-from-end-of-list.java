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
        if(head==null || head.next==null){
            return null;
        }
        
        Queue<ListNode> q=new LinkedList<>();
        
        ListNode p1=head,p2=head;
        
        while(n>0){
            p2=p2.next;
            n--;
        }
        
        if(p2==null){
            head=head.next;
            p1.next=null;
            return head;
        }
        
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        
        p1.next=p1.next.next;
        
        
        return head;
    }
}