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
//Time Complexity - O(V+E)
//Space Complexity - O(V)
class Solution {
    public Node cloneGraph(Node node) {
      HashMap<Node,Node> map = new HashMap<>();
      if(node == null) return null;
      Queue<Node> q = new LinkedList<>();
      //create copy node
      Node copyNode = new Node(node.val);
      map.put(node,copyNode);
      q.add(node);
      
      //bfs
      while(!q.isEmpty()) {
        Node curr = q.poll();
        for(Node neighbor : curr.neighbors) {
          if(!map.containsKey(neighbor)) {
            Node newNode = new Node(neighbor.val);
            map.put(neighbor,newNode);
            q.add(neighbor);
          }
          //currents deep copy push deep copy of original neighbor
          map.get(curr).neighbors.add(map.get(neighbor));
        }
      }
      return map.get(node);
    }
}