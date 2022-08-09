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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = dummy;
        int tmp = Integer.MIN_VALUE;
        
        while (curr != null) {
            if (curr == dummy) {
                curr = curr.next;
            } else {
                if (tmp != curr.val) {
                    tmp = curr.val;
                    curr = curr.next;
                    prev = prev.next;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
        }
        
        return dummy.next;
    }
}