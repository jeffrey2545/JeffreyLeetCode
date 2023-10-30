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
    public class Pair {
        ListNode node;
        int index;
        Pair(ListNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
        
        // init
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head == null) {
                continue;
            }
            
            // ListNode head = list;
            if (lists[i] != null) {
                lists[i] = lists[i].next;
            }
            // if (list != null) {
            //     ListNode newHead = new ;
            //     newHead.next = list;
            // }
            
            Pair pair = new Pair(head, i);
            heap.add(pair);
        }
        
        // iterate
        while(!heap.isEmpty()) {
            Pair pair = heap.poll();
            // put it in the ans
            curr.next = pair.node;
            curr = curr.next;
            // put node to heap
            if (lists[pair.index] == null) {// end
                continue;
            }
            ListNode head = lists[pair.index];
            
            // ListNode head = list;
            lists[pair.index] = lists[pair.index].next;
            // if (list != null) {
            //     ListNode newHead = null;
            //     newHead.next = list;
            // }
            
            Pair nextPair = new Pair(head, pair.index);
            heap.add(nextPair);
        }
        return dummy.next;
    }
}
//   4->5,
//   3->4,
//   6
// 1 1 2
// 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6