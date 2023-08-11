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
    public int pairSum(ListNode head) {
        // 取中間 分一半
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
        }
        // 其中一半reverse
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
          tmp = curr.next;
          curr.next = prev;
          prev = curr;
          curr = tmp;
        }
        // 便例一次
        ListNode head1 = head, head2 = prev;
        int result = Integer.MIN_VALUE;
        while (head2 != null) {
          result = Math.max(head1.val + head2.val, result);
          head1 = head1.next;
          head2 = head2.next;
        }

        return result;
    }
}