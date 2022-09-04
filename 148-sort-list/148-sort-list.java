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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return split(head);
    }
    public ListNode split(ListNode head) {
        ListNode left = head;
        ListNode leftEnd = new ListNode(0);
        ListNode curr = head;
        ListNode right = head;
        while (curr != null) {
            if (curr.next == null) {
                break;
            }
            curr = curr.next.next;
            leftEnd = right;
            right = right.next;
        }
        leftEnd.next = null;
        ListNode mergeLeft = new ListNode(0);
        ListNode mergeRight = new ListNode(0);
        if (left.next == null) {
            mergeLeft = left;
        } else {
            mergeLeft = split(left);
        }
        if (right.next == null) {
            mergeRight = right;
        } else {
            mergeRight = split(right);
        }
        return merge(mergeLeft, mergeRight);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dum = new ListNode(0);
        ListNode curr = dum;
        while (left != null || right != null) {
            if (left != null && (right == null || (left.val < right.val))) {
                curr.next = new ListNode(left.val);
                curr = curr.next;
                left = left.next;
            } else {
                curr.next = new ListNode(right.val);
                curr = curr.next;
                right = right.next;
            }
        }
        return dum.next;
    }
}