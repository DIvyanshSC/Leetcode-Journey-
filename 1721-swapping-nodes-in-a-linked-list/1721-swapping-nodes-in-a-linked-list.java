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
    public ListNode swapNodes(ListNode head, int k) {
        // Two Pointers time: O(n) space: O(1)
        
        /*
            Find the k-th node from the front which is left.
            Make left node as the current node, right node from the front, when the current node reach end, right               node is just the k-th last element.
            Swap their values.
        */
        ListNode left = head;
        ListNode right = head;
        int cnt = 0;
		// find the k-th node
        while (left != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            left = left.next;
        }

		// find the k-th last element
        ListNode pNode = left;
        while (pNode.next != null) {
            pNode = pNode.next;
            right = right.next;
        }

		// swap their values.
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }
}