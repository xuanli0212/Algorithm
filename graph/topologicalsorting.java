/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        // calculate indegree
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        
        for (DirectedGraphNode cur : graph) {
            for (DirectedGraphNode neighbor: cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        // put indegree == 0 into queue
        for (DirectedGraphNode cur : graph) {
            if (!map.containsKey(cur)) {
                queue.offer (cur);
                result.add(cur);
            }
        }
        // deduct neighbors - 1 and put indegree == 0 into queue. redo untill queue is empty
        while (!queue.isEmpty()){
            DirectedGraphNode head = queue.poll();
            for (DirectedGraphNode neighbor : head.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
       
    }
}
