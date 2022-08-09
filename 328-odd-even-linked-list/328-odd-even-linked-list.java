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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (head != null && even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
            head = head.next;
        }
        odd.next = evenHead;
        
        return oddHead;
    }
}