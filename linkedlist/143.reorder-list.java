// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You may not modify the values in the list's nodes, only nodes itself may be changed.

// Example 1:

// Given 1->2->3->4, reorder it to 1->4->2->3.
// Example 2:

// Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

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
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = getMiddleNode(head);
        ListNode reverseHead = reverseHalfList(middle.next);
        middle.next = null;
            
        ListNode current = head;
        ListNode temp = null;
        while (current != null && reverseHead != null) {
            temp = current;
            temp = current.next;
            current.next = reverseHead;
            current = reverseHead;
            reverseHead = reverseHead.next;
            current.next = temp;
            current = temp;
        }
    }
    
    private ListNode reverseHalfList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode temp = head;
        
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
    
    private ListNode getMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
