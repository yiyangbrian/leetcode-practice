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
        if(head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode p = head;
        ListNode prev = sentinel;

        while(p.next != null) {
            if(p.next.val == p.val) {
                p = p.next;
            } else {
                if(prev.next != p) {
                    p = p.next;
                    prev.next = p;
                } else {
                    p = p.next;
                    prev = prev.next;
                }
            }
        }

        if(p.next == null && prev.next != p) {
            prev.next = null;
        }

        return sentinel.next;
    }
}
