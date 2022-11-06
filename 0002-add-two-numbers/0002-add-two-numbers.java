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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mul = 1;
        int sum = 0;
        
        ListNode result = new ListNode();
        ListNode dummy = result;
        
        while (l1 != null || l2 != null) {
            sum = sum / 10;
            if (l1 == null) {
                sum = sum + (l2.val);
                // System.out.println(sum);
                l2 = l2.next;
            } else if (l2 == null) {
                sum = sum + (l1.val);
                // System.out.println(sum);
                l1 = l1.next;
            } else {
                sum = sum + (l1.val + l2.val);
                // System.out.println(sum);
                l1 = l1.next;
                l2 = l2.next;
            }
            // System.out.println(sum);
            dummy.val = sum % 10;
            if (l1 != null || l2 != null) {
                ListNode next = new ListNode();
                dummy.next = next;
                dummy = dummy.next;
                // System.out.println("in");
            }
            // mul = mul * 10;
        }
        // System.out.println(sum);
        if (sum / 10 >= 1) {
            
            ListNode next = new ListNode();
            dummy.next = next;
            dummy = dummy.next;
            dummy.val = 1;
        }

        return result;
    }
}