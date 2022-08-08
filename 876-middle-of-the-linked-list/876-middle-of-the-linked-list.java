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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode initial = head;
        while (head != null) {
            count++;
            head = head.next;
        }

        int middle = (count / 2) + 1;
        for (int i = 1; i < middle; i++) {
            initial = initial.next;
        }
        return initial;
    }
}