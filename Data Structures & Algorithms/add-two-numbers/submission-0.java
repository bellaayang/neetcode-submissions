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
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1;
            int val2;
            if (l1 != null) {
                val1 = l1.val;
            } else {
                val1 = 0;
            }

            if (l2 != null) {
                val2 = l2.val;
            } else {
                val2 = 0;
            }

            int val = val1 + val2 + carry;
            carry = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;

        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
        
        
    }
}
