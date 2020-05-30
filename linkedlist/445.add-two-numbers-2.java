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
        Stack<ListNode> st1 = new Stack<ListNode>();
        Stack<ListNode> st2 = new Stack<ListNode>();
        insertIntoStack(l1, st1);
        insertIntoStack(l2, st2);
        ListNode head = null;
        
        return helper(head, st1, st2);
    }
    
    private ListNode helper(ListNode head, Stack<ListNode> st1, Stack<ListNode> st2) {
        int carry = 0;
        while (! st1.isEmpty() && ! st2.isEmpty()) {
            if (head == null) {
                head = new ListNode((st1.peek().val + st2.peek().val + carry) % 10);
                carry = (st1.peek().val + st2.peek().val + carry) / 10;
            } else {
                ListNode temp = new ListNode((st1.peek().val + st2.peek().val+ carry)%10);
                carry = (st1.peek().val + st2.peek().val + carry) / 10;
                temp.next = head;
                head = temp;
            }
            st1.pop();
            st2.pop();
        }
        
        while (! st1.isEmpty()) {
            if (head == null) {
                head = new ListNode((st1.peek().val + carry) % 10);
                carry = (st1.peek().val + carry) / 10;
            } else {
                ListNode temp = new ListNode((st1.peek().val + carry)%10);
                carry = (st1.peek().val + carry) / 10;
                temp.next = head;
                head = temp;
            }
            st1.pop();
        }
        
         while (! st2.isEmpty()) {
            if (head == null) {
                head = new ListNode((st2.peek().val + carry) % 10);
                carry = (st2.peek().val + carry) / 10;
            } else {
                ListNode temp = new ListNode((st2.peek().val + carry)%10);
                carry = (st2.peek().val + carry) / 10;
                temp.next = head;
                head = temp;
            }
            st2.pop();
        }
        
        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }
    
    private void insertIntoStack(ListNode head, Stack<ListNode> st) {
        while (head != null) {
            st.push(head);
            head = head.next;
        }
    }
}
