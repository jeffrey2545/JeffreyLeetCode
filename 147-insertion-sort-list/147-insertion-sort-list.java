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
    public ListNode insertionSortList(ListNode head) {
        ListNode curr = head;
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode insert = result;
        while (curr != null) {
            while (insert != null) {
                if (curr.val >= insert.val) {
                    if (insert.next != null) {
                        if (insert.next.val >= curr.val) {
                            ListNode tmp = insert.next;
                            ListNode insertNode = new ListNode(curr.val);
                            insert.next = insertNode;
                            insertNode.next = tmp;
                            insert = result;
                            break;
                        }
                    } else {
                        insert.next = new ListNode(curr.val);
                        insert = result;
                        break;
                    }
                }
                insert = insert.next;
            }
            curr = curr.next;
        }

        return result.next;
    }
}