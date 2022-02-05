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
    public ListNode mergeKLists(ListNode[] lists) {
        // Base Condition
        if(lists == null || lists.length == 0) return null;
        // Creating helper function helps in dividing and conquer approach
        return getMid(lists, 0, lists.length - 1); // created start & end index
    }
    private ListNode getMid(ListNode lists[], int start, int end){
        // Handle base case, when start & end index are same
        if(start == end) return lists[start];
        int mid = start + (end - start) / 2; // calculating mid & why we writing in this way to handle index overflow
        ListNode left = getMid(lists, start, mid); // in left mid become our new end
        ListNode right = getMid(lists, mid + 1, end); // in right this time start is mid + 1
        
        return merge(left, right);// merge the left & right together
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0); // created dummy node with any value of your choice, i choose 0 "Because we indian invented that"
        ListNode curr = result; // use this pointer to move over
        
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2; // bcz if l1 is null we know l2 must have value
                l2 = l2.next;
            }
            else if(l2 == null){
                curr.next = l1; // bcz if l2 is null we know l1 must have value
                l1 = l1.next;
            }else if(l1.val < l2.val){ // if we made up till this point we know they both have value & let's compare them
                curr.next  = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return result.next; // why we not return only result bcz, result has dummy value of 0
    }
}