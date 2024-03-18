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
    public ListNode partition(ListNode head, int x) {

        // add sentinel node before head
        ListNode sentinel = new ListNode(0, head);

        // store nodes >= x in bigList
        ListNode bigList = new ListNode(0);
        ListNode bigListSentinel = bigList;

        // move pointer to check every pointer.next in main linkedlist, remove big node from main to bigList
        ListNode pointer = sentinel;

        while(pointer.next != null) {
            if(pointer.next.val >= x) {
                bigList.next = pointer.next;
                bigList = bigList.next;
                pointer.next = pointer.next.next;
                bigList.next = null;
            } else {
                pointer = pointer.next;
            }
        }

        // concatenate bigList to end of main list
        pointer.next = bigListSentinel.next;

        return sentinel.next;
    }
}
