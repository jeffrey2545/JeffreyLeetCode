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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int leftVal = list.get(left);
            int rihgtVal = list.get(right);
            if (leftVal != rihgtVal) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}