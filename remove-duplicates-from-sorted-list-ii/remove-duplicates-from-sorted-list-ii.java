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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res  = new ListNode(-1);
        ListNode curr = res;
        int duplicate = -1000;
        while(head!=null){
            
            while(head.next!= null && head.val == head.next.val  ) // if head value is equal to head's next value then go to next
            { 
                duplicate = head.val;
                head = head.next;
            }
            // if value of head is equal to duplicate then do not add this node on result linkedlist
            if(duplicate != head.val)
            {
               curr.next = head;
               curr = head;
            } 
             head = head.next;
        }
		// if next of current doesn't point to null 
         if(curr.next != null)
                curr.next = null; // make current to point to null
				
       return res.next;
    }
}