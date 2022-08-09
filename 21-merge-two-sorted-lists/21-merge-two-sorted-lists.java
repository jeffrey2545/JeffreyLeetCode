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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode curr = result;
        while (list1 != null || list2 != null) {
            ListNode tmp = new ListNode(Integer.MIN_VALUE);
            if (list1 == null || (list2 != null && list1.val >= list2.val)) {
                tmp.val = list2.val;
                curr.next = tmp;
                curr = curr.next;
                list2 = list2.next;
            } else {
                tmp.val = list1.val;
                curr.next = tmp;
                curr = curr.next;
                list1 = list1.next;
            }
        }

        return result.next;
    }
}