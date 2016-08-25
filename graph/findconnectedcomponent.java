/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //Map<UndirectedGraphNode. UndirectedGraphNode> map = new HashMap<UndirectedNode, UndirectedNode>();
        HashSet<Integer> allSet = new HashSet<Integer>();
        for (UndirectedGraphNode curNode : nodes) {
            if (!allSet.contains(curNode.label)) {
                HashSet<Integer> curSet = getAllNodes(curNode);
                allSet.addAll(curSet);
                ArrayList<Integer> curList = new ArrayList<Integer>(curSet);
                Collections.sort(curList);
                result.add(curList);
            }
        }
        return result;
        
    }
    private HashSet<Integer> getAllNodes(UndirectedGraphNode node) {
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        set.add(node.label);
        while (!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            ArrayList<UndirectedGraphNode> list = cur.neighbors;
            for (UndirectedGraphNode neighbor : list) {
                if (!set.contains(neighbor.label)){
                    queue.add(neighbor);
                    set.add(neighbor.label);
                }
            }
        }
        return set;
    }
    
}
