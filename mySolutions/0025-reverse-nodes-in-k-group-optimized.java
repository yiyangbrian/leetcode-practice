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
   public ListNode reverseKGroup(ListNode head, int k) {

      ListNode p = head;
      int rounds = 0;
      int count = 0;
      while(p != null) {
         p = p.next;
         count ++;
         if(count == k) {
            count = 0;
            rounds ++;
         }
      }

      ListNode dummyHead = new ListNode(0, head);

      ListNode pre = dummyHead;
      ListNode cur = head;
      ListNode next = head.next;
      if(next == null) return head;

      while(rounds > 0) {
         // reverse each segment

         ListNode preHead = pre;
         ListNode tail = cur;

         int steps = k;
         while(steps > 0) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next == null ? null : next.next;
            steps --;
         }

         preHead.next = pre;
         tail.next = cur;

         pre = tail;

         rounds --;
      }

      return dummyHead.next;
   }
}