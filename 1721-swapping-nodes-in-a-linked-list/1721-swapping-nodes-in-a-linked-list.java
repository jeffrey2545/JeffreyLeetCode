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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // find length
        ListNode curr = head;
        int length = 1;
        while (curr!= null) {
          curr = curr.next;
          length++;
        }
        length--;
        // find left right
        ListNode leftNode = new ListNode();
        int left = k;
        ListNode rightNode = new ListNode();
        int right = length - k + 1;
        curr = head;
        length = 1;
        while (curr!= null) {
          if (length == left) {
            leftNode = curr;
          }
          if (length == right) {
            rightNode = curr;
          }
          curr = curr.next;
          length++;
        }

        int temp = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = temp;

        return dummy.next;
    }
}