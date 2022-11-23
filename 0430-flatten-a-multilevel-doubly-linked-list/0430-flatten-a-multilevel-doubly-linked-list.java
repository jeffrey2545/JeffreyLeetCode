/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        children(head, queue);
        Node result = new Node(queue.poll());
        Node index = result;
        while (!queue.isEmpty()) {
            Node newNode = new Node(queue.poll());
            index.next = newNode;
            newNode.prev = index;
            index = newNode;
        }
        return result;
    }
    public void children(Node head, Queue<Integer> queue) {
        while (head != null) {
            queue.offer(head.val);
            if (head.child != null) {
                children(head.child, queue);
            }
            head = head.next;
        }
        return;
    }
}