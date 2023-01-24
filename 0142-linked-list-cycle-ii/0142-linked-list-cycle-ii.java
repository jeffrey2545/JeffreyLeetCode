/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        // int index = 0;
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return curr;
            }
            set.add(curr);
            curr = curr.next;
            // index++;
        }
        // ListNode no = new ListNode(-1);
        
        return null;
    }
}