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
        // iterate the whole graph, and put nodes into map1 and list1, also copy nodes into map2
        // map<integer, list<integer>>
        // create the new graph, into list2
        HashMap<Integer, Node> map = new HashMap<>();
        // HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        List<Node> order = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node head = queue.poll();
            visited.add(head);
            
            order.add(head);
            Node newNode = new Node(head.val);
            map.put(head.val, newNode);
            // List<Integer> neighborsList = new ArrayList<>();
            for (Node neighbor : head.neighbors) {
                // neighborsList.add(neighbor.val);
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
            // map.put(head.val, neighborsList);
        }
        
        // List<Node> newGraph = new ArrayList<>();
        for (Node head : order) {
            List<Node> newNeighbors = new ArrayList<>();
            for (Node neighbor : head.neighbors) {
                newNeighbors.add(map.get(neighbor.val));
            }
            map.get(head.val).neighbors = newNeighbors;
        }
        
        return map.get(order.get(0).val);
    }
}