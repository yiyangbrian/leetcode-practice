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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel;
        for(int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;

        for(int i = 0; i < right - left; i ++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return sentinel.next;
    }
}
