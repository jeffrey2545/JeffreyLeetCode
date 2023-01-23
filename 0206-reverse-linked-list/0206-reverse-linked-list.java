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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        ListNode result = new ListNode();
        ListNode curr = result;
        curr.val = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            ListNode newNode = new ListNode();
            newNode.val = list.get(i);
            curr.next = newNode;
            curr = curr.next;
        }
        return result;
    }
}