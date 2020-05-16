// Remove all elements from a linked list of integers that have value val.

// Example:

// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        
        while (head != null && head.val == val) {
            ListNode temp = head;
            head = head.next;
            temp = null;
        }
        
        if (head != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            while (second != null) {
                if (second.val == val) {
                    first.next = second.next;
                    second = null;
                    second = first.next;
                } else {
                    first = first.next;
                    second = second.next;
                }
            }
        }
        return head;
    }
}
