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
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        int count = k;
        while (curr != null) {
            count--;
            if (count == 0) {
                ListNode end = curr;
                curr = curr.next;
                end.next = null;
                list.add(head);
                head = curr;
                count = k;
            } else {
                curr = curr.next;
            }
        }
        list.add(head);
        
        ListNode dummy = new ListNode(-1);
        curr = dummy;
        for (int i = 0; i < list.size() - 1; i++) {
            ListNode reversed = reverse(list.get(i));
            curr.next = reversed;
            while (curr.next != null) {
                curr = curr.next;
            }
        }
        curr.next = list.get(list.size() - 1);
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}