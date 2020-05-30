// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode prev = null;
        int carry = 0;
        
        while (temp1 != null && temp2 != null) {
            prev = temp1;
            int n =  temp1.val + temp2.val + carry;         
            temp1.val = n % 10;
            carry = n / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        while (temp1 != null) {
            prev = temp1;
            int n = temp1.val + carry;
            temp1.val = n % 10;
            carry = n / 10;
            temp1 = temp1.next;
        }
        
        if (temp2 != null) {
            prev.next = temp2;
            while (temp2 != null) {
                System.out.println(carry+ " " +temp2.val);
                int n = temp2.val + carry;
                temp2.val = (n) % 10;
                carry = (n) / 10;
                prev = temp2;
                temp2 = temp2.next;
            }
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return l1;
    }
}
