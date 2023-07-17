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
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        
        int target = size - n;
        curr = dummy;
        while (target > 0) {
            curr = curr.next;
            target--;
        }
        curr.next = curr.next.next;
        
        return dummy.next;
    }
}