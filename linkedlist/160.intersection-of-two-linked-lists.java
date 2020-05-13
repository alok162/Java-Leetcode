// Write a program to find the node at which the intersection of two singly linked lists begins.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getCount(headA);
        int n = getCount(headB);
        if (m > n) {
            ListNode temp = headA;
            for (int i=0; i<m-n; i++) {
                temp = temp.next;
            }
            return getIntersection(temp, headB);
        } else {
            ListNode temp = headB;
            for (int i=0; i<n-m; i++) {
                temp = temp.next;
            }
            return getIntersection(headA, temp);
        }
    }
    
    private ListNode getIntersection(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
    
    private int getCount(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
