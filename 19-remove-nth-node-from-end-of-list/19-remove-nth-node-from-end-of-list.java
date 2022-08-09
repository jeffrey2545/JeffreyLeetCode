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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        if (n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode remove = dummy;
        ListNode prev = dummy;
        int count = -1;
        while (curr != null) {
            count++;
            if (count >= n) {
                remove = remove.next;
            }
            if (count >= n+1) {
                prev = prev.next;
            }
            curr = curr.next;
        }
        if (count == n && n == 1) {
            return null;
        }
        prev.next = remove.next;
        return dummy.next;
    }
}