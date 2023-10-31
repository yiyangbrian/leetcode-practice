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
    private ListNode sort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode iterator = head;
        int length = 0;
        while(iterator != null) {
            iterator = iterator.next;
            length ++;
        }

        int mid = length / 2;

        // move p to the predecessor of rightHead
        ListNode p = head;
        while(mid - 1 > 0) {
            p = p.next;
            mid --;
        }

        ListNode rightHead = p.next;
        // break the linkedlist from the middle

        p.next = null;

        ListNode sortedLeft = sort(head);
        ListNode sortedRight = sort(rightHead);

        return merge(sortedLeft, sortedRight);
    }

    private ListNode merge(ListNode sortedLeft, ListNode sortedRight) {
        if(sortedLeft == null) {
            return sortedRight;
        }
        else if(sortedRight == null) {
            return sortedLeft;
        }
        else if(sortedLeft.val < sortedRight.val) {
            sortedLeft.next = merge(sortedLeft.next, sortedRight);
            return sortedLeft;
        }
        else {
            sortedRight.next = merge(sortedLeft, sortedRight.next);
            return sortedRight;
        }
    }

    public ListNode sortList(ListNode head) {
        return sort(head);
    }
}
