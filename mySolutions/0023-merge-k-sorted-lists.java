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


    private int smallestIndex(ListNode[] lists) {
        int index = 0;
        for(int i = 0; i < lists.length; i ++) {
            if(lists[i] == null) {
                continue;
            }
            else if((lists[index] == null && lists[i] != null) ||
                    lists[i].val < lists[index].val) {
                index = i;
            }
        }
        return index; // if each lists[i] is null, then lists[index] will be null
    }

    private ListNode[] updatedLists(ListNode[] lists) {
        int index = smallestIndex(lists);
        lists[index] = lists[index].next;
        return lists;
    }

    private ListNode merge(ListNode[] lists) {
        int index = smallestIndex(lists);
        if(lists.length == 0) {
            return null;
        }
        if(lists[index] == null) {
            return null;
        }
        ListNode node = lists[index];
        node.next = merge(updatedLists(lists));
        return node;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists);
    }
}