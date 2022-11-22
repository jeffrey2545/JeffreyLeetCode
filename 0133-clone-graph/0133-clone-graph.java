/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> oldGraph = new HashMap<>();
        Map<Integer, Node> newGraph = new HashMap<>();
        // bfs
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        List<Integer> keys = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            List<Node> neighbors = tmpNode.neighbors;
            oldGraph.put(tmpNode.val, tmpNode);
            Node newNode = new Node(tmpNode.val);
            newGraph.put(tmpNode.val, newNode);
            keys.add(tmpNode.val);
            for (Node neighbor : neighbors) {
                if (!oldGraph.containsValue(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // add children
        for (int key : keys) {
            Node oldNode = oldGraph.get(key);
            List<Node> oldNeighbors = oldNode.neighbors;
            
            Node newNode = newGraph.get(key);
            List<Node> newNeighbors = new ArrayList<>();
            
            for (Node oldNeighbor : oldNeighbors) {
                int keyNeighbor = oldNeighbor.val;
                newNeighbors.add(newGraph.get(keyNeighbor));
            }
            newNode.neighbors = newNeighbors;
        }
        
        return newGraph.get(keys.get(0));
    }
}