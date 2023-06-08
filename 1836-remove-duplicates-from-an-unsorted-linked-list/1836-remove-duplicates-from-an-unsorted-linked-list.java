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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = head;
        while (curr != null) {
            if (map.containsKey(curr.val)) {
                int count = map.get(curr.val) + 1;
                map.replace(curr.val, map.get(curr.val), count);
            } else {
                map.put(curr.val, 1);
            }
            curr = curr.next;
        }
        
        ListNode curr2 = head;
        ListNode prev = dummy;
        while (curr2 != null) {
            if (map.get(curr2.val) > 1) {
                prev.next = curr2.next;
                curr2.next = null;
                curr2 = prev.next;
            } else {
                prev = prev.next;
                curr2 = curr2.next;
            }
        }
        
        return dummy.next;
    }
}