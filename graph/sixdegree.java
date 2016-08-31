/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        //BFS level order traversal untill find t
        //注意这里，需要排除相等的情况
        if (s == t) {
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        queue.offer(s);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = queue.poll();
                List<UndirectedGraphNode> neighbors = cur.neighbors;
                for (UndirectedGraphNode neighbor : neighbors) {
                    if (set.contains(neighbor)) {
                        continue;
                    }
                    if (neighbor == t) {
                        return step;
                    }
                    queue.offer(neighbor);
                    //不要忘记set也要加进去
                    set.add(neighbor);
                }
            }
        }
        return -1;
    }
}
