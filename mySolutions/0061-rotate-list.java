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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode count = head;
        int len = 0;
        while(count != null) {
            count = count.next;
            len ++;
        }

        k %= len;

        ListNode pre = head;

        int step = len - k - 1;
        for(int i = 0; i < step; i ++) {
            pre = pre.next;
        }

        // set a sentinel
        ListNode sentinel = new ListNode(0, head);

        // cut the sublist
        ListNode sublist = pre.next;
        pre.next = null;

        // insert the rotated sublist after sentinel
        sentinel.next = sublist;

        ListNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }
        p.next = head;

        return sentinel.next;
    }
}
