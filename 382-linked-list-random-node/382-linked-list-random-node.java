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

    ListNode head = null;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int scope = 1;
        int chosenVal = 0;
        ListNode curr = this.head;
        while (curr != null) {
            if(Math.random() < 1.0 /scope) {
                chosenVal = curr.val;
            }
            
            scope += 1;
            curr = curr.next;
        }
        
        return chosenVal;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */