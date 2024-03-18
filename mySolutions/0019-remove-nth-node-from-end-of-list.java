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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;

        while(p != null) {
            p = p.next;
            len ++;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        // one pass
        ListNode prev = sentinel;

        int step = len - n;

        while(step > 0) {
            prev = prev.next;
            step --;
        }

        prev.next = prev.next.next;

        return sentinel.next;
    }
}