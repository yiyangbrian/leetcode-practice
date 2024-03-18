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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode mergedList = dummyHead;

        while(list1 != null || list2 != null) {

            mergedList.next = new ListNode();
            mergedList = mergedList.next;

            if ((list1 != null && list2 == null)
                    || (list1 != null && list2 != null && list1.val <= list2.val)) {
                mergedList.val = list1.val;
                list1 = list1.next;

            } else if((list2 != null && list1 == null)
                    || (list1 != null && list2 != null && list2.val < list1.val)) {
                mergedList.val = list2.val;
                list2 = list2.next;
            }
        }

        return dummyHead.next;
    }
}
