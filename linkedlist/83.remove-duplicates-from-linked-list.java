// Given a sorted linked list, delete all duplicates such that each element appear only once.

// Example 1:

// Input: 1->1->2
// Output: 1->2
// Example 2:

// Input: 1->1->2->3->3
// Output: 1->2->3


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
        if (head == null || (head != null && head.next == null)) return head;
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            if (first.val == second.val) {
                first.next = second.next;
                second = second.next;
                second = null;
                second = first.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }
}
