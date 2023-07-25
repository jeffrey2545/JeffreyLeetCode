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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
          return head;
        }

        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;

        // ListNode temp = new ListNode();

        while ((odd.next!= null && odd.next.next != null) || (even.next!= null && even.next.next != null)) {
          if (odd.next!= null && odd.next.next != null) {
            // temp = odd.next.next;
            odd.next = odd.next.next;
            odd = odd.next;
          }
          if (even.next!= null && even.next.next != null) {
            // temp = even.next.next;
            even.next = even.next.next;
            even = even.next;
          }
        }

        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }
}